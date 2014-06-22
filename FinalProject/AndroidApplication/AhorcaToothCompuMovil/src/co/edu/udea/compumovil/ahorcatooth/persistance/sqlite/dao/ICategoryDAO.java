package co.edu.udea.compumovil.ahorcatooth.persistance.sqlite.dao;

import java.util.List;

import android.content.ContentValues;

public interface ICategoryDAO {

	public List<ContentValues> findAllCategories();

	public List<ContentValues> findCategoriesByLanguageIsoCode(
			String languageIsoCode);

	public ContentValues saveCategory(ContentValues categoryContentValues);

	public ContentValues updateCategory(ContentValues categoryContentValues);
}