package co.edu.udea.compumovil.ahorcatooth.persistance.sqlite.dao.impl;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import co.edu.udea.compumovil.ahorcatooth.persistance.contract.LanguagesContract;
import co.edu.udea.compumovil.ahorcatooth.persistance.sqlite.AccessorSQLiteOpenHelper;
import co.edu.udea.compumovil.ahorcatooth.persistance.sqlite.dao.ILanguagesDAO;

public class LanguaguesDAOImpl implements ILanguagesDAO {

	private static final String TAG = LanguaguesDAOImpl.class.getSimpleName();

	private static LanguaguesDAOImpl instance = null;

	private SQLiteOpenHelper sqliteOpenHelper;

	private LanguaguesDAOImpl(Context context) {
		super();

		this.sqliteOpenHelper = new AccessorSQLiteOpenHelper(context);
	}

	public static synchronized LanguaguesDAOImpl getInstance(Context context) {
		if (instance == null) {
			instance = new LanguaguesDAOImpl(context);
		}

		return (instance);
	}

	@Override()
	public List<ContentValues> findAllLanguages() {
		Log.i(TAG, "findAllLanguages():List<ContentValues>");

		// DEBUGME: Debug this function.
		SQLiteDatabase sqliteDatabase = this.sqliteOpenHelper
				.getReadableDatabase();
		Cursor cursor = sqliteDatabase.query(LanguagesContract.TABLE_NAME,
				null, null, null, null, null, null);
		List<ContentValues> categoriesContentValues = this
				.convertCursorToContentValues(cursor);

		return (categoriesContentValues);
	}

	@Override()
	public ContentValues saveLanguages(ContentValues languageContentValues) {
		Log.i(TAG, "saveLanguage(ContentValues):ContentValues");

		SQLiteDatabase sqliteDatabase = this.sqliteOpenHelper
				.getWritableDatabase();
		long rowId = sqliteDatabase.insertWithOnConflict(
				LanguagesContract.TABLE_NAME, null, languageContentValues,
				SQLiteDatabase.CONFLICT_IGNORE);

		return ((rowId != -1L) ? languageContentValues : null);
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
			for (String columnName : LanguagesContract.Column.getAllColumns()) {
				contentValues.put(columnName,
						cursor.getString(cursor.getColumnIndex(columnName)));
			}

			contentValuesList.add(contentValues);
			cursor.moveToNext();
		}

		return (contentValuesList);
	}
}