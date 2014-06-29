package co.edu.udea.compumovil.grupo11.yamba.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.text.format.DateUtils;
import android.util.Log;
import android.widget.RemoteViews;
import co.edu.udea.compumovil.grupo11.yamba.R;
import co.edu.udea.compumovil.grupo11.yamba.activity.main.MainActivity;
import co.edu.udea.compumovil.grupo11.yamba.database.contract.StatusContract;

public class YambaAppWidgetProvider extends AppWidgetProvider {
	private static final String TAG = YambaAppWidgetProvider.class.getSimpleName();

	public YambaAppWidgetProvider() {
		super();
	}

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		Log.d(TAG, "onUpdate");

		Cursor cursor = context.getContentResolver().query(
				StatusContract.CONTENT_URI, null, null, null,
				StatusContract.DEFAULT_SORT);
		if (!cursor.moveToFirst()) {
			return;
		}

		String user = cursor.getString(cursor
				.getColumnIndex(StatusContract.Column.USER));
		String message = cursor.getString(cursor
				.getColumnIndex(StatusContract.Column.MESSAGE));
		long createdAt = cursor.getLong(cursor
				.getColumnIndex(StatusContract.Column.CREATED_AT));
		PendingIntent operation = PendingIntent.getActivity(context, -1,
				new Intent(context, MainActivity.class),
				PendingIntent.FLAG_UPDATE_CURRENT);

		for (int appWidgetId : appWidgetIds) {
			RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
					R.layout.widget_yamba);
			remoteViews.setTextViewText(R.id.list_item_text_user_text_view,
					user);
			remoteViews.setTextViewText(R.id.list_item_text_message_text_view,
					message);
			remoteViews.setTextViewText(
					R.id.list_item_text_created_at_text_view,
					DateUtils.getRelativeTimeSpanString(createdAt));
			remoteViews.setOnClickPendingIntent(
					R.id.list_item_text_user_text_view, operation);
			remoteViews.setOnClickPendingIntent(
					R.id.list_item_text_message_text_view, operation);

			appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
		}
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		super.onReceive(context, intent);
		AppWidgetManager appWidgetManager = AppWidgetManager
				.getInstance(context);

		this.onUpdate(context, appWidgetManager, appWidgetManager
				.getAppWidgetIds(new ComponentName(context, YambaAppWidgetProvider.class)));
	}

}
