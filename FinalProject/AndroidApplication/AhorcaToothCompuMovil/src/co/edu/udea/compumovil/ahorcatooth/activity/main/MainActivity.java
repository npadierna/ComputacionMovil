package co.edu.udea.compumovil.ahorcatooth.activity.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import co.edu.udea.compumovil.ahorcatooth.R;
import co.edu.udea.compumovil.ahorcatooth.activity.bluetooth.BluetoothMultiplayerActivity;
import co.edu.udea.compumovil.ahorcatooth.activity.category.CategoryDashboardActivity;
import co.edu.udea.compumovil.ahorcatooth.activity.preference.WebServicePreferenceActivity;

public class MainActivity extends Activity {

	private static final String TAG = MainActivity.class.getSimpleName();

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_main);
	}

	@Override()
	public boolean onCreateOptionsMenu(Menu menu) {
		super.getMenuInflater().inflate(R.menu.menu_main, menu);

		return (true);
	}

	@Override()
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {

		case R.id.menu_action_web_service_preference:
			Log.i(TAG, "Web Service Settings");

			super.startActivity(new Intent(super.getApplicationContext(),
					WebServicePreferenceActivity.class));

			return (true);
		}

		return (false);
	}

	public void onSinglePlayerGamge(View view) {
		Log.i(TAG, "onsinglePlayerGame(View):void");

		super.startActivity(new Intent(super.getApplicationContext(),
				CategoryDashboardActivity.class));
	}

	public void onTwoPlayersGame(View view) {
		Log.i(TAG, "onTwoPlayersGame(View):void");

		super.startActivity(new Intent(super.getApplicationContext(),
				BluetoothMultiplayerActivity.class));
	}
}