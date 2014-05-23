package co.edu.udea.compumovil.grupo11.yamba3.activity.setting;

import co.edu.udea.compumovil.grupo11.yamba3.R;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

public class SettingsPreferenceFragment extends PreferenceFragment implements
		OnSharedPreferenceChangeListener {

	private SharedPreferences sharedPreferences;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.addPreferencesFromResource(R.xml.settings);
	}

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {

	}

	@Override()
	public void onStart() {
		super.onStart();
		sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(getActivity());
		sharedPreferences.registerOnSharedPreferenceChangeListener(this);
	}

}
