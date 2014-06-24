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

public class HangmanWordProcessImpl implements IHangmanWordProcess {

	private static final String TAG = HangmanWordProcessImpl.class
			.getSimpleName();

	private IHangmanWordDAO hangmanWordDAO;

	public HangmanWordProcessImpl(Context context) {
		super();

		this.hangmanWordDAO = HangmanWordDAOImpl.getInstance(context);
	}

	@Override()
	public Integer deleteHangmanWord(Long id) {
		Log.i(TAG, "deleteHangmanWord(Long):Integer");

		if (this.isValidHangmanWordPK(id)) {

			return (this.hangmanWordDAO.deleteHangmanWord(id));
		}

		return (Integer.valueOf(-1));
	}

	@Override()
	public List<HangmanWord> findHangmanWordsByCategoryNameAndLanguageIsoCode(
			String categoryName, String languageIsoCode) {
		Log.i(TAG,
				"findHangmanWordsByCategoryNameAndLanguageIsoCode(String, String):List<HangmanWord>");

		List<ContentValues> contentValuesList = this.hangmanWordDAO
				.findHangmanWordsByCategoryNameAndLanguageIsoCode(categoryName,
						languageIsoCode);
		List<HangmanWord> hangmanWordsList = new ArrayList<HangmanWord>();

		for (ContentValues contentValues : contentValuesList) {
			hangmanWordsList.add(this
					.convertContentValuesToHangmanWord(contentValues));
		}

		return (hangmanWordsList);
	}

	public HangmanWord findOneHangmanWordByCategoryNameAndLanguageIsoCode(
			String categoryName, String languageIsoCode) {
		Log.i(TAG,
				"findOneHangmanWordByCategoryNameAndLanguageIsoCode(String, String):HangmanWord");

		List<HangmanWord> hangmanWordsFoundList = this
				.findHangmanWordsByCategoryNameAndLanguageIsoCode(categoryName,
						languageIsoCode);

		if (!hangmanWordsFoundList.isEmpty()) {
			int position = (new Random()).nextInt(hangmanWordsFoundList.size());

			return (hangmanWordsFoundList.get(position));
		}

		return (null);
	}

	@Override()
	public HangmanWord saveHangmanWord(HangmanWord hangmanWord) {
		Log.i(TAG, "saveHangmanWord(HangmanWord):HangmanWord");

		if (this.isValidHangmanWord(hangmanWord)) {

			return ((this.hangmanWordDAO
					.saveHangmanWord(convertHangmanWordToContentValues(hangmanWord)) != null) ? hangmanWord
					: null);
		}

		return (null);
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
}