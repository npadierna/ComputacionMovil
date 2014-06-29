package co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao;

import java.util.List;

import co.edu.udea.compumovil.ahorcatooth.persistence.exception.AhorcaToothPersistenceException;
import android.content.ContentValues;

public interface ILanguagesDAO {

	public Long count() throws AhorcaToothPersistenceException;

	public List<ContentValues> findAll() throws AhorcaToothPersistenceException;

	public ContentValues save(ContentValues languageContentValues)
			throws AhorcaToothPersistenceException;
}