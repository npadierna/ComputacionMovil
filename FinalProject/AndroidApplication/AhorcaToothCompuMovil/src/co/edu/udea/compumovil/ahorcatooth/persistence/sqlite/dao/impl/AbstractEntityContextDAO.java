package co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao.impl;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import co.edu.udea.compumovil.ahorcatooth.persistence.exception.AhorcaToothPersistenceException;
import co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.AccessorSQLiteOpenHelper;
import co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao.IEntityContextDAO;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
abstract class AbstractEntityContextDAO implements IEntityContextDAO {

	private SQLiteOpenHelper sqliteOpenHelper;

	public AbstractEntityContextDAO(Context context) {
		super();

		this.sqliteOpenHelper = new AccessorSQLiteOpenHelper(context);
	}

	public SQLiteOpenHelper getSqliteOpenHelper() {

		return (this.sqliteOpenHelper);
	}

	public void setSqliteOpenHelper(SQLiteOpenHelper sqliteOpenHelper) {
		this.sqliteOpenHelper = sqliteOpenHelper;
	}

	private List<ContentValues> convertCursorToEntity(Cursor cursor,
			String[] columns) {
		List<ContentValues> contentValuesList = new ArrayList<ContentValues>();

		if ((cursor == null) || (cursor.isClosed())) {

			return (contentValuesList);
		}

		ContentValues contentValues = null;
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			contentValues = new ContentValues();

			for (String column : columns) {
				contentValues.put(column,
						cursor.getString(cursor.getColumnIndex(column)));
			}

			contentValuesList.add(contentValues);
			cursor.moveToNext();
		}

		return (contentValuesList);
	}

	@Override()
	public Long count(String table) throws AhorcaToothPersistenceException {
		try {
			SQLiteDatabase sqliteDatabase = this.sqliteOpenHelper
					.getReadableDatabase();
			Cursor cursor = sqliteDatabase.rawQuery(
					String.format("SELECT COUNT(*) FROM %s", table), null);
			Long rowsAmount = Long.valueOf(-1L);

			cursor.moveToFirst();
			if (!cursor.isAfterLast()) {
				rowsAmount = cursor.getLong(0);
			}

			cursor.close();

			return (rowsAmount);
		} catch (Exception e) {
			throw new AhorcaToothPersistenceException(String.format(
					"Error while procedure: \"%s\" was in execution.",
					"count(String):Long"), e);
		}
	}

	@Override()
	public Integer delete(String table, String whereClause, String[] whereArgs)
			throws AhorcaToothPersistenceException {
		try {
			SQLiteDatabase sqliteDatabase = this.sqliteOpenHelper
					.getWritableDatabase();
			int affectedRows = sqliteDatabase.delete(table, whereClause,
					whereArgs);

			return (affectedRows);
		} catch (Exception e) {
			throw new AhorcaToothPersistenceException(String.format(
					"Error while procedure: \"%s\" was in execution.",
					"delete(String, String, String[]):Integer"), e);
		}
	}

	@Override()
	public List<ContentValues> find(Boolean distinct, String table,
			String[] columns, String selection, String[] selectionArgs,
			String groupBy, String having, String orderBy, String limit)
			throws AhorcaToothPersistenceException {
		try {
			SQLiteDatabase sqliteDatabase = this.sqliteOpenHelper
					.getReadableDatabase();
			Cursor cursor = sqliteDatabase.query(distinct.booleanValue(),
					table, columns, selection, selectionArgs, groupBy, having,
					orderBy, limit);
			List<ContentValues> contentValuesList = this.convertCursorToEntity(
					cursor, columns);

			cursor.close();

			return (contentValuesList);
		} catch (Exception e) {
			throw new AhorcaToothPersistenceException(
					String.format(
							"Error while procedure: \"%s\" was in execution.",
							"find(Boolean, String, String[], String, String[], String, String, String, String):List<ContentValues>"),
					e);
		}
	}

	@Override()
	public ContentValues save(String table, String nullColumnHack,
			ContentValues initialValues, int conflictAlgorithm)
			throws AhorcaToothPersistenceException {
		try {
			SQLiteDatabase sqliteDatabase = this.sqliteOpenHelper
					.getWritableDatabase();
			long rowId = sqliteDatabase.insertWithOnConflict(table,
					nullColumnHack, initialValues, conflictAlgorithm);

			return ((rowId != -1L) ? initialValues : null);
		} catch (Exception e) {
			throw new AhorcaToothPersistenceException(String.format(
					"Error while procedure: \"%s\" was in execution.",
					"save(String, String, ContentValues, int):ContentValues"),
					e);
		}
	}

	@Override()
	public ContentValues update(String table, ContentValues values,
			String whereClause, String[] whereArgs, int conflictAlgorithm)
			throws AhorcaToothPersistenceException {
		try {
			SQLiteDatabase sqliteDatabase = this.sqliteOpenHelper
					.getWritableDatabase();
			int affectedRows = sqliteDatabase.updateWithOnConflict(table,
					values, whereClause, whereArgs, conflictAlgorithm);

			return ((affectedRows != 0) ? values : null);
		} catch (Exception e) {
			throw new AhorcaToothPersistenceException(
					String.format(
							"Error while procedure: \"%s\" was in execution.",
							"update(String, ContentValues, String, String[]):ContentValues"),
					e);
		}
	}
}