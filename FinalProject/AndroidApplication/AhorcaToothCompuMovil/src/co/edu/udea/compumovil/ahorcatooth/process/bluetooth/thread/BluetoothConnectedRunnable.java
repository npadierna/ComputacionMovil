package co.edu.udea.compumovil.ahorcatooth.process.bluetooth.thread;

import java.io.InputStream;
import java.io.OutputStream;

import co.edu.udea.compumovil.ahorcatooth.process.bluetooth.HangmanBluetoothSupportAbstract;
import android.bluetooth.BluetoothSocket;
import android.util.Log;

public class BluetoothConnectedRunnable implements IBluetoothRunnable {

	public static final String TAG = BluetoothConnectedRunnable.class
			.getSimpleName();

	private HangmanBluetoothSupportAbstract hangmanBluetoothSupportAbstract;

	private final InputStream inputStream;
	private final OutputStream outputStream;

	private final BluetoothSocket bluetoothSocket;

	public BluetoothConnectedRunnable(
			HangmanBluetoothSupportAbstract hangmanBluetoothSupportAbstract,
			BluetoothSocket bluetoothSocket) {
		this.hangmanBluetoothSupportAbstract = hangmanBluetoothSupportAbstract;
		this.bluetoothSocket = bluetoothSocket;

		InputStream inputStreamTemp = null;
		OutputStream outputStreamTemp = null;

		try {
			inputStreamTemp = this.bluetoothSocket.getInputStream();
			outputStreamTemp = this.bluetoothSocket.getOutputStream();
		} catch (Exception ex) {
			Log.e(TAG,
					"Fatal error while the application was trying to get the Streams for Bluetooth Socket.",
					ex);
		}

		this.inputStream = inputStreamTemp;
		this.outputStream = outputStreamTemp;
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

		byte[] bufferByte = new byte[1024];
		int bytes;

		while (true) {
			try {
				bytes = this.inputStream.read(bufferByte);

				this.hangmanBluetoothSupportAbstract
						.getHandler()
						.obtainMessage(
								HangmanBluetoothSupportAbstract.HANGMAN_WORD_READ,
								bytes, -1, bufferByte).sendToTarget();
			} catch (Exception ex) {
				Log.e(TAG,
						"Fatal error while the application was trying to read data from the Bluetooth Socket.",
						ex);

				this.hangmanBluetoothSupportAbstract
						.connectionLostToBluetoothDevice();

				break;
			}
		}
	}

	public void write(byte[] buffer) {
		try {
			this.outputStream.write(buffer);

			this.hangmanBluetoothSupportAbstract
					.getHandler()
					.obtainMessage(
							HangmanBluetoothSupportAbstract.HANGMAN_WORD_WRITE,
							-1, -1, buffer).sendToTarget();
		} catch (Exception ex) {
			Log.e(TAG,
					"Fatal error while the application was trying to write data to the Bluetooth Socket.",
					ex);
		}
	}
}