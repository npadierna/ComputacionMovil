package co.edu.udea.compumovil.ahorcatooth.persistance.sqlite.dao.impl;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import co.edu.udea.compumovil.ahorcatooth.persistance.contract.CategoryContract;
import co.edu.udea.compumovil.ahorcatooth.persistance.sqlite.AccessorSQLiteOpenHelper;
import co.edu.udea.compumovil.ahorcatooth.persistance.sqlite.dao.ICategoryDAO;

public class CategoryDAOImpl implements ICategoryDAO {

	private static final String TAG = CategoryDAOImpl.class.getSimpleName();

	private static CategoryDAOImpl instance = null;

	private SQLiteOpenHelper sqliteOpenHelper;

	private CategoryDAOImpl(Context context) {
		super();

		this.sqliteOpenHelper = new AccessorSQLiteOpenHelper(context);
	}

	public static synchronized CategoryDAOImpl getInstance(Context context) {
		if (instance == null) {
			instance = new CategoryDAOImpl(context);
		}

		return (instance);
	}

	@Override()
	public List<ContentValues> findAllCategories() {
		Log.i(TAG, "findAllCategories():List<ContentValues>");

		// DEBUGME: Debug this function.
		SQLiteDatabase sqliteDatabase = this.sqliteOpenHelper
				.getReadableDatabase();
		Cursor cursor = sqliteDatabase.query(CategoryContract.TABLE_NAME, null,
				null, null, null, null, null);
		List<ContentValues> categoriesContentValues = this
				.convertCursorToContentValues(cursor);

		cursor.close();

		return (categoriesContentValues);
	}

	@Override()
	public List<ContentValues> findCategoriesByLanguageIsoCode(
			String languageIsoCode) {
		Log.i(TAG, "findCategoriesByLanguageIsoCode():List<ContentValues>");

		// DEBUGME: Debug this function.
		String selection = String.format("%s = ?",
				CategoryContract.Column.LANGUAGES_ISO_CODE);
		String[] selectionArgs = new String[] { languageIsoCode };
		SQLiteDatabase sqliteDatabase = this.sqliteOpenHelper
				.getReadableDatabase();
		Cursor cursor = sqliteDatabase.query(CategoryContract.TABLE_NAME, null,
				selection, selectionArgs, null, null, null);
		List<ContentValues> categoriesContentValues = this
				.convertCursorToContentValues(cursor);

		cursor.close();

		return (categoriesContentValues);
	}

	@Override()
	public ContentValues saveCategory(ContentValues categoryContentValues) {
		Log.i(TAG, "saveCategory(ContentValues):ContentValues");

		SQLiteDatabase sqliteDatabase = this.sqliteOpenHelper
				.getWritableDatabase();
		long rowId = sqliteDatabase.insertWithOnConflict(
				CategoryContract.TABLE_NAME, null, categoryContentValues,
				SQLiteDatabase.CONFLICT_IGNORE);

		return ((rowId != -1L) ? categoryContentValues : null);
	}

	@Override()
	public ContentValues updateCategory(ContentValues categoryContentValues) {
		Log.i(TAG, "updateCategory(ContentValues):ContentValues");

		// DEBUGME: Debug this function.
		String whereClause = String.format("%s = ? AND %s = ?",
				CategoryContract.Column.CATEGORY_NAME,
				CategoryContract.Column.LANGUAGES_ISO_CODE);
		String[] whereArgs = new String[] {
				categoryContentValues
						.getAsString(CategoryContract.Column.CATEGORY_NAME),
				categoryContentValues
						.getAsString(CategoryContract.Column.LANGUAGES_ISO_CODE) };
		SQLiteDatabase sqliteDatabase = this.sqliteOpenHelper
				.getWritableDatabase();
		int affectedRows = sqliteDatabase.updateWithOnConflict(
				CategoryContract.TABLE_NAME, categoryContentValues,
				whereClause, whereArgs, SQLiteDatabase.CONFLICT_IGNORE);

		return ((affectedRows != 0) ? categoryContentValues : null);
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
			for (String columnName : CategoryContract.Column.getAllColumns()) {
				contentValues.put(columnName,
						cursor.getString(cursor.getColumnIndex(columnName)));
			}

			contentValuesList.add(contentValues);
			cursor.moveToNext();
		}

		return (contentValuesList);
	}
}