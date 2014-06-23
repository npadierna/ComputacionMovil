package co.edu.udea.compumovil.ahorcatooth.persistance.sqlite.dao;

import java.util.List;

import android.content.ContentValues;

public interface IAbstractDAOContext {

	public Long countEntities(String table);

	public Integer deleteEntities(String table, String whereClause,
			String[] whereArgs);

	public List<ContentValues> findEntities(Boolean distinct, String table,
			String[] columns, String selection, String[] selectionArgs,
			String groupBy, String having, String orderBy, String limit);

	public ContentValues saveEntity(String table, String nullColumnHack,
			ContentValues initialValues, int conflictAlgorithm);

	public ContentValues updateEntity(String table, ContentValues values,
			String whereClause, String[] whereArgs, int conflictAlgorithm);
}