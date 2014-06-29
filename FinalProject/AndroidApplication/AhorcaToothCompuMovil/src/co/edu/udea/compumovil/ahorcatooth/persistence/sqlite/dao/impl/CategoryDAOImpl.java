package co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao.impl;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import co.edu.udea.compumovil.ahorcatooth.persistence.contract.CategoryContract;
import co.edu.udea.compumovil.ahorcatooth.persistence.exception.AhorcaToothPersistenceException;
import co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao.ICategoryDAO;

public class CategoryDAOImpl extends AbstractEntityContextDAO implements
		ICategoryDAO {

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
	public Long count() throws AhorcaToothPersistenceException {
		Log.i(TAG, "count():Long");

		return (super.count(CategoryContract.TABLE_NAME));
	}

	@Override()
	public List<ContentValues> findAll() throws AhorcaToothPersistenceException {
		Log.i(TAG, "findAll():List<ContentValues>");

		return (super.find(Boolean.FALSE, CategoryContract.TABLE_NAME,
				CategoryContract.Column.getAllColumns(), null, null, null,
				null, null, null));
	}

	@Override()
	public List<ContentValues> findByLanguageIsoCode(String languageIsoCode)
			throws AhorcaToothPersistenceException {
		Log.i(TAG, "findByLanguageIsoCode():List<ContentValues>");

		String selection = String.format("%s = ?",
				CategoryContract.Column.LANGUAGES_ISO_CODE);
		String[] selectionArgs = new String[] { languageIsoCode };
		List<ContentValues> categoriesContentValues = super.find(Boolean.FALSE,
				CategoryContract.TABLE_NAME,
				CategoryContract.Column.getAllColumns(), selection,
				selectionArgs, null, null, null, null);

		return (categoriesContentValues);
	}

	@Override()
	public ContentValues save(ContentValues categoryContentValues)
			throws AhorcaToothPersistenceException {
		Log.i(TAG, "save(ContentValues):ContentValues");

		return (super.save(CategoryContract.TABLE_NAME, null,
				categoryContentValues, SQLiteDatabase.CONFLICT_IGNORE));
	}

	@Override()
	public ContentValues update(ContentValues categoryContentValues)
			throws AhorcaToothPersistenceException {
		Log.i(TAG, "update(ContentValues):ContentValues");

		String whereClause = String.format("%s = ? AND %s = ?",
				CategoryContract.Column.CATEGORY_NAME,
				CategoryContract.Column.LANGUAGES_ISO_CODE);
		String[] whereArgs = new String[] {
				categoryContentValues
						.getAsString(CategoryContract.Column.CATEGORY_NAME),
				categoryContentValues
						.getAsString(CategoryContract.Column.LANGUAGES_ISO_CODE) };

		return (super.update(CategoryContract.TABLE_NAME,
				categoryContentValues, whereClause, whereArgs,
				SQLiteDatabase.CONFLICT_IGNORE));
	}
}