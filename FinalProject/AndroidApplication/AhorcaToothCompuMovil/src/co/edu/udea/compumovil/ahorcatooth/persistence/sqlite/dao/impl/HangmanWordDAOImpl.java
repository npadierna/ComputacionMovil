package co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao.impl;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import co.edu.udea.compumovil.ahorcatooth.persistence.contract.HangmanWordContract;
import co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao.IHangmanWordDAO;

public class HangmanWordDAOImpl extends AbstractDAOContext implements
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
	public Long countHangmanWords() {
		Log.i(TAG, "countHangmanWords():Long");

		return (super.countEntities(HangmanWordContract.TABLE_NAME));
	}

	@Override()
	public Integer deleteHangmanWord(Long id) {
		Log.i(TAG, "deleteHangmanWord(Long):Integer");

		// DEBUGME: Debug this function.
		String whereClause = String.format("%s = ?",
				HangmanWordContract.Column.ID);
		String[] whereArgs = new String[] { String.valueOf(id.longValue()) };

		return (super.deleteEntities(HangmanWordContract.TABLE_NAME,
				whereClause, whereArgs));
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

		return (super.findEntities(Boolean.FALSE,
				HangmanWordContract.TABLE_NAME,
				HangmanWordContract.Column.getAllColumns(), selection,
				selectionArgs, null, null, null, null));
	}

	@Override()
	public ContentValues saveHangmanWord(ContentValues hangmanWordContentValues) {
		Log.i(TAG, "saveHangmanWord(ContentValues):ContentValues");

		return (super.saveEntity(HangmanWordContract.TABLE_NAME, null,
				hangmanWordContentValues, SQLiteDatabase.CONFLICT_IGNORE));
	}
}