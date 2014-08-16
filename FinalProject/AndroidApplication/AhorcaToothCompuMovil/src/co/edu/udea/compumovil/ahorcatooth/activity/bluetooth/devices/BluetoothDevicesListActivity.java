package co.edu.udea.compumovil.ahorcatooth.activity.bluetooth.devices;

import java.util.Set;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import co.edu.udea.compumovil.ahorcatooth.R;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
public class BluetoothDevicesListActivity extends Activity {

	private static final String TAG = BluetoothDevicesListActivity.class
			.getSimpleName();

	public static final String BLUETOOTH_DEVICE_MAC_ADDRESS = "MAC Address for desired Bluetooth Device";

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
		Log.i(TAG, "buildPairedBluetoothDevices():void");

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

	private void connectWithBluetoothDevice(String bluetoothDeviceMACAddress) {
		Log.d(TAG, String.format("MAC Address: %s", bluetoothDeviceMACAddress));

		this.bluetoothAdapter.cancelDiscovery();

		Intent intent = new Intent();
		intent.putExtra(BLUETOOTH_DEVICE_MAC_ADDRESS, bluetoothDeviceMACAddress);

		super.setResult(Activity.RESULT_OK, intent);
		super.finish();
	}

	private void createViewComponents() {
		Log.i(TAG, "createViewComponents():void");

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
		Log.i(TAG, "registerForBluetoothBroadcastReceiver():void");

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

			String bluetoothDeviceInformation = ((TextView) view).getText()
					.toString();
			connectWithBluetoothDevice(bluetoothDeviceInformation
					.substring(bluetoothDeviceInformation.length() - 17));
		}
	};
}