package co.edu.udea.compumovil.grupo11.example1.database.sqlite.dao.impl;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import co.edu.udea.compumovil.grupo11.example1.database.contract.PersonContract;
import co.edu.udea.compumovil.grupo11.example1.database.dao.IPersonDAO;
import co.edu.udea.compumovil.grupo11.example1.database.sqlite.PersonDatabaseHelper;

public class PersonDAOImpl implements IPersonDAO {

	private static final String TAG = PersonDAOImpl.class.getSimpleName();

	private static PersonDAOImpl instance = null;
	private PersonDatabaseHelper personDatabaseHelper;

	private PersonDAOImpl(Context context) {
		super();
		this.personDatabaseHelper = new PersonDatabaseHelper(context);
	}

	public static synchronized PersonDAOImpl getInstance(Context context) {
		if (instance == null) {
			instance = new PersonDAOImpl(context);
		}

		return (instance);
	}

	@Override()
	public Integer deletePersons(String whereClause, String[] whereArgs) {
		Log.i(TAG, "deletePerson(String, String[]):Long");

		SQLiteDatabase sqliteDatabase = this.personDatabaseHelper
				.getWritableDatabase();
		int affectedRows = sqliteDatabase.delete(PersonContract.TABLE_NAME,
				whereClause, whereArgs);

		return (Integer.valueOf(affectedRows));
	}

	@Override()
	public List<ContentValues> findPersons(Boolean distinct, String[] columns,
			String selection, String[] selectionArgs, String groupBy,
			String having, String orderBy, String limit) {
		Log.i(TAG,
				"findPersons(Boolean, String[], String, String[], String, String, String, String):List<ContentValues>");

		SQLiteDatabase sqliteDatabase = this.personDatabaseHelper
				.getReadableDatabase();
		Cursor cursor = sqliteDatabase.query(distinct.booleanValue(),
				PersonContract.TABLE_NAME, columns, selection, selectionArgs,
				groupBy, having, orderBy, limit);
		List<ContentValues> contentValuesList = this.cursorToContentValues(
				cursor, columns);

		cursor.close();

		return (contentValuesList);
	}

	@Override()
	public List<ContentValues> findPersonsByHeightRange(Float lowerHeight,
			Float upperHeight) {
		Log.i(TAG, "findPersonsByAgeRange(Short, Short):List<ContentValues>");

		SQLiteDatabase sqLiteDatabase = this.personDatabaseHelper
				.getReadableDatabase();
		Cursor cursor = sqLiteDatabase
				.rawQuery(String
						.format("SELECT * FROM %s WHERE %s BETWEEN ? AND ?",
								PersonContract.TABLE_NAME,
								PersonContract.Column.HEIGHT), new String[] {
						lowerHeight.toString(), upperHeight.toString() });
		List<ContentValues> contentValuesList = this.cursorToContentValues(
				cursor, null);

		cursor.close();

		return (contentValuesList);
	}

	@Override()
	public List<ContentValues> findPersonsByDocumentType(String documentType) {
		Log.i(TAG, "findPersonsByDocumentType(String):List<ContentValues>");

		SQLiteDatabase sqliteDatabase = this.personDatabaseHelper
				.getReadableDatabase();
		Cursor cursor = sqliteDatabase.rawQuery(String.format(
				"SELECT * FROM %s WHERE %s = ?", PersonContract.TABLE_NAME,
				PersonContract.Column.DOCUMENT_TYPE),
				new String[] { documentType });
		List<ContentValues> contentValuesList = this.cursorToContentValues(
				cursor, null);

		cursor.close();

		return (contentValuesList);
	}

	@Override()
	public ContentValues savePerson(ContentValues personContentValues) {
		Log.i(TAG, "savePerson(ContentValues):ContentValues");

		SQLiteDatabase sqliteDatabase = this.personDatabaseHelper
				.getWritableDatabase();
		long rowId = sqliteDatabase.insertWithOnConflict(
				PersonContract.TABLE_NAME, null, personContentValues,
				SQLiteDatabase.CONFLICT_IGNORE);

		return ((rowId != -1L) ? personContentValues : null);
	}

	@Override()
	public ContentValues updatePerson(ContentValues personContentValues,
			String whereClause, String[] whereArgs) {
		Log.i(TAG, "updatePerson(ContentValues):ContentValues");

		SQLiteDatabase sqliteDatabase = this.personDatabaseHelper
				.getWritableDatabase();
		int affectedRows = sqliteDatabase.updateWithOnConflict(
				PersonContract.TABLE_NAME, personContentValues, whereClause,
				whereArgs, SQLiteDatabase.CONFLICT_IGNORE);

		return ((affectedRows != 0) ? personContentValues : null);
	}

	@Override()
	public Long countPersons() {
		Log.i(TAG, "countPersons():Long");

		SQLiteDatabase sqliteDatabase = this.personDatabaseHelper
				.getReadableDatabase();
		Cursor cursor = sqliteDatabase.rawQuery(String.format(
				"SELECT COUNT(*) FROM %s", PersonContract.TABLE_NAME), null);
		Long rowsAmount = Long.valueOf(-1L);

		cursor.moveToFirst();
		if (!cursor.isAfterLast()) {
			rowsAmount = cursor.getLong(0);
		}

		cursor.close();

		return (rowsAmount);
	}

	private List<ContentValues> cursorToContentValues(Cursor cursor,
			String[] columns) {
		List<ContentValues> contentValuesList = new ArrayList<ContentValues>();

		if ((cursor == null) || (cursor.isClosed())) {

			return (contentValuesList);
		}

		if (columns == null) {
			columns = PersonContract.Column.getAllColumns();
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
}