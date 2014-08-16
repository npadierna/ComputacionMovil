package co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao.impl;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import co.edu.udea.compumovil.ahorcatooth.persistence.contract.LanguagesContract;
import co.edu.udea.compumovil.ahorcatooth.persistence.exception.AhorcaToothPersistenceException;
import co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao.ILanguagesDAO;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
public class LanguaguesDAOImpl extends AbstractEntityContextDAO implements
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
	public Long count() throws AhorcaToothPersistenceException {
		Log.i(TAG, "count():Long");

		return (super.count(LanguagesContract.TABLE_NAME));
	}

	@Override()
	public List<ContentValues> findAll() throws AhorcaToothPersistenceException {
		Log.i(TAG, "findAll():List<ContentValues>");

		return (super.find(Boolean.FALSE, LanguagesContract.TABLE_NAME,
				LanguagesContract.Column.getAllColumns(), null, null, null,
				null, null, null));
	}

	@Override()
	public ContentValues save(ContentValues languageContentValues)
			throws AhorcaToothPersistenceException {
		Log.i(TAG, "save(ContentValues):ContentValues");

		return (super.save(LanguagesContract.TABLE_NAME, null,
				languageContentValues, SQLiteDatabase.CONFLICT_IGNORE));
	}
}