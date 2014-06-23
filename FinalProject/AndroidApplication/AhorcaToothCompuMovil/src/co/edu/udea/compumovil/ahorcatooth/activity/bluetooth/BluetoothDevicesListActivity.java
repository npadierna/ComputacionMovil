package co.edu.udea.compumovil.ahorcatooth.activity.bluetooth;

import java.util.Set;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import co.edu.udea.compumovil.ahorcatooth.R;

public class BluetoothDevicesListActivity extends Activity {

	private static final String TAG = BluetoothDevicesListActivity.class
			.getSimpleName();

	private BluetoothDeviceBroadcastReceiver bluetoothDeviceBroadcastReceiver;

	private ArrayAdapter<String> newBluetoothDevicesArrayAdapter;
	private ArrayAdapter<String> pairedBluetoothDevicesArrayAdapter;
	private BluetoothAdapter bluetoothAdapter;

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		super.setContentView(R.layout.activity_bluetooth_devices_list);
		super.setResult(Activity.RESULT_CANCELED);

		this.createViewComponents();
		this.registerForBluetoothBroadcastReceiver();
		this.buildPairedBluetoothDevices();
	}

	@Override()
	protected void onDestroy() {
		super.onDestroy();

		if (this.bluetoothAdapter != null) {
			this.bluetoothAdapter.cancelDiscovery();
		}

		this.unregisterReceiver(this.bluetoothDeviceBroadcastReceiver);
	}

	private void buildPairedBluetoothDevices() {
		this.bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

		Set<BluetoothDevice> pairedBluetoothDevicesSet = this.bluetoothAdapter
				.getBondedDevices();
		if (pairedBluetoothDevicesSet.size() > 0) {
			super.findViewById(R.id.paired_devices_text_view).setVisibility(
					View.VISIBLE);

			for (BluetoothDevice bluetoothDevice : pairedBluetoothDevicesSet) {
				this.pairedBluetoothDevicesArrayAdapter.add(this
						.composeBluetoothDevice(bluetoothDevice));
			}
		} else {
			this.pairedBluetoothDevicesArrayAdapter.add(super
					.getString(R.string.no_paired_devices_title));
		}
	}

	private String composeBluetoothDevice(BluetoothDevice bluetoothDevice) {

		return (String.format("%s\n%s", bluetoothDevice.getName(),
				bluetoothDevice.getAddress()));
	}

	private void createViewComponents() {
		this.newBluetoothDevicesArrayAdapter = new ArrayAdapter<String>(
				super.getApplicationContext(),
				R.layout.list_item_bluetooth_device);
		this.pairedBluetoothDevicesArrayAdapter = new ArrayAdapter<String>(
				super.getApplicationContext(),
				R.layout.list_item_bluetooth_device);

		ListView newBluetoothDevicesListView = (ListView) super
				.findViewById(R.id.new_devices_list_view);
		newBluetoothDevicesListView
				.setAdapter(this.newBluetoothDevicesArrayAdapter);
		newBluetoothDevicesListView
				.setOnItemClickListener(this.bluetoothDeviceItemClickListener);

		ListView pairedBluetoothDevicesListView = (ListView) super
				.findViewById(R.id.paired_devices_list_view);
		pairedBluetoothDevicesListView
				.setAdapter(this.pairedBluetoothDevicesArrayAdapter);
		pairedBluetoothDevicesListView
				.setOnItemClickListener(this.bluetoothDeviceItemClickListener);
	}

	private void registerForBluetoothBroadcastReceiver() {
		this.bluetoothDeviceBroadcastReceiver = new BluetoothDeviceBroadcastReceiver(
				this, this.newBluetoothDevicesArrayAdapter);

		IntentFilter intentFilter = new IntentFilter(
				BluetoothDevice.ACTION_FOUND);
		super.registerReceiver(this.bluetoothDeviceBroadcastReceiver,
				intentFilter);

		intentFilter = new IntentFilter(
				BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
		super.registerReceiver(this.bluetoothDeviceBroadcastReceiver,
				intentFilter);
	}

	private void startDiscovering() {
		Log.i(TAG, "doDiscovering():void");

		super.setProgressBarIndeterminateVisibility(true);
		super.setTitle(super.getString(R.string.scanning_for_devices_title));
		super.findViewById(R.id.new_devices_text_view).setVisibility(
				View.VISIBLE);

		if (this.bluetoothAdapter.isDiscovering()) {
			this.bluetoothAdapter.cancelDiscovery();
		}

		this.bluetoothAdapter.startDiscovery();
	}

	public void onStartScanningDevices(View view) {
		Log.i(TAG, "onStartScanningDevices(View):void");

		view.setVisibility(View.GONE);

		this.startDiscovering();
	}

	private OnItemClickListener bluetoothDeviceItemClickListener = new OnItemClickListener() {

		@Override()
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Log.i(TAG, "onItemClick(AdapterView<?>, View, int, long):void");
		}
	};
}