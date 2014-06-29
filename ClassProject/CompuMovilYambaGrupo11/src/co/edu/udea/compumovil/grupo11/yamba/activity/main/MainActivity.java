package co.edu.udea.compumovil.grupo11.yamba.activity.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import co.edu.udea.compumovil.grupo11.yamba.R;
import co.edu.udea.compumovil.grupo11.yamba.activity.setting.SettingsActivity;
import co.edu.udea.compumovil.grupo11.yamba.database.contract.StatusContract;
import co.edu.udea.compumovil.grupo11.yamba.service.RefreshIntentService;

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
		case R.id.action_purge_main_activity:
			Log.i(TAG, "Action Purge Selected");

			int rows = super.getContentResolver().delete(
					StatusContract.CONTENT_URI, null, null);

			Log.d(TAG, String.format("Delete rows: %s", rows));

			return (true);

		case R.id.action_refresh_main_activity:
			super.startService(new Intent(super.getApplicationContext(),
					RefreshIntentService.class));

			return (true);

		case R.id.action_settings_main_activity:
			Log.i(TAG, "Action Settings Selected");

			super.startActivity(new Intent(super.getApplicationContext(),
					SettingsActivity.class));
			return (true);

		case R.id.action_yamba_main_activity:
			Log.i(TAG, "Action Yamba Selected");

			// super.startActivity(new Intent(super.getApplicationContext(),
			// StatusActivity.class));
			super.startActivity(new Intent(
					"co.edu.udea.compumovil.grupo11.yamba.action.yamba"));

			return (true);
		}

		return (false);
	}
}