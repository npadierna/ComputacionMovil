package co.edu.udea.compumovil.ahorcatooth.persistance.sqlite.dao.impl;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import co.edu.udea.compumovil.ahorcatooth.persistance.contract.CategoryContract;
import co.edu.udea.compumovil.ahorcatooth.persistance.sqlite.dao.ICategoryDAO;

public class CategoryDAOImpl extends AbstractDAOContext implements ICategoryDAO {

	private static final String TAG = CategoryDAOImpl.class.getSimpleName();

	private static CategoryDAOImpl instance = null;

	private CategoryDAOImpl(Context context) {
		super(context);
	}

	public static synchronized CategoryDAOImpl getInstance(Context context) {
		if (instance == null) {
			instance = new CategoryDAOImpl(context);
		}

		return (instance);
	}

	@Override()
	public Long countCategories() {
		Log.i(TAG, "countCategories():Long");

		return (super.countEntities(CategoryContract.TABLE_NAME));
	}

	@Override()
	public List<ContentValues> findAllCategories() {
		Log.i(TAG, "findAllCategories():List<ContentValues>");

		return (super.findEntities(Boolean.FALSE, CategoryContract.TABLE_NAME,
				CategoryContract.Column.getAllColumns(), null, null, null,
				null, null, null));
	}

	@Override()
	public List<ContentValues> findCategoriesByLanguageIsoCode(
			String languageIsoCode) {
		Log.i(TAG, "findCategoriesByLanguageIsoCode():List<ContentValues>");

		// DEBUGME: Debug this function.
		String selection = String.format("%s = ?",
				CategoryContract.Column.LANGUAGES_ISO_CODE);
		String[] selectionArgs = new String[] { languageIsoCode };
		List<ContentValues> categoriesContentValues = super.findEntities(
				Boolean.FALSE, CategoryContract.TABLE_NAME,
				CategoryContract.Column.getAllColumns(), selection,
				selectionArgs, null, null, null, null);

		return (categoriesContentValues);
	}

	@Override()
	public ContentValues saveCategory(ContentValues categoryContentValues) {
		Log.i(TAG, "saveCategory(ContentValues):ContentValues");

		return (super.saveEntity(CategoryContract.TABLE_NAME, null,
				categoryContentValues, SQLiteDatabase.CONFLICT_IGNORE));
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

		return (super.updateEntity(CategoryContract.TABLE_NAME,
				categoryContentValues, whereClause, whereArgs,
				SQLiteDatabase.CONFLICT_IGNORE));
	}
}