package co.edu.udea.compumovil.ahorcatooth.persistance.sqlite.dao;

import android.content.ContentValues;

public interface ICategoryDAO {

	public ContentValues saveCategory(ContentValues categoryContentValues);

	public ContentValues updateCategory(ContentValues categoryContentValues);
}