package co.edu.udea.compumovil.ahorcatooth.activity.bluetooth;

import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import co.edu.udea.compumovil.ahorcatooth.R;
import co.edu.udea.compumovil.ahorcatooth.activity.bluetooth.devices.BluetoothDevicesListActivity;
import co.edu.udea.compumovil.ahorcatooth.process.bluetooth.HangmanBluetoothSupportAbstract;
import co.edu.udea.compumovil.ahorcatooth.process.bluetooth.enums.HangmanBluetoothStateEnum;
import co.edu.udea.compumovil.ahorcatooth.process.bluetooth.impl.HangmanBluetoothSupport;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
public class BluetoothMultiplayerActivity extends Activity {

	private static final String TAG = BluetoothMultiplayerActivity.class
			.getSimpleName();

	private static final int REQUEST_CONNECT_BLUETOOTH_DEVICE = 0;
	private static final int REQUEST_ENABLE_BLUETOOTH = 1;

	private HangmanBluetoothSupportAbstract hangmanBluetoothSupportAbstract = null;

	private AlertDialog.Builder errorAlertDialogBuilder;
	private BluetoothAdapter bluetoothAdapter;

	@Override()
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case REQUEST_CONNECT_BLUETOOTH_DEVICE:
			if (resultCode == Activity.RESULT_OK) {
				connectToBluetoothDevice(data);
			}
			break;

		case REQUEST_ENABLE_BLUETOOTH:
			if (resultCode != Activity.RESULT_OK) {
				this.errorAlertDialogBuilder
						.setMessage(R.string.no_enabled_bluetooth_message_alert_dialog);
				this.errorAlertDialogBuilder
						.setTitle(R.string.no_enabled_bluetooth_title_alert_dialog);
				this.errorAlertDialogBuilder.show();

				return;
			}
			break;
		}
	}

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_bluetooth_multiplayer);

		this.createComponents();
		this.createBluetoothBrigde();
	}

	@Override()
	protected void onDestroy() {
		super.onDestroy();

		if (this.hangmanBluetoothSupportAbstract != null) {
			this.hangmanBluetoothSupportAbstract.stop();
		}
	}

	@Override()
	protected synchronized void onResume() {
		super.onResume();

		if (this.hangmanBluetoothSupportAbstract != null) {
			if (this.hangmanBluetoothSupportAbstract
					.getHangmanBluetoothStateEnum().equals(
							HangmanBluetoothStateEnum.NOTHING)) {
				this.hangmanBluetoothSupportAbstract.start();
			}
		}
	}

	@Override()
	public boolean onCreateOptionsMenu(Menu menu) {
		super.getMenuInflater()
				.inflate(R.menu.menu_bluetooth_multiplayer, menu);

		return (true);
	}

	@Override()
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_action_become_discoverable:
			Log.i(TAG, String.format("MenuItem: %s", "Become Discoverable"));

			this.becomeBluetoothDeviceDiscoverable();

			return (true);
		}

		return (false);
	}

	private void becomeBluetoothDeviceDiscoverable() {
		if (this.bluetoothAdapter.getScanMode() != BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE) {
			Intent intent = new Intent(
					BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
			intent.putExtra(
					BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION,
					super.getResources().getInteger(
							R.integer.bluetooth_device_discoverable_duration));

			super.startActivity(intent);
		}
	}

	private void connectToBluetoothDevice(Intent data) {
		Log.i(TAG, "connectToBluetoothDevice(Intent):void");

		String bluetoothDeviceMACAddress = data.getExtras().getString(
				BluetoothDevicesListActivity.BLUETOOTH_DEVICE_MAC_ADDRESS);
		BluetoothDevice bluetoothDevice = this.bluetoothAdapter
				.getRemoteDevice(bluetoothDeviceMACAddress);

		this.hangmanBluetoothSupportAbstract
				.connectToBluetoothDevice(bluetoothDevice);
	}

	private void createBluetoothBrigde() {
		this.bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

		if (this.bluetoothAdapter == null) {
			this.errorAlertDialogBuilder
					.setMessage(R.string.no_available_bluetooth_message_alert_dialog);
			this.errorAlertDialogBuilder
					.setTitle(R.string.no_available_bluetooth_title_alert_dialog);
			this.errorAlertDialogBuilder.show();

			return;
		}

		if (!this.bluetoothAdapter.isEnabled()) {
			super.startActivityForResult(new Intent(
					BluetoothAdapter.ACTION_REQUEST_ENABLE),
					REQUEST_ENABLE_BLUETOOTH);
		}

		if (this.hangmanBluetoothSupportAbstract == null) {
			this.hangmanBluetoothSupportAbstract = new HangmanBluetoothSupport(
					super.getApplicationContext(), this.hangmanbluetoothHandler);
		}
	}

	private void createComponents() {
		Log.i(TAG, "createComponents():void");

		this.errorAlertDialogBuilder = new AlertDialog.Builder(this);
		this.errorAlertDialogBuilder.setPositiveButton(
				R.string.label_accept_button,
				new DialogInterface.OnClickListener() {

					@Override()
					public void onClick(DialogInterface dialog, int which) {
						BluetoothMultiplayerActivity.super.finish();
					}
				});
	}

	public void onPlayerOneSelected(View view) {
		Log.i(TAG, "onPlayerSelected(View):void");

		super.startActivityForResult(new Intent(super.getApplicationContext(),
				BluetoothDevicesListActivity.class),
				REQUEST_CONNECT_BLUETOOTH_DEVICE);
	}

	public void onPlayerTwoSelected(View view) {
		Log.i(TAG, "onPlayerTwoSelected(View):void");
	}

	private final Handler hangmanbluetoothHandler = new Handler() {

		@Override()
		public void handleMessage(Message message) {
			byte[] buffer = (byte[]) message.obj;
			String hangmanWord = null;

			switch (message.what) {
			case HangmanBluetoothSupportAbstract.HANGMAN_DEVICE_NAME:

				break;

			case HangmanBluetoothSupportAbstract.HANGMAN_STATE_CHANGED:
				switch (HangmanBluetoothStateEnum.findByState(message.arg1)) {
				case NOTHING:
					break;

				case LISTENING:
					break;

				case CONNECTING:
					break;

				case CONNECTED:
					break;

				default:
					break;
				}
				break;

			case HangmanBluetoothSupportAbstract.HANGMAN_TOAST:
				Toast.makeText(
						getApplicationContext(),
						message.getData()
								.getString(
										HangmanBluetoothSupportAbstract.HANGMAN_TOAST_MESSAGE),
						Toast.LENGTH_LONG).show();
				break;

			case HangmanBluetoothSupportAbstract.HANGMAN_WORD_READ:
				hangmanWord = new String(buffer, 0, message.arg1);

				// FIXME: What have we do?
				break;

			case HangmanBluetoothSupportAbstract.HANGMAN_WORD_WRITE:
				hangmanWord = new String(buffer);

				// FIXME: What have we do?
				break;
			}
		}
	};
}