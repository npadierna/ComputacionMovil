package co.edu.udea.compumovil.ahorcatooth.activity.main;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import co.edu.udea.compumovil.ahorcatooth.R;
import co.edu.udea.compumovil.ahorcatooth.activity.bluetooth.BluetoothDevicesListActivity;
import co.edu.udea.compumovil.ahorcatooth.activity.category.CategoryDashboardActivity;

public class MainActivity extends Activity {

	private static final String TAG = MainActivity.class.getSimpleName();

	private static final int REQUEST_ENABLE_BLUETOOTH = 0;

	private BluetoothAdapter bluetoothAdapter;

	@Override()
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case REQUEST_ENABLE_BLUETOOTH:
			if (resultCode != Activity.RESULT_OK) {
				// FIXME: Show a dialog to display the situation.
			} else {
				super.startActivity(new Intent(super.getApplicationContext(),
						BluetoothDevicesListActivity.class));
			}
			break;
		}
	}

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_main);

		this.bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
	}

	private void startSinglePlayerGame() {
		super.startActivity(new Intent(super.getApplicationContext(),
				CategoryDashboardActivity.class));
	}

	private void startTwoPlayersGame() {
		if (this.bluetoothAdapter == null) {
			// FIXME: Show a dialog to display that Bluetooth is not available.

			return;
		}

		if (!this.bluetoothAdapter.isEnabled()) {
			Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);

			super.startActivityForResult(intent, REQUEST_ENABLE_BLUETOOTH);
		} else {
			super.startActivity(new Intent(super.getApplicationContext(),
					BluetoothDevicesListActivity.class));
		}
	}

	public void onSinglePlayerGamge(View view) {
		Log.i(TAG, "onsinglePlayerGame(View):void");

		this.startSinglePlayerGame();
	}

	public void onTwoPlayersGame(View view) {
		Log.i(TAG, "onTwoPlayersGame(View):void");

		this.startTwoPlayersGame();
	}
}