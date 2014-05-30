package co.edu.udea.compumovil.grupo11.yamba4.activity.setting;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.util.Log;

public class SettingsActivity extends Activity {

	private static final String TAG = SettingsActivity.class.getSimpleName();

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, "onCreate(Bundle)");
		super.onCreate(savedInstanceState);

		if (savedInstanceState == null) {
			PreferenceFragment preferenceFragment = new SettingsPreferenceFragment();
			super.getFragmentManager()
					.beginTransaction()
					.add(android.R.id.content, preferenceFragment,
							preferenceFragment.getClass().getSimpleName())
					.commit();
		}
	}
}