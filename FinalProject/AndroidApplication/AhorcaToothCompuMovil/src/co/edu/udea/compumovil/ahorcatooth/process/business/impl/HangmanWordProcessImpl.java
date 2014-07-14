package co.edu.udea.compumovil.ahorcatooth.process.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.HangmanWord;
import co.edu.udea.compumovil.ahorcatooth.persistence.contract.HangmanWordContract;
import co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao.IHangmanWordDAO;
import co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao.impl.HangmanWordDAOImpl;
import co.edu.udea.compumovil.ahorcatooth.process.business.IHangmanWordProcess;
import co.edu.udea.compumovil.ahorcatooth.process.exception.AhorcaToothBusinessException;

public class HangmanWordProcessImpl implements IHangmanWordProcess {

	private static final String TAG = HangmanWordProcessImpl.class
			.getSimpleName();

	private IHangmanWordDAO hangmanWordDAO;

	public HangmanWordProcessImpl(Context context) {
		super();

		this.hangmanWordDAO = HangmanWordDAOImpl.getInstance(context);
	}

	private HangmanWord convertContentValuesToHangmanWord(
			ContentValues contentValues) {
		// TODO: This method does not set the Category attribute for this
		// HangmanWord.
		HangmanWord hangmanWord = new HangmanWord(
				contentValues.getAsLong(HangmanWordContract.Column.ID),
				contentValues.getAsString(HangmanWordContract.Column.WORD_NAME));
		hangmanWord.setDescription(contentValues
				.getAsString(HangmanWordContract.Column.DESCRIPTION));

		return (hangmanWord);
	}

	private ContentValues convertHangmanWordToContentValues(
			HangmanWord hangmanWord) {
		// FIXME: Think more about the Category attribute in this HangmanWord.
		ContentValues contentValues = new ContentValues();

		contentValues.put(HangmanWordContract.Column.ID, hangmanWord.getId());
		contentValues.put(HangmanWordContract.Column.WORD_NAME,
				hangmanWord.getWordName());
		contentValues.put(HangmanWordContract.Column.DESCRIPTION,
				hangmanWord.getDescription());
		contentValues.put(HangmanWordContract.Column.CATEGORY_NAME, hangmanWord
				.getCategory().getCategoryPK().getCategoryName());
		contentValues
				.put(HangmanWordContract.Column.LANGUAGES_ISO_CODE, hangmanWord
						.getCategory().getCategoryPK().getLanguagesIsoCode());

		return (contentValues);
	}

	private boolean isValidHangmanWord(HangmanWord hangmanWord) {
		if ((hangmanWord == null) || (hangmanWord.getCategory() == null)) {

			return (false);
		}

		return (this.isValidHangmanWordPK(hangmanWord.getId()));
	}

	private boolean isValidHangmanWordPK(Long id) {

		return ((id != null) && (id.longValue() > 0L));
	}

	@Override()
	public Integer delete(Long id) throws AhorcaToothBusinessException {
		Log.i(TAG, "delete(Long):Integer");

		try {
			if (this.isValidHangmanWordPK(id)) {

				return (this.hangmanWordDAO.delete(id));
			}

			return (Integer.valueOf(-1));
		} catch (Exception e) {
			throw new AhorcaToothBusinessException(e);
		}
	}

	@Override()
	public List<HangmanWord> findByCategoryNameAndLanguageIsoCode(
			String categoryName, String languageIsoCode)
			throws AhorcaToothBusinessException {
		Log.i(TAG,
				"findByCategoryNameAndLanguageIsoCode(String, String):List<HangmanWord>");

		try {
			List<ContentValues> contentValuesList = this.hangmanWordDAO
					.findByCategoryNameAndLanguageIsoCode(categoryName,
							languageIsoCode);
			List<HangmanWord> hangmanWordsList = new ArrayList<HangmanWord>();

			for (ContentValues contentValues : contentValuesList) {
				hangmanWordsList.add(this
						.convertContentValuesToHangmanWord(contentValues));
			}

			return (hangmanWordsList);
		} catch (Exception e) {
			throw new AhorcaToothBusinessException(e);
		}
	}

	public HangmanWord findOneByCategoryNameAndLanguageIsoCode(
			String categoryName, String languageIsoCode)
			throws AhorcaToothBusinessException {
		Log.i(TAG,
				"findOneByCategoryNameAndLanguageIsoCode(String, String):HangmanWord");

		try {
			List<HangmanWord> hangmanWordsFoundList = this
					.findByCategoryNameAndLanguageIsoCode(categoryName,
							languageIsoCode);

			if (!hangmanWordsFoundList.isEmpty()) {
				int position = (new Random()).nextInt(hangmanWordsFoundList
						.size());

				return (hangmanWordsFoundList.get(position));
			}

			return (null);
		} catch (Exception e) {
			throw new AhorcaToothBusinessException(e);
		}
	}

	@Override()
	public HangmanWord save(HangmanWord hangmanWord)
			throws AhorcaToothBusinessException {
		Log.i(TAG, "save(HangmanWord):HangmanWord");

		try {
			if (this.isValidHangmanWord(hangmanWord)) {

				return ((this.hangmanWordDAO
						.save(convertHangmanWordToContentValues(hangmanWord)) != null) ? hangmanWord
						: null);
			}

			return (null);
		} catch (Exception e) {
			throw new AhorcaToothBusinessException(e);
		}
	}
}