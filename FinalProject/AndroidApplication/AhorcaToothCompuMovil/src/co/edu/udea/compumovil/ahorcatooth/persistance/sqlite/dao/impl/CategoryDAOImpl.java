package co.edu.udea.compumovil.ahorcatooth.persistance.sqlite.dao.impl;

import android.content.ContentValues;
import android.content.Context;
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
}