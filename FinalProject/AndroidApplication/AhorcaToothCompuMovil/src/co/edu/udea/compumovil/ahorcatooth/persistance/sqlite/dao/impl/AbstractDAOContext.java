package co.edu.udea.compumovil.ahorcatooth.persistance.sqlite.dao.impl;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import co.edu.udea.compumovil.ahorcatooth.persistance.sqlite.AccessorSQLiteOpenHelper;
import co.edu.udea.compumovil.ahorcatooth.persistance.sqlite.dao.IAbstractDAOContext;

abstract class AbstractDAOContext implements IAbstractDAOContext {

	private SQLiteOpenHelper sqliteOpenHelper;

	public AbstractDAOContext(Context context) {
		super();

		this.sqliteOpenHelper = new AccessorSQLiteOpenHelper(context);
	}

	public SQLiteOpenHelper getSqliteOpenHelper() {

		return (this.sqliteOpenHelper);
	}

	public void setSqliteOpenHelper(SQLiteOpenHelper sqliteOpenHelper) {
		this.sqliteOpenHelper = sqliteOpenHelper;
	}

	@Override()
	public Long countEntities(String table) {
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
	}

	@Override()
	public Integer deleteEntities(String table, String whereClause,
			String[] whereArgs) {
		SQLiteDatabase sqliteDatabase = this.sqliteOpenHelper
				.getWritableDatabase();
		int affectedRows = sqliteDatabase.delete(table, whereClause, whereArgs);

		return (affectedRows);
	}

	@Override()
	public List<ContentValues> findEntities(Boolean distinct, String table,
			String[] columns, String selection, String[] selectionArgs,
			String groupBy, String having, String orderBy, String limit) {
		SQLiteDatabase sqliteDatabase = this.sqliteOpenHelper
				.getReadableDatabase();
		Cursor cursor = sqliteDatabase.query(distinct.booleanValue(), table,
				columns, selection, selectionArgs, groupBy, having, orderBy,
				limit);
		List<ContentValues> contentValuesList = this.convertCursorToEntity(
				cursor, columns);

		cursor.close();

		return (contentValuesList);
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
	public ContentValues saveEntity(String table, String nullColumnHack,
			ContentValues initialValues, int conflictAlgorithm) {
		SQLiteDatabase sqliteDatabase = this.sqliteOpenHelper
				.getWritableDatabase();
		long rowId = sqliteDatabase.insertWithOnConflict(table, nullColumnHack,
				initialValues, conflictAlgorithm);

		return ((rowId != -1L) ? initialValues : null);
	}

	@Override()
	public ContentValues updateEntity(String table, ContentValues values,
			String whereClause, String[] whereArgs, int conflictAlgorithm) {
		SQLiteDatabase sqliteDatabase = this.sqliteOpenHelper
				.getWritableDatabase();
		int affectedRows = sqliteDatabase.updateWithOnConflict(table, values,
				whereClause, whereArgs, conflictAlgorithm);

		return ((affectedRows != 0) ? values : null);
	}
}