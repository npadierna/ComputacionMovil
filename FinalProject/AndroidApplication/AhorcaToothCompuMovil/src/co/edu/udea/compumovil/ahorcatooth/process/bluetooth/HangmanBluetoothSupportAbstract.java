package co.edu.udea.compumovil.ahorcatooth.process.bluetooth;

import java.util.UUID;

import co.edu.udea.compumovil.ahorcatooth.process.bluetooth.enums.HangmanBluetoothStateEnum;
import co.edu.udea.compumovil.ahorcatooth.process.bluetooth.thread.IBluetoothRunnable;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
public abstract class HangmanBluetoothSupportAbstract {

	public static final UUID SECURE_UUID = UUID
			.fromString("FA87C0D0-AFAC-11DE-8A39-0800200C9A66");
	public static final String SECURE_CONNECTION_NAME = "Bluetooth Connection Secure";

	protected IBluetoothRunnable bluetoothAcceptRunnable;
	protected IBluetoothRunnable bluetoothConnectedRunnable;
	protected IBluetoothRunnable bluetoothConnectRunnable;

	public static final int HANGMAN_DEVICE_NAME = 0;
	public static final int HANGMAN_STATE_CHANGED = 1;
	public static final int HANGMAN_TOAST = 2;
	public static final int HANGMAN_WORD_READ = 3;
	public static final int HANGMAN_WORD_WRITE = 4;

	public static final String HANGMAN_DEVICE_NAME_MESSAGE = "Message for the Device Name";
	public static final String HANGMAN_TOAST_MESSAGE = "Message for displaying any information";

	private HangmanBluetoothStateEnum hangmanBluetoothStateEnum;

	private final BluetoothAdapter bluetoothAdapter;
	private final Handler handler;

	public HangmanBluetoothSupportAbstract(Handler handler) {
		this.hangmanBluetoothStateEnum = HangmanBluetoothStateEnum.NOTHING;
		this.bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		this.handler = handler;
	}

	public HangmanBluetoothStateEnum getHangmanBluetoothStateEnum() {

		return (this.hangmanBluetoothStateEnum);
	}

	public synchronized void setHangmanBluetoothStateEnum(
			HangmanBluetoothStateEnum hangmanBluetoothStateEnum) {
		this.hangmanBluetoothStateEnum = hangmanBluetoothStateEnum;

		this.getHandler()
				.obtainMessage(HANGMAN_STATE_CHANGED,
						hangmanBluetoothStateEnum.getState(), -1)
				.sendToTarget();
	}

	public final BluetoothAdapter getBluetoothAdapter() {

		return (this.bluetoothAdapter);
	}

	public Handler getHandler() {

		return (this.handler);
	}

	public IBluetoothRunnable getBluetoothAcceptRunnable() {
		return bluetoothAcceptRunnable;
	}

	public void setBluetoothAcceptRunnable(
			IBluetoothRunnable bluetoothAcceptRunnable) {
		this.bluetoothAcceptRunnable = bluetoothAcceptRunnable;
	}

	public IBluetoothRunnable getBluetoothConnectedRunnable() {

		return bluetoothConnectedRunnable;
	}

	public void setBluetoothConnectedRunnable(
			IBluetoothRunnable bluetoothConnectedRunnable) {
		this.bluetoothConnectedRunnable = bluetoothConnectedRunnable;
	}

	public IBluetoothRunnable getBluetoothConnectRunnable() {

		return bluetoothConnectRunnable;
	}

	public void setBluetoothConnectRunnable(
			IBluetoothRunnable bluetoothConnectRunnable) {
		this.bluetoothConnectRunnable = bluetoothConnectRunnable;
	}

	public abstract void connectToBluetoothDevice(
			BluetoothDevice bluetoothDevice);

	public abstract void connectedToBluetoothDevice(
			BluetoothSocket bluetoothSocket, BluetoothDevice bluetoothDevice);

	public abstract void connectionFailedToBluetoothDevice();

	public abstract void connectionLostToBluetoothDevice();

	public abstract void start();

	public abstract void stop();

	public abstract void writeHangmanWordName(byte[] hangmanWordName);
}