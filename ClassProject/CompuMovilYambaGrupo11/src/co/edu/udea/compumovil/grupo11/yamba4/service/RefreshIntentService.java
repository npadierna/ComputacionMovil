package co.edu.udea.compumovil.grupo11.yamba4.service;

import java.util.List;

import com.marakana.android.yamba.clientlib.YambaClient;
import com.marakana.android.yamba.clientlib.YambaClient.Status;

import co.edu.udea.compumovil.grupo11.yamba4.R;
import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

public class RefreshIntentService extends IntentService {

	private static final int MAX_TIME_LINE = 20;
	private static final String SERVICE_REFRESH_NAME = "Refresh Service for Yamba";
	private static final String TAG = RefreshIntentService.class
			.getSimpleName();

	public RefreshIntentService() {
		super(SERVICE_REFRESH_NAME);
	}

	@Override()
	public void onCreate() {
		super.onCreate();

		Log.i(TAG, "onCreate()");
	}

	@Override()
	protected void onHandleIntent(Intent intent) {
		SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(super.getApplicationContext());
		final String userName = sharedPreferences.getString("userName", "");
		final String password = sharedPreferences.getString("password", "");
		// final String apiRoot = sharedPreferences.getString("apiRoot",
		// "http://yamba.marakana.com/api");

		// if ((TextUtils.isEmpty(apiRoot)) || (TextUtils.isEmpty(password))
		// || (TextUtils.isEmpty(userName))) {
		if ((TextUtils.isEmpty(password)) || (TextUtils.isEmpty(userName))) {
			Toast.makeText(super.getApplicationContext(),
					R.string.fail_intent_refresh_service, Toast.LENGTH_LONG)
					.show();

			return;
		}

		// YambaClient yambaClient = new YambaClient(userName, password,
		// apiRoot);
		YambaClient yambaClient = new YambaClient(userName, password);
		try {
			List<Status> statusTimeLineList = yambaClient.getTimeline(MAX_TIME_LINE);
			Log.d(TAG,
					"Status Time Line List size: " + statusTimeLineList.size());
			for (Status status : statusTimeLineList) {
				Log.i(TAG,
						String.format("%s -> %s", status.getUser(),
								status.getMessage()));
			}

		} catch (Exception e) {
			Log.e(TAG,
					"A exception was thrown while the Time Line's status was retrieved",
					e);
			e.printStackTrace();
		}

		return;
	}

	@Override()
	public void onDestroy() {
		super.onDestroy();

		Log.i(TAG, "onDestroy()");
	}
}