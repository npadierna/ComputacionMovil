package co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao;

import java.util.List;

import android.content.ContentValues;

public interface ILanguagesDAO {

	public Long countLanguages();

	public List<ContentValues> findAllLanguages();

	public ContentValues saveLanguages(ContentValues languageContentValues);
}