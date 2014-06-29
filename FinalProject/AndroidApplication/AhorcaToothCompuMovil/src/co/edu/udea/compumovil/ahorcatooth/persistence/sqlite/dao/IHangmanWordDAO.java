package co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao;

import java.util.List;

import co.edu.udea.compumovil.ahorcatooth.persistence.exception.AhorcaToothPersistenceException;
import android.content.ContentValues;

public interface IHangmanWordDAO {

	public Long count() throws AhorcaToothPersistenceException;

	public Integer delete(Long id) throws AhorcaToothPersistenceException;

	public List<ContentValues> findByCategoryNameAndLanguageIsoCode(
			String categoryName, String languageIsoCode)
			throws AhorcaToothPersistenceException;

	public ContentValues save(ContentValues hangmanWordContentValues)
			throws AhorcaToothPersistenceException;
}