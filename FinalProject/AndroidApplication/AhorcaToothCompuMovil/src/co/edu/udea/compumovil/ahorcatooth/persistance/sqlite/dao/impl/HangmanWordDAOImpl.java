package co.edu.udea.compumovil.ahorcatooth.persistance.sqlite.dao.impl;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
	public List<ContentValues> findHangmanWordsByCategoryNameAndLanguageIsoCode(
			String categoryName, String languageIsoCode) {
		Log.i(TAG,
				"findHangmanWordsByCategoryNameAndLanguageIsoCode(String, String):List<ContentValues>");

		// DEBUGME: Debug this function.
		String selection = String.format("%s = ? AND %s = ?",
				HangmanWordContract.Column.CATEGORY_NAME,
				HangmanWordContract.Column.LANGUAGES_ISO_CODE);
		String[] selectionArgs = new String[] { categoryName, languageIsoCode };
		SQLiteDatabase sqliteDatabase = this.sqliteOpenHelper
				.getReadableDatabase();
		Cursor cursor = sqliteDatabase.query(HangmanWordContract.TABLE_NAME,
				null, selection, selectionArgs, null, null, null);
		List<ContentValues> hangmanWordsContentValues = this
				.convertCursorToContentValues(cursor);

		return (hangmanWordsContentValues);
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

	private List<ContentValues> convertCursorToContentValues(Cursor cursor) {
		// DEBUGME: Debug this function.
		List<ContentValues> contentValuesList = new ArrayList<ContentValues>();

		if ((cursor == null) || (cursor.isClosed())) {

			return (contentValuesList);
		}

		ContentValues contentValues = null;
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			contentValues = new ContentValues();
			for (String columnName : HangmanWordContract.Column.getAllColumns()) {
				contentValues.put(columnName,
						cursor.getString(cursor.getColumnIndex(columnName)));
			}

			contentValuesList.add(contentValues);
			cursor.moveToNext();
		}

		return (contentValuesList);
	}
}