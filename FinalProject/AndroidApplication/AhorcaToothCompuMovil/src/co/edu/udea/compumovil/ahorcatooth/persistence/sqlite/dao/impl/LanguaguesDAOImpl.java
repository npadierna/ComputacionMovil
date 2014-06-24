package co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao.impl;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import co.edu.udea.compumovil.ahorcatooth.persistence.contract.LanguagesContract;
import co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao.ILanguagesDAO;

public class LanguaguesDAOImpl extends AbstractDAOContext implements
		ILanguagesDAO {

	private static final String TAG = LanguaguesDAOImpl.class.getSimpleName();

	private static LanguaguesDAOImpl instance = null;

	private LanguaguesDAOImpl(Context context) {
		super(context);
	}

	public static synchronized LanguaguesDAOImpl getInstance(Context context) {
		if (instance == null) {
			instance = new LanguaguesDAOImpl(context);
		}

		return (instance);
	}

	@Override()
	public Long countLanguages() {
		Log.i(TAG, "countLanguages():Long");

		return (super.countEntities(LanguagesContract.TABLE_NAME));
	}

	@Override()
	public List<ContentValues> findAllLanguages() {
		Log.i(TAG, "findAllLanguages():List<ContentValues>");

		return (super.findEntities(Boolean.FALSE, LanguagesContract.TABLE_NAME,
				LanguagesContract.Column.getAllColumns(), null, null, null,
				null, null, null));
	}

	@Override()
	public ContentValues saveLanguages(ContentValues languageContentValues) {
		Log.i(TAG, "saveLanguage(ContentValues):ContentValues");

		return (super.saveEntity(LanguagesContract.TABLE_NAME, null,
				languageContentValues, SQLiteDatabase.CONFLICT_IGNORE));
	}
}