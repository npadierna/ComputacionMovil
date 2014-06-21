package co.edu.udea.compumovil.ahorcatooth.process.impl;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Languages;
import co.edu.udea.compumovil.ahorcatooth.persistance.contract.LanguagesContract;
import co.edu.udea.compumovil.ahorcatooth.persistance.sqlite.dao.ILanguagesDAO;
import co.edu.udea.compumovil.ahorcatooth.persistance.sqlite.dao.impl.LanguaguesDAOImpl;
import co.edu.udea.compumovil.ahorcatooth.process.ILanguagesProcess;

public class LanguagesProcessImpl implements ILanguagesProcess {

	private static final String TAG = LanguagesProcessImpl.class
			.getSimpleName();

	private ILanguagesDAO languagesDAO;

	public LanguagesProcessImpl(Context context) {
		super();

		this.languagesDAO = LanguaguesDAOImpl.getInstance(context);
	}

	@Override()
	public Languages saveLanguages(Languages languages) {
		Log.i(TAG, "saveLanguagues(Languages):Languages");

		// FIXME: Validate the Languages's data.

		return (((this.languagesDAO.saveLanguages(this
				.convertLanguagesToContentValues(languages))) != null) ? languages
				: null);
	}

	private ContentValues convertLanguagesToContentValues(Languages languages) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(LanguagesContract.Column.ISO_CODE,
				languages.getIsoCode());
		contentValues.put(LanguagesContract.Column.TONGUE,
				languages.getTongue());
		contentValues.put(LanguagesContract.Column.DESCRIPTION,
				languages.getDescription());

		return (contentValues);
	}
}