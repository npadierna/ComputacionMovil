package co.edu.udea.compumovil.ahorcatooth.activity.preference;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
public class WebServicePreferenceActivity extends Activity {

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (savedInstanceState == null) {
			PreferenceFragment preferenceFragment = new WebServicePreferenceFragment();
			super.getFragmentManager()
					.beginTransaction()
					.add(android.R.id.content, preferenceFragment,
							preferenceFragment.getClass().getSimpleName())
					.commit();
		}
	}
}