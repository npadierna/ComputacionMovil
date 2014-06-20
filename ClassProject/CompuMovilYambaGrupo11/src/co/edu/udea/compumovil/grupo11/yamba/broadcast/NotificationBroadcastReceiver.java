package co.edu.udea.compumovil.grupo11.yamba.broadcast;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import co.edu.udea.compumovil.grupo11.yamba.R;
import co.edu.udea.compumovil.grupo11.yamba.activity.main.MainActivity;

public class NotificationBroadcastReceiver extends BroadcastReceiver {

	public static final int NOTIFICATION_ID = 42;
	public static final String NOTIFICATION_COUNTER_KEY = "Counter Key";

	@Override()
	public void onReceive(Context context, Intent intent) {
		NotificationManager notificationManager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		int counter = intent.getIntExtra(NOTIFICATION_COUNTER_KEY, 0);
		PendingIntent pendingIntent = PendingIntent.getActivity(context, -1,
				new Intent(context, MainActivity.class),
				PendingIntent.FLAG_ONE_SHOT);
		Notification notification = new Notification.Builder(context)
				.setContentTitle(
						context.getString(R.string.new_tweets_title_notification))
				.setContentText(
						String.format(
								"%s %d %s",
								context.getString(R.string.new_tweets_first_part_text_notification),
								counter,
								context.getString(R.string.new_tweets_second_part_text_notification)))
				.setSmallIcon(android.R.drawable.sym_action_email)
				.setContentIntent(pendingIntent)
				.setAutoCancel(true)
				.setSound(
						RingtoneManager
								.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
				.setLights(0x00FF00, 5000, 5000).getNotification();

		notificationManager.notify(NOTIFICATION_ID, notification);
	}
}