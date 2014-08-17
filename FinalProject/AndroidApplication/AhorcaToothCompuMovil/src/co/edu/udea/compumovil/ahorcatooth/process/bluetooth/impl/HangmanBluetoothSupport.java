package co.edu.udea.compumovil.ahorcatooth.process.bluetooth.impl;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import co.edu.udea.compumovil.ahorcatooth.R;
import co.edu.udea.compumovil.ahorcatooth.process.bluetooth.HangmanBluetoothSupportAbstract;
import co.edu.udea.compumovil.ahorcatooth.process.bluetooth.enums.HangmanBluetoothStateEnum;
import co.edu.udea.compumovil.ahorcatooth.process.bluetooth.thread.BluetoothAcceptRunnable;
import co.edu.udea.compumovil.ahorcatooth.process.bluetooth.thread.BluetoothConnectRunnable;
import co.edu.udea.compumovil.ahorcatooth.process.bluetooth.thread.BluetoothConnectedRunnable;
import co.edu.udea.compumovil.ahorcatooth.process.bluetooth.thread.IBluetoothRunnable;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
public class HangmanBluetoothSupport extends HangmanBluetoothSupportAbstract {

	private static final String TAG = HangmanBluetoothSupport.class
			.getSimpleName();

	private IBluetoothRunnable bluetoothAcceptRunnable;
	private IBluetoothRunnable bluetoothConnectedRunnable;
	private IBluetoothRunnable bluetoothConnectRunnable;

	private Context context;

	public HangmanBluetoothSupport(Context context, Handler handler) {
		super(handler);

		this.context = context;
	}

	@Override()
	public synchronized void connectedToBluetoothDevice(
			BluetoothSocket bluetoothSocket, BluetoothDevice bluetoothDevice) {
		Log.i(TAG,
				"connectedToBluetoothDevice(BluetoothSocket, BluetoothDevice):void");

		if (this.bluetoothConnectRunnable != null) {
			this.bluetoothConnectRunnable.cancel();
			this.bluetoothConnectRunnable = null;
		}

		if (this.bluetoothConnectedRunnable != null) {
			this.bluetoothConnectedRunnable.cancel();
			this.bluetoothConnectedRunnable = null;
		}

		if (this.bluetoothAcceptRunnable != null) {
			this.bluetoothAcceptRunnable.cancel();
			this.bluetoothAcceptRunnable = null;
		}

		this.bluetoothConnectedRunnable = new BluetoothConnectedRunnable(this,
				bluetoothSocket);
		this.bluetoothConnectedRunnable.run();

		Bundle bundle = new Bundle();
		bundle.putString(
				HangmanBluetoothSupportAbstract.HANGMAN_DEVICE_NAME_MESSAGE,
				bluetoothDevice.getName());

		Message message = super.getHandler().obtainMessage(
				HangmanBluetoothSupportAbstract.HANGMAN_DEVICE_NAME);
		message.setData(bundle);

		super.getHandler().sendMessage(message);
		super.setHangmanBluetoothStateEnum(HangmanBluetoothStateEnum.CONNECTED);
	}

	@Override()
	public void connectionFailedToBluetoothDevice() {
		Log.i(TAG, "connectionFailedToBluetoothDevice():void");

		Bundle bundle = new Bundle();
		bundle.putString(
				HangmanBluetoothSupportAbstract.HANGMAN_TOAST_MESSAGE,
				this.context
						.getString(R.string.hangman_bluetooth_support_fail_connection_message));

		Message message = super.getHandler().obtainMessage(
				HangmanBluetoothSupportAbstract.HANGMAN_TOAST);
		message.setData(bundle);

		super.getHandler().sendMessage(message);

		HangmanBluetoothSupport.this.start();
	}

	@Override()
	public void connectionLostToBluetoothDevice() {
		Log.i(TAG, "connectionLostToBluetoothDevice():void");

		Bundle bundle = new Bundle();
		bundle.putString(
				HangmanBluetoothSupportAbstract.HANGMAN_TOAST_MESSAGE,
				this.context
						.getString(R.string.hangman_bluetooth_support_lost_connection_message));

		Message message = super.getHandler().obtainMessage(
				HangmanBluetoothSupportAbstract.HANGMAN_TOAST);
		message.setData(bundle);

		super.getHandler().sendMessage(message);

		HangmanBluetoothSupport.this.start();
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

		if (this.bluetoothAcceptRunnable == null) {
			this.bluetoothAcceptRunnable = new BluetoothAcceptRunnable(this);
			this.bluetoothAcceptRunnable.run();
		}
	}

	@Override()
	public synchronized void stop() {
		Log.i(TAG, "stop():void");

		if (this.bluetoothAcceptRunnable != null) {
			this.bluetoothAcceptRunnable.cancel();
			this.bluetoothAcceptRunnable = null;
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

	@Override()
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