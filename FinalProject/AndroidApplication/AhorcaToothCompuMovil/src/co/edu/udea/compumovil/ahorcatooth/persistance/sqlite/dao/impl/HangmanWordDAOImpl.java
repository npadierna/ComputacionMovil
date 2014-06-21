package co.edu.udea.compumovil.ahorcatooth.persistance.sqlite.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import co.edu.udea.compumovil.ahorcatooth.persistance.contract.HangmanWordContract;
import co.edu.udea.compumovil.ahorcatooth.persistance.sqlite.AccessorSQLiteOpenHelper;
import co.edu.udea.compumovil.ahorcatooth.persistance.sqlite.dao.IHangmanWordDAO;

public class HangmanWordDAOImpl implements IHangmanWordDAO {

	private static final String TAG = HangmanWordDAOImpl.class.getSimpleName();

	private static HangmanWordDAOImpl instance = null;

	private SQLiteOpenHelper sqliteOpenHelper;

	private HangmanWordDAOImpl(Context context) {
		super();

		this.sqliteOpenHelper = new AccessorSQLiteOpenHelper(context);
	}

	public static synchronized HangmanWordDAOImpl getInstance(Context context) {
		if (instance == null) {
			instance = new HangmanWordDAOImpl(context);
		}

		return (instance);
	}

	@Override()
	public Integer deleteHangmanWord(Long id) {
		Log.i(TAG, "deleteHangmanWord(Long):Integer");

		// DEBUGME: Debug this function.
		String whereClause = String.format("%s = ?",
				HangmanWordContract.Column.ID);
		SQLiteDatabase sqliteDatabase = this.sqliteOpenHelper
				.getWritableDatabase();
		int affectedRows = sqliteDatabase.delete(
				HangmanWordContract.TABLE_NAME, whereClause,
				new String[] { String.valueOf(id.longValue()) });

		return (Integer.valueOf(affectedRows));
	}

	@Override()
	public ContentValues saveHangmanWord(ContentValues hangmanWordContentValues) {
		Log.i(TAG, "saveHangmanWord(ContentValues):ContentValues");

		SQLiteDatabase sqliteDatabase = this.sqliteOpenHelper
				.getWritableDatabase();
		long rowId = sqliteDatabase.insertWithOnConflict(
				HangmanWordContract.TABLE_NAME, null, hangmanWordContentValues,
				SQLiteDatabase.CONFLICT_IGNORE);

		return ((rowId != -1L) ? hangmanWordContentValues : null);
	}
}