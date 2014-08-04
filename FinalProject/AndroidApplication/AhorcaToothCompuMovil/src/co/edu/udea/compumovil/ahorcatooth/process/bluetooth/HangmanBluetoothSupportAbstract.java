package co.edu.udea.compumovil.ahorcatooth.process.bluetooth;

import java.util.UUID;

import co.edu.udea.compumovil.ahorcatooth.process.bluetooth.enums.HangmanBluetoothStateEnum;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;

public abstract class HangmanBluetoothSupportAbstract {

	public static final UUID SECURE_UUID = UUID
			.fromString("fa87c0d0-afac-11de-8a39-0800200c9a66");
	public static final String SECURE_CONNECTION_NAME = "Bluetooth Connection Secure";

	public static final int HANGMAN_WORD_READ = 0;
	public static final int HANGMAN_WORD_WRITE = 1;

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
	}

	public final BluetoothAdapter getBluetoothAdapter() {

		return (this.bluetoothAdapter);
	}

	public Handler getHandler() {

		return (this.handler);
	}

	public abstract void connectedToBluetoothDevice(
			BluetoothSocket bluetoothSocket, BluetoothDevice bluetoothDevice);

	public abstract void connectionFailedToBluetoothDevice();

	public abstract void connectionLostToBluetoothDevice();

	public abstract void start();

	public abstract void stop();

	public abstract void writeHangmanWordName(byte[] hangmanWordName);
}