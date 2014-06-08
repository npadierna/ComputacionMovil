package co.edu.udea.compumovil.grupo11.example1.database.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import co.edu.udea.compumovil.grupo11.example1.database.contract.PersonContract;

public final class PersonDatabaseHelper extends SQLiteOpenHelper {

	private static final String TAG = PersonDatabaseHelper.class
			.getSimpleName();

	public PersonDatabaseHelper(Context context) {
		super(context, PersonContract.DATABASE_NAME, null,
				PersonContract.DATABASE_VERSION);
	}

	@Override()
	public void onCreate(SQLiteDatabase db) {
		String sql = String
				.format("CREATE TABLE %s (%s TEXT, %s TEXT, %s TEXT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s TEXT, %s TEXT, %s INTEGER NOT NULL, %s REAL, PRIMARY KEY (%s, %s))",
						PersonContract.TABLE_NAME,
						PersonContract.Column.DOCUMENT_TYPE,
						PersonContract.Column.ID_NUMBER,
						PersonContract.Column.FIRST_NAMES,
						PersonContract.Column.LAST_NAMES,
						PersonContract.Column.BIRTHDAY,
						PersonContract.Column.E_MAIL,
						PersonContract.Column.PHONE_NUMBER,
						PersonContract.Column.AGE,
						PersonContract.Column.HEIGHT,
						PersonContract.Column.DOCUMENT_TYPE,
						PersonContract.Column.ID_NUMBER);

		Log.d(TAG, String.format("SQL Creator Statement: %s", sql));

		db.execSQL(sql);

		Log.i(TAG, String.format("Table: \"%s\" was created into %s Database.",
				PersonContract.TABLE_NAME, PersonContract.DATABASE_NAME));
	}

	@Override()
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String sql = String.format("DROP TABLE IF EXISTS %S",
				PersonContract.TABLE_NAME);

		Log.d(TAG, String.format("SQL Dropper Statement: %s", sql));

		db.execSQL(sql);

		this.onCreate(db);
	}
}