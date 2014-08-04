package co.edu.udea.compumovil.ahorcatooth.process.bluetooth.impl;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import co.edu.udea.compumovil.ahorcatooth.process.bluetooth.HangmanBluetoothSupportAbstract;
import co.edu.udea.compumovil.ahorcatooth.process.bluetooth.enums.HangmanBluetoothStateEnum;
import co.edu.udea.compumovil.ahorcatooth.process.bluetooth.thread.BluetoothAceptRunnable;
import co.edu.udea.compumovil.ahorcatooth.process.bluetooth.thread.BluetoothConnectRunnable;
import co.edu.udea.compumovil.ahorcatooth.process.bluetooth.thread.BluetoothConnectedRunnable;
import co.edu.udea.compumovil.ahorcatooth.process.bluetooth.thread.IBluetoothRunnable;

public class HangmanBluetoothSupport extends HangmanBluetoothSupportAbstract {

	private static final String TAG = HangmanBluetoothSupport.class
			.getSimpleName();

	private IBluetoothRunnable bluetoothAceptRunnable;
	private IBluetoothRunnable bluetoothConnectedRunnable;
	private IBluetoothRunnable bluetoothConnectRunnable;

	public HangmanBluetoothSupport(Context context, Handler handler) {
		super(handler);
	}

	@Override()
	public synchronized void connectedToBluetoothDevice(
			BluetoothSocket bluetoothSocket, BluetoothDevice bluetoothDevice) {

	}

	@Override()
	public void connectionFailedToBluetoothDevice() {

	}

	@Override()
	public void connectionLostToBluetoothDevice() {

	}

	@Override()
	public synchronized void start() {
		Log.i(TAG, "start():void");

		if (this.bluetoothConnectRunnable != null) {
			this.bluetoothConnectRunnable.cancel();
			this.bluetoothConnectRunnable = null;
		}

		if (this.bluetoothConnectedRunnable != null) {
			this.bluetoothConnectedRunnable.cancel();
			this.bluetoothConnectedRunnable = null;
		}

		super.setHangmanBluetoothStateEnum(HangmanBluetoothStateEnum.LISTENING);

		if (this.bluetoothAceptRunnable == null) {
			this.bluetoothAceptRunnable = new BluetoothAceptRunnable(this);
			this.bluetoothAceptRunnable.run();
		}
	}

	@Override()
	public synchronized void stop() {
		Log.i(TAG, "stop():void");

		if (this.bluetoothAceptRunnable != null) {
			this.bluetoothAceptRunnable.cancel();
			this.bluetoothAceptRunnable = null;
		}

		if (this.bluetoothConnectedRunnable != null) {
			this.bluetoothConnectedRunnable.cancel();
			this.bluetoothConnectedRunnable = null;
		}

		if (this.bluetoothConnectRunnable != null) {
			this.bluetoothConnectRunnable.cancel();
			this.bluetoothConnectRunnable = null;
		}

		super.setHangmanBluetoothStateEnum(HangmanBluetoothStateEnum.NOTHING);
	}

	public synchronized void connectToBluetoothDevice(
			BluetoothDevice bluetoothDevice) {
		Log.i(TAG, "connectToBluetoothDevice(BluetoothDevice):void");

		if (super.getHangmanBluetoothStateEnum().equals(
				HangmanBluetoothStateEnum.CONNECTING)) {
			if (this.bluetoothConnectRunnable != null) {
				this.bluetoothConnectRunnable.cancel();
				this.bluetoothConnectRunnable = null;
			}
		}

		if (this.bluetoothConnectedRunnable != null) {
			this.bluetoothConnectedRunnable.cancel();
			this.bluetoothConnectedRunnable = null;
		}

		this.bluetoothConnectRunnable = new BluetoothConnectRunnable(this,
				bluetoothDevice);
		this.bluetoothConnectRunnable.run();

		super.setHangmanBluetoothStateEnum(HangmanBluetoothStateEnum.CONNECTING);
	}

	public void writeHangmanWordName(byte[] hangmanWordName) {
		Log.i(TAG, "writeHangmanWordName(byte[]):void");

		BluetoothConnectedRunnable bluetoothConnectedRunnable;

		synchronized (this) {
			if (!super.getHangmanBluetoothStateEnum().equals(
					HangmanBluetoothStateEnum.CONNECTED)) {

				return;
			}

			bluetoothConnectedRunnable = (BluetoothConnectedRunnable) this.bluetoothConnectedRunnable;
		}

		bluetoothConnectedRunnable.write(hangmanWordName);
	}
}