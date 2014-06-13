package co.edu.udea.compumovil.grupo11.yamba5.database.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import co.edu.udea.compumovil.grupo11.yamba5.database.contract.StatusContract;

public class AccessorDataBaseHelper extends SQLiteOpenHelper {

	private static final String TAG = AccessorDataBaseHelper.class
			.getSimpleName();

	public AccessorDataBaseHelper(Context context) {
		super(context, StatusContract.DB_NAME, null, StatusContract.DB_VERSION);
	}

	@Override()
	public void onCreate(SQLiteDatabase db) {
		String sql = String
				.format("CREATE TABLE %s (%s INT PRIMARY KEY, %s TEXT, %s TEXT, %s INT)",
						StatusContract.TABLE, StatusContract.Column.ID,
						StatusContract.Column.USER,
						StatusContract.Column.MESSAGE,
						StatusContract.Column.CREATED_AT);

		Log.d(TAG, "onCreate with SQL: " + sql);

		db.execSQL(sql);
	}

	@Override()
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + StatusContract.TABLE);
		onCreate(db);
	}
}