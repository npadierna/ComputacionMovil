package co.edu.udea.compumovil.ahorcatooth.process.bluetooth.thread;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.util.Log;
import co.edu.udea.compumovil.ahorcatooth.process.bluetooth.HangmanBluetoothSupportAbstract;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
public class BluetoothConnectRunnable implements IBluetoothRunnable {

	private static final String TAG = BluetoothConnectRunnable.class
			.getSimpleName();

	private HangmanBluetoothSupportAbstract hangmanBluetoothSupportAbstract;

	private final BluetoothDevice bluetoothDevice;
	private final BluetoothSocket bluetoothSocket;

	public BluetoothConnectRunnable(
			HangmanBluetoothSupportAbstract hangmanBluetoothSupportAbstract,
			BluetoothDevice bluetoothDevice) {
		this.hangmanBluetoothSupportAbstract = hangmanBluetoothSupportAbstract;
		this.bluetoothDevice = bluetoothDevice;

		BluetoothSocket bluetoothSocketTemp = null;

		try {
			bluetoothSocketTemp = this.bluetoothDevice
					.createRfcommSocketToServiceRecord(HangmanBluetoothSupportAbstract.SECURE_UUID);
		} catch (Exception ex) {
			Log.e(TAG,
					"Fatal error while the application was trying to connect to the remote Bluetooth Device.",
					ex);
		}

		this.bluetoothSocket = bluetoothSocketTemp;
	}

	@Override()
	public void cancel() {
		Log.i(TAG, "cancel():void");

		try {
			this.bluetoothSocket.close();
		} catch (Exception ex) {
			Log.e(TAG,
					"Fatal error while the application was trying to close to the Bluetooth Socket.",
					ex);
		}
	}

	@Override()
	public void run() {
		Log.i(TAG, "run():void");

		this.hangmanBluetoothSupportAbstract.getBluetoothAdapter()
				.cancelDiscovery();

		try {
			this.bluetoothSocket.connect();
		} catch (Exception ex1) {
			Log.e(TAG,
					"Fatal error while the application was trying to connect to the Bluetooth Socket.",
					ex1);

			try {
				this.bluetoothSocket.close();
			} catch (Exception ex2) {
				Log.e(TAG,
						"Fatal error while the application was trying to close to the Bluetooth Socket.",
						ex2);
			}

			this.hangmanBluetoothSupportAbstract
					.connectionFailedToBluetoothDevice();

			return;
		}

		synchronized (this.hangmanBluetoothSupportAbstract) {
			// FIXME: WTTFFFF....
			// this.hangmanBluetoothSupportAbstract
			// .setBluetoothConnectRunnable(null);
		}

		this.hangmanBluetoothSupportAbstract.connectedToBluetoothDevice(
				this.bluetoothSocket, this.bluetoothDevice);
	}
}