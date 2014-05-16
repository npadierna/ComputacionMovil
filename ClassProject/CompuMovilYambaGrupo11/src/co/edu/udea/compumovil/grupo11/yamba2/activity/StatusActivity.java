package co.edu.udea.compumovil.grupo11.yamba2.activity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import co.edu.udea.compumovil.grupo11.yamba2.R;

public class StatusActivity extends Activity {

	private static final String TAG = StatusActivity.class.getSimpleName();

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, "onCreate(Bundle)");

		super.onCreate(savedInstanceState);
		// super.setContentView(R.layout.activity_status);

		if (savedInstanceState == null) {
			Fragment statusFragment = new StatusFragment();
			Fragment bannerFragment = new BannerFragment();

			super.getFragmentManager()
					.beginTransaction()
					.add(android.R.id.content, statusFragment,
							statusFragment.getClass().getSimpleName()).commit();
			super.getFragmentManager()
					.beginTransaction()
					.add(android.R.id.content, bannerFragment,
							bannerFragment.getClass().getSimpleName()).commit();
		}
	}

	@Override()
	public boolean onCreateOptionsMenu(Menu menu) {
		Log.i(TAG, "onCreateOptionsMenu(Menu)");

		super.getMenuInflater().inflate(R.menu.status, menu);

		return (true);
	}
}