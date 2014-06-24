package co.edu.udea.compumovil.ahorcatooth.activity.bluetooth;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
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

	private BluetoothAdapter bluetoothAdapter;

	@Override()
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case REQUEST_ENABLE_BLUETOOTH:
			if (resultCode != Activity.RESULT_OK) {
				// FIXME: Show a dialog to display the situation and finish this
				// activity.
			}
			break;
		}
	}

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_bluetooth_multiplayer);

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
			// FIXME: Show a dialog to display that Bluetooth is not available
			// and finish this activity.

			return;
		}

		if (!this.bluetoothAdapter.isEnabled()) {
			Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);

			super.startActivityForResult(intent, REQUEST_ENABLE_BLUETOOTH);
		}
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