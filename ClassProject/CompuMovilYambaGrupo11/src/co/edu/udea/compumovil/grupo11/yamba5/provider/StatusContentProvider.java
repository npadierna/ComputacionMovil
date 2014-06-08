package co.edu.udea.compumovil.grupo11.yamba5.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import co.edu.udea.compumovil.grupo11.yamba5.database.contract.StatusContract;
import co.edu.udea.compumovil.grupo11.yamba5.database.dao.AccessorDataBaseHelper;

public class StatusContentProvider extends ContentProvider {
	private static final String TAG = StatusContentProvider.class
			.getSimpleName();

	private static final UriMatcher URI_MATCHER = new UriMatcher(
			UriMatcher.NO_MATCH);
	static {
		URI_MATCHER.addURI(StatusContract.AUTHORITY,
				StatusContract.STATUS_LEVEL, StatusContract.STATUS_DIR);

		URI_MATCHER.addURI(StatusContract.AUTHORITY,
				StatusContract.STATUS_LEVEL + "/#", StatusContract.STATUS_ITEM);
	}

	private AccessorDataBaseHelper accessorDataBaseHelper;

	@Override()
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		String where;

		switch (URI_MATCHER.match(uri)) {
		case StatusContract.STATUS_DIR:
			where = (selection == null) ? "1" : selection;
			break;

		case StatusContract.STATUS_ITEM:
			long id = ContentUris.parseId(uri);
			where = StatusContract.DataBaseColumn.ID
					+ "="
					+ id
					+ (TextUtils.isEmpty(selection) ? "" : " and ( "
							+ selection + " )");
			break;

		default:
			throw new IllegalArgumentException("Illegal uri: " + uri);
		}

		SQLiteDatabase db = this.accessorDataBaseHelper.getWritableDatabase();
		int result = db.delete(StatusContract.TABLE, where, selectionArgs);
		if (result > 0) {
			super.getContext().getContentResolver().notifyChange(uri, null);
		}

		Log.d(TAG, "deleted records: " + result);

		return (result);
	}

	@Override()
	public String getType(Uri uri) {
		switch (URI_MATCHER.match(uri)) {
		case StatusContract.STATUS_DIR:
			Log.d(TAG, "gotType: " + StatusContract.STATUS_TYPE_DIR);
			return (StatusContract.STATUS_TYPE_DIR);

		case StatusContract.STATUS_ITEM:
			Log.d(TAG, "gotType: " + StatusContract.STATUS_TYPE_ITEM);
			return (StatusContract.STATUS_TYPE_ITEM);

		default:
			throw new IllegalArgumentException("Illegal uri: " + uri);
		}
	}

	@Override()
	public Uri insert(Uri uri, ContentValues values) {
		Uri ret = null;

		if (URI_MATCHER.match(uri) != StatusContract.STATUS_DIR) {
			throw new IllegalArgumentException("Illegal uri: " + uri);
		}

		SQLiteDatabase db = this.accessorDataBaseHelper.getWritableDatabase();
		long rowId = db.insertWithOnConflict(StatusContract.TABLE, null,
				values, SQLiteDatabase.CONFLICT_IGNORE);

		if (rowId != -1) {
			long id = values.getAsLong(StatusContract.DataBaseColumn.ID);

			ret = ContentUris.withAppendedId(uri, id);
			getContext().getContentResolver().notifyChange(uri, null);

			Log.d(TAG, "inserted uri: " + ret);
		}

		return (ret);
	}

	@Override()
	public boolean onCreate() {
		this.accessorDataBaseHelper = new AccessorDataBaseHelper(
				super.getContext());

		return (true);
	}

	@Override()
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
		qb.setTables(StatusContract.TABLE);

		switch (URI_MATCHER.match(uri)) {
		case StatusContract.STATUS_DIR:
			break;

		case StatusContract.STATUS_ITEM:
			qb.appendWhere(StatusContract.DataBaseColumn.ID + "="
					+ uri.getLastPathSegment());
			break;

		default:
			throw new IllegalArgumentException("Illegal uri: " + uri);
		}

		String orderBy = (TextUtils.isEmpty(sortOrder)) ? StatusContract.DEFAULT_SORT
				: sortOrder;
		SQLiteDatabase db = this.accessorDataBaseHelper.getReadableDatabase();
		Cursor cursor = qb.query(db, projection, selection, selectionArgs,
				null, null, orderBy);
		cursor.setNotificationUri(getContext().getContentResolver(), uri);

		Log.d(TAG, "queried records: " + cursor.getCount());

		return (cursor);
	}

	@Override()
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		String where;

		switch (URI_MATCHER.match(uri)) {
		case StatusContract.STATUS_DIR:
			where = selection;
			break;

		case StatusContract.STATUS_ITEM:
			long id = ContentUris.parseId(uri);
			where = StatusContract.DataBaseColumn.ID
					+ "="
					+ id
					+ (TextUtils.isEmpty(selection) ? "" : " and ( "
							+ selection + " )");
			break;

		default:
			throw new IllegalArgumentException("Illegal uri: " + uri);
		}

		SQLiteDatabase db = this.accessorDataBaseHelper.getWritableDatabase();
		int result = db.update(StatusContract.TABLE, values, where,
				selectionArgs);
		if (result > 0) {
			super.getContext().getContentResolver().notifyChange(uri, null);
		}

		Log.d(TAG, "updated records: " + result);

		return (result);
	}
}