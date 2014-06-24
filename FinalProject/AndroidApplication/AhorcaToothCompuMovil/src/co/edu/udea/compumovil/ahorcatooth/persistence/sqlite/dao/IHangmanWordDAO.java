package co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao;

import java.util.List;

import android.content.ContentValues;

public interface IHangmanWordDAO {

	public Long countHangmanWords();

	public Integer deleteHangmanWord(Long id);

	public List<ContentValues> findHangmanWordsByCategoryNameAndLanguageIsoCode(
			String categoryName, String languageIsoCode);

	public ContentValues saveHangmanWord(ContentValues hangmanWordContentValues);
}