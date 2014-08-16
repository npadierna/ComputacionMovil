package co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao.impl;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import co.edu.udea.compumovil.ahorcatooth.persistence.contract.HangmanWordContract;
import co.edu.udea.compumovil.ahorcatooth.persistence.exception.AhorcaToothPersistenceException;
import co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao.IHangmanWordDAO;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
public class HangmanWordDAOImpl extends AbstractEntityContextDAO implements
		IHangmanWordDAO {

	private static final String TAG = HangmanWordDAOImpl.class.getSimpleName();

	private static HangmanWordDAOImpl instance = null;

	private HangmanWordDAOImpl(Context context) {
		super(context);
	}

	public static synchronized HangmanWordDAOImpl getInstance(Context context) {
		if (instance == null) {
			instance = new HangmanWordDAOImpl(context);
		}

		return (instance);
	}

	@Override()
	public Long count() throws AhorcaToothPersistenceException {
		Log.i(TAG, "count():Long");

		return (super.count(HangmanWordContract.TABLE_NAME));
	}

	@Override()
	public Integer delete(Long id) throws AhorcaToothPersistenceException {
		Log.i(TAG, "delete(Long):Integer");

		String whereClause = String.format("%s = ?",
				HangmanWordContract.Column.ID);
		String[] whereArgs = new String[] { String.valueOf(id.longValue()) };

		return (super.delete(HangmanWordContract.TABLE_NAME, whereClause,
				whereArgs));
	}

	@Override()
	public List<ContentValues> findByCategoryNameAndLanguageIsoCode(
			String categoryName, String languageIsoCode)
			throws AhorcaToothPersistenceException {
		Log.i(TAG,
				"findByCategoryNameAndLanguageIsoCode(String, String):List<ContentValues>");

		String selection = String.format("%s = ? AND %s = ?",
				HangmanWordContract.Column.CATEGORY_NAME,
				HangmanWordContract.Column.LANGUAGES_ISO_CODE);
		String[] selectionArgs = new String[] { categoryName, languageIsoCode };

		return (super.find(Boolean.FALSE, HangmanWordContract.TABLE_NAME,
				HangmanWordContract.Column.getAllColumns(), selection,
				selectionArgs, null, null, null, null));
	}

	@Override()
	public ContentValues save(ContentValues hangmanWordContentValues)
			throws AhorcaToothPersistenceException {
		Log.i(TAG, "save(ContentValues):ContentValues");

		return (super.save(HangmanWordContract.TABLE_NAME, null,
				hangmanWordContentValues, SQLiteDatabase.CONFLICT_IGNORE));
	}
}