package co.edu.udea.compumovil.ahorcatooth.process.business.impl;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Languages;
import co.edu.udea.compumovil.ahorcatooth.persistence.contract.LanguagesContract;
import co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao.ILanguagesDAO;
import co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao.impl.LanguaguesDAOImpl;
import co.edu.udea.compumovil.ahorcatooth.process.business.ILanguagesProcess;

public class LanguagesProcessImpl implements ILanguagesProcess {

	private static final String TAG = LanguagesProcessImpl.class
			.getSimpleName();

	private ILanguagesDAO languagesDAO;

	public LanguagesProcessImpl(Context context) {
		super();

		this.languagesDAO = LanguaguesDAOImpl.getInstance(context);
	}

	@Override()
	public List<Languages> findAllLanguages() {
		Log.i(TAG, "findAllLanguages():List<Languages>");

		List<ContentValues> contentValuesList = this.languagesDAO
				.findAllLanguages();
		List<Languages> languagesList = new ArrayList<Languages>();

		for (ContentValues contentValues : contentValuesList) {
			languagesList.add(this
					.convertContentValuesToLanguages(contentValues));
		}

		return (languagesList);
	}

	@Override()
	public Languages saveLanguages(Languages languages) {
		Log.i(TAG, "saveLanguagues(Languages):Languages");

		if (this.isValidLanguages(languages)) {

			return ((this.languagesDAO.saveLanguages(this
					.convertLanguagesToContentValues(languages)) != null) ? languages
					: null);
		}

		return (null);
	}

	private Languages convertContentValuesToLanguages(
			ContentValues contentValues) {
		Languages languages = new Languages(
				contentValues.getAsString(LanguagesContract.Column.ISO_CODE),
				contentValues.getAsString(LanguagesContract.Column.TONGUE));
		languages.setDescription(contentValues
				.getAsString(LanguagesContract.Column.DESCRIPTION));

		return (languages);
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

	private boolean isValidLanguages(Languages languages) {
		if ((languages == null) || (TextUtils.isEmpty(languages.getIsoCode()))) {

			return (false);
		}

		return (true);
	}
}