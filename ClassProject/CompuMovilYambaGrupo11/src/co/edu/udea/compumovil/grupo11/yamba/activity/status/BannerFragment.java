package co.edu.udea.compumovil.grupo11.yamba.activity.status;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import co.edu.udea.compumovil.grupo11.yamba.R;

public class BannerFragment extends Fragment {

	private static final String TAG = BannerFragment.class.getSimpleName();

	@Override()
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i(TAG, "onCreateView(LayoutInflater, ViewGroup, Bundle)");

		View view = inflater
				.inflate(R.layout.fragment_banner, container, false);

		return (view);
	}
}