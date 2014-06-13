package co.edu.udea.compumovil.grupo11.yamba.activity.main.detail;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

public class DetailsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (savedInstanceState == null) {
			Fragment detailsFragment = new DetailsFragment();

			super.getFragmentManager()
					.beginTransaction()
					.add(android.R.id.content, detailsFragment,
							detailsFragment.getClass().getSimpleName())
					.commit();
		}
	}

}