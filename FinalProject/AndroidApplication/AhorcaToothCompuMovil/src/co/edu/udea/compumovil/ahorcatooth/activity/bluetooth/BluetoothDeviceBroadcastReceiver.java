package co.edu.udea.compumovil.ahorcatooth.activity.bluetooth;

import co.edu.udea.compumovil.ahorcatooth.R;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ArrayAdapter;

final class BluetoothDeviceBroadcastReceiver extends BroadcastReceiver {

	private Activity activity;
	private ArrayAdapter<String> arrayAdapter;

	public BluetoothDeviceBroadcastReceiver(Activity activity,
			ArrayAdapter<String> arrayAdapter) {
		super();

		this.activity = activity;
		this.arrayAdapter = arrayAdapter;
	}

	@Override()
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();

		if (action.equals(BluetoothDevice.ACTION_FOUND)) {
			BluetoothDevice bluetoothDevice = intent
					.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

			if (bluetoothDevice.getBondState() != BluetoothDevice.BOND_BONDED) {
				this.arrayAdapter.add(this
						.composeBluetoothDevice(bluetoothDevice));
			}
		} else if (action.equals(BluetoothAdapter.ACTION_DISCOVERY_FINISHED)) {
			this.activity.setProgressBarIndeterminateVisibility(false);
			this.activity.setTitle(context
					.getString(R.string.select_device_title));

			if (this.arrayAdapter.getCount() == 0) {
				this.arrayAdapter.add(context
						.getString(R.string.no_available_devices_found));
			}
		}
	}

	private String composeBluetoothDevice(BluetoothDevice bluetoothDevice) {

		return (String.format("%s\n%s", bluetoothDevice.getName(),
				bluetoothDevice.getAddress()));
	}
}