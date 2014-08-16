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
import co.edu.udea.compumovil.ahorcatooth.process.exception.AhorcaToothBusinessException;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
public class LanguagesProcessImpl implements ILanguagesProcess {

	private static final String TAG = LanguagesProcessImpl.class
			.getSimpleName();

	private ILanguagesDAO languagesDAO;

	public LanguagesProcessImpl(Context context) {
		super();

		this.languagesDAO = LanguaguesDAOImpl.getInstance(context);
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

	@Override()
	public List<Languages> findAll() throws AhorcaToothBusinessException {
		Log.i(TAG, "findAll():List<Languages>");

		try {
			List<ContentValues> contentValuesList = this.languagesDAO.findAll();
			List<Languages> languagesList = new ArrayList<Languages>();

			for (ContentValues contentValues : contentValuesList) {
				languagesList.add(this
						.convertContentValuesToLanguages(contentValues));
			}

			return (languagesList);
		} catch (Exception e) {
			throw new AhorcaToothBusinessException(e);
		}
	}

	@Override()
	public Languages save(Languages languages)
			throws AhorcaToothBusinessException {
		Log.i(TAG, "save(Languages):Languages");

		try {
			if (this.isValidLanguages(languages)) {

				return ((this.languagesDAO.save(this
						.convertLanguagesToContentValues(languages)) != null) ? languages
						: null);
			}

			return (null);
		} catch (Exception e) {
			throw new AhorcaToothBusinessException(e);
		}
	}
}