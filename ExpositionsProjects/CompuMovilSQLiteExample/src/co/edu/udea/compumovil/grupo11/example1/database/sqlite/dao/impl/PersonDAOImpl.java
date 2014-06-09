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
import co.edu.udea.compumovil.grupo11.example1.model.entity.PersonPK;

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
				"findPersons(Boolean, String[], String, String[], String, String, String, String):Cursor");

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
	public ContentValues findPerson(PersonPK personPK) {
		Log.i(TAG, "findPerson(PersonPK):Cursor");

		return null;
	}

	@Override()
	public List<ContentValues> findPersonsByAgeRange(Short lower, Short upper) {
		Log.i(TAG, "findPersonsByAgeRange(Short, Short):Cursor");

		return null;
	}

	@Override()
	public List<ContentValues> findPersonsByDocumentType(String documentType) {
		Log.i(TAG, "findPersonsByDocumentType(String):Cursor");

		return null;
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
	public ContentValues updatePerson(ContentValues personContentValues) {
		Log.i(TAG, "updatePerson(ContentValues):ContentValues");

		return null;
	}

	@Override()
	public Long countPersons() {
		Log.i(TAG, "countPersons():Long");

		return (Long.valueOf(-1));
	}

	private List<ContentValues> cursorToContentValues(Cursor cursor,
			String[] columns) {
		List<ContentValues> contentValuesList = new ArrayList<ContentValues>();

		if ((cursor == null) || (cursor.isClosed())) {

			return (contentValuesList);
		}

		ContentValues contentValues = new ContentValues();
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			contentValues.clear();

			// FIXME: What is about if the user has selected a set of columns?

			contentValuesList.add(contentValues);
		}

		return (contentValuesList);
	}
}