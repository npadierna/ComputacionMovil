package co.edu.udea.compumovil.grupo11.example1.database.dao;

import java.util.List;

import android.content.ContentValues;

public interface IPersonDAO {

	public Integer deletePersons(String whereClause, String[] whereArgs);

	public List<ContentValues> findPersons(Boolean distinct, String[] columns,
			String selection, String[] selectionArgs, String groupBy,
			String having, String orderBy, String limit);

	public List<ContentValues> findPersonsByHeightRange(Float lowerHeight,
			Float upperHeight);

	public List<ContentValues> findPersonsByDocumentType(String documentType);

	public ContentValues savePerson(ContentValues personContentValues);

	public ContentValues updatePerson(ContentValues personContentValues,
			String whereClause, String[] whereArgs);

	public Long countPersons();
}