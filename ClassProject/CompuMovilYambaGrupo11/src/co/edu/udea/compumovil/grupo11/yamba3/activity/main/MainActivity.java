package co.edu.udea.compumovil.grupo11.yamba3.activity.main;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import co.edu.udea.compumovil.grupo11.yamba3.R;
import co.edu.udea.compumovil.grupo11.yamba3.activity.setting.SettingsActivity;
import co.edu.udea.compumovil.grupo11.yamba3.activity.status.StatusActivity;

public class MainActivity extends Activity {

	private static final String TAG = MainActivity.class.getSimpleName();

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_main);
	}

	@Override()
	protected void onStart() {
		super.onStart();

		SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(super.getApplicationContext());
		SharedPreferences.Editor editor = sharedPreferences.edit();

		editor.putString("apiRoot", "http://yamba.marakana.com/api");
		editor.commit();
	}

	@Override()
	public boolean onCreateOptionsMenu(Menu menu) {
		super.getMenuInflater().inflate(R.menu.main, menu);

		return (true);
	}

	@Override()
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_purge_main_activity:
			Log.i(TAG, "Action Purge Selected");

			return (true);

		case R.id.action_refresh_main_activity:
			Log.i(TAG, "Action Refresh Selected");

			return (true);

		case R.id.action_settings_main_activity:
			Log.i(TAG, "Action Settings Selected");

			super.startActivity(new Intent(super.getApplicationContext(),
					SettingsActivity.class));
			return (true);

		case R.id.action_yamba_main_activity:
			Log.i(TAG, "Action Yamba Selected");

			super.startActivity(new Intent(super.getApplicationContext(),
					StatusActivity.class));
			return (true);
		}

		return (false);
	}
}