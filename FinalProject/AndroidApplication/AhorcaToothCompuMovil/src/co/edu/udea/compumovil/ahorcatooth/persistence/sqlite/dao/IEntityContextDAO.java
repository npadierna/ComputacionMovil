package co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao;

import java.util.List;

import co.edu.udea.compumovil.ahorcatooth.persistence.exception.AhorcaToothPersistenceException;
import android.content.ContentValues;

public interface IEntityContextDAO {

	public Long count(String table) throws AhorcaToothPersistenceException;

	public Integer delete(String table, String whereClause, String[] whereArgs)
			throws AhorcaToothPersistenceException;

	public List<ContentValues> find(Boolean distinct, String table,
			String[] columns, String selection, String[] selectionArgs,
			String groupBy, String having, String orderBy, String limit)
			throws AhorcaToothPersistenceException;

	public ContentValues save(String table, String nullColumnHack,
			ContentValues initialValues, int conflictAlgorithm)
			throws AhorcaToothPersistenceException;

	public ContentValues update(String table, ContentValues values,
			String whereClause, String[] whereArgs, int conflictAlgorithm)
			throws AhorcaToothPersistenceException;
}