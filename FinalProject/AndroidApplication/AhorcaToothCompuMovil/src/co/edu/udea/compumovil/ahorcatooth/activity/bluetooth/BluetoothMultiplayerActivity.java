package co.edu.udea.compumovil.ahorcatooth.activity.bluetooth;

import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import co.edu.udea.compumovil.ahorcatooth.R;

public class BluetoothMultiplayerActivity extends Activity {

	private static final String TAG = BluetoothMultiplayerActivity.class
			.getSimpleName();

	private static final int REQUEST_ENABLE_BLUETOOTH = 0;

	private AlertDialog.Builder errorAlertDialogBuilder;
	private BluetoothAdapter bluetoothAdapter;

	@Override()
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
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

		super.startActivity(new Intent(super.getApplicationContext(),
				BluetoothDevicesListActivity.class));
	}

	public void onPlayerTwoSelected(View view) {
		Log.i(TAG, "onPlayerTwoSelected(View):void");
	}
}