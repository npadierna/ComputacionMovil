package co.edu.udea.compumovil.ahorcatooth.activity.preference;

import co.edu.udea.compumovil.ahorcatooth.R;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

public class WebServicePreferenceFragment extends PreferenceFragment implements
		OnSharedPreferenceChangeListener {

	private SharedPreferences sharedPreferences;

	@Override()
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.addPreferencesFromResource(R.xml.settings_web_service);
	}

	@Override()
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {
	}

	@Override()
	public void onStart() {
		super.onStart();

		this.sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(super.getActivity()
						.getApplicationContext());
		this.sharedPreferences.registerOnSharedPreferenceChangeListener(this);
	}
}