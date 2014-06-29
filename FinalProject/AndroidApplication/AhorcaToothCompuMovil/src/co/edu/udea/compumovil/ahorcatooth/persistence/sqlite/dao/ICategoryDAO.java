package co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao;

import java.util.List;

import co.edu.udea.compumovil.ahorcatooth.persistence.exception.AhorcaToothPersistenceException;
import android.content.ContentValues;

public interface ICategoryDAO {

	public Long count() throws AhorcaToothPersistenceException;

	public List<ContentValues> findAll() throws AhorcaToothPersistenceException;

	public List<ContentValues> findByLanguageIsoCode(String languageIsoCode)
			throws AhorcaToothPersistenceException;

	public ContentValues save(ContentValues categoryContentValues)
			throws AhorcaToothPersistenceException;

	public ContentValues update(ContentValues categoryContentValues)
			throws AhorcaToothPersistenceException;
}