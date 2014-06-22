package co.edu.udea.compumovil.ahorcatooth.persistance.sqlite.dao;

import java.util.List;

import android.content.ContentValues;

public interface IHangmanWordDAO {

	public Integer deleteHangmanWord(Long id);

	public List<ContentValues> findHangmanWordsByCategoryNameAndLanguageIsoCode(
			String categoryName, String languageIsoCode);

	public ContentValues saveHangmanWord(ContentValues hangmanWordContentValues);
}