package co.edu.udea.compumovil.grupo11.yamba.broadcast;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import co.edu.udea.compumovil.grupo11.yamba.service.RefreshIntentService;

public class BooterBroadcastReceiver extends BroadcastReceiver {

	private static final String TAG = BooterBroadcastReceiver.class
			.getSimpleName();

	private static final long DEFAULT_INTERVAL = AlarmManager.INTERVAL_FIFTEEN_MINUTES;

	@Override()
	public void onReceive(Context context, Intent intent) {
		SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(context);
		long interval = Long.parseLong(sharedPreferences.getString(
				"refreshingInterval", Long.toString(DEFAULT_INTERVAL)));
		PendingIntent pendingOperation = PendingIntent.getService(context, -1,
				new Intent(context, RefreshIntentService.class),
				PendingIntent.FLAG_UPDATE_CURRENT);
		AlarmManager alarmManager = (AlarmManager) context
				.getSystemService(Context.ALARM_SERVICE);

		if (interval == 0L) {
			alarmManager.cancel(pendingOperation);

			Log.d(TAG, "Cancelling repeat operation");
		} else {
			alarmManager.setInexactRepeating(AlarmManager.RTC,
					System.currentTimeMillis(), interval, pendingOperation);

			Log.d(TAG, String.format("%s: %d", "Setting repeat operation for",
					interval));
		}

		Log.d(TAG, "onReceived(Context, Intent)");
	}
}