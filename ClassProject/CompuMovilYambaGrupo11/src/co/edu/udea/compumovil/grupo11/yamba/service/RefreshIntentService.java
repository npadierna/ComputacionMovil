package co.edu.udea.compumovil.grupo11.yamba.service;

import java.util.List;

import android.app.IntentService;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import co.edu.udea.compumovil.grupo11.yamba.R;
import co.edu.udea.compumovil.grupo11.yamba.database.contract.StatusContract;

import com.marakana.android.yamba.clientlib.YambaClient;
import com.marakana.android.yamba.clientlib.YambaClient.Status;

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
		final String apiRoot = sharedPreferences.getString("apiRoot",
				"http://yamba.marakana.com/api");

		if ((TextUtils.isEmpty(apiRoot)) || (TextUtils.isEmpty(password))
				|| (TextUtils.isEmpty(userName))) {
			Toast.makeText(super.getApplicationContext(),
					R.string.fail_intent_refresh_service, Toast.LENGTH_LONG)
					.show();

			return;
		}

		ContentValues contentValues = new ContentValues();
		YambaClient yambaClient = new YambaClient(userName, password, apiRoot);
		try {
			List<Status> statusTimeLineList = yambaClient
					.getTimeline(MAX_TIME_LINE);
			for (Status status : statusTimeLineList) {
				contentValues.clear();
				contentValues.put(StatusContract.Column.ID,
						status.getId());
				contentValues.put(StatusContract.Column.USER,
						status.getUser());
				contentValues.put(StatusContract.Column.MESSAGE,
						status.getMessage());
				contentValues.put(StatusContract.Column.CREATED_AT,
						status.getCreatedAt().getTime());

				Uri uri = super.getContentResolver().insert(
						StatusContract.CONTENT_URI, contentValues);
				if (uri != null) {
					Log.d(TAG,
							String.format("%s: %s", status.getUser(),
									status.getMessage()));
				}

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