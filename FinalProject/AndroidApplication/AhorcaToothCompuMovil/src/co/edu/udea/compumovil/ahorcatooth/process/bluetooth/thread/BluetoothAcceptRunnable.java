package co.edu.udea.compumovil.ahorcatooth.process.bluetooth.thread;

import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.util.Log;
import co.edu.udea.compumovil.ahorcatooth.process.bluetooth.HangmanBluetoothSupportAbstract;
import co.edu.udea.compumovil.ahorcatooth.process.bluetooth.enums.HangmanBluetoothStateEnum;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
public class BluetoothAcceptRunnable implements IBluetoothRunnable {

	private static final String TAG = BluetoothAcceptRunnable.class
			.getSimpleName();

	private HangmanBluetoothSupportAbstract hangmanBluetoothSupportAbstract;

	private final BluetoothServerSocket bluetoothServerSocket;

	public BluetoothAcceptRunnable(
			HangmanBluetoothSupportAbstract hangmanBluetoothSupportAbstract) {
		this.hangmanBluetoothSupportAbstract = hangmanBluetoothSupportAbstract;

		BluetoothServerSocket bluetoothServerSocketTemp = null;

		try {
			bluetoothServerSocketTemp = this.hangmanBluetoothSupportAbstract
					.getBluetoothAdapter()
					.listenUsingInsecureRfcommWithServiceRecord(
							HangmanBluetoothSupportAbstract.SECURE_CONNECTION_NAME,
							HangmanBluetoothSupportAbstract.SECURE_UUID);
		} catch (Exception ex) {
			Log.e(TAG,
					"Fatal error while the application was trying to listen to the remote Bluetooth Device.",
					ex);
		}

		this.bluetoothServerSocket = bluetoothServerSocketTemp;
	}

	@Override()
	public void cancel() {
		Log.i(TAG, "cancel():void");

		try {
			this.bluetoothServerSocket.close();
		} catch (Exception ex) {
			Log.e(TAG,
					"Fatal error while the application was trying to close to the Bluetooth Server Socket.",
					ex);
		}
	}

	@Override()
	public void run() {
		Log.i(TAG, "run():void");

		BluetoothSocket bluetoothSocket = null;

		while (!this.hangmanBluetoothSupportAbstract
				.getHangmanBluetoothStateEnum().equals(
						HangmanBluetoothStateEnum.CONNECTED)) {
			try {
				bluetoothSocket = this.bluetoothServerSocket.accept();
			} catch (Exception ex) {
				Log.e(TAG,
						"Fatal error while the application was trying to accept to the Bluetooth Socket.",
						ex);
				break;
			}

			if (bluetoothSocket != null) {
				synchronized (this.hangmanBluetoothSupportAbstract) {
					switch (this.hangmanBluetoothSupportAbstract
							.getHangmanBluetoothStateEnum()) {
					case LISTENING:
					case CONNECTING:
						this.hangmanBluetoothSupportAbstract
								.connectedToBluetoothDevice(bluetoothSocket,
										bluetoothSocket.getRemoteDevice());
						break;

					case NOTHING:
					case CONNECTED:
						try {
							bluetoothSocket.close();
						} catch (Exception ex) {
							Log.e(TAG,
									"Fatal error while the application was trying to close to the Bluetooth Socket.",
									ex);
						}
						break;
					}
				}
			}
		}
	}
}