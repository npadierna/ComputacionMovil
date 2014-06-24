package co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao;

import java.util.List;

import android.content.ContentValues;

public interface ICategoryDAO {

	public Long countCategories();

	public List<ContentValues> findAllCategories();

	public List<ContentValues> findCategoriesByLanguageIsoCode(
			String languageIsoCode);

	public ContentValues saveCategory(ContentValues categoryContentValues);

	public ContentValues updateCategory(ContentValues categoryContentValues);
}