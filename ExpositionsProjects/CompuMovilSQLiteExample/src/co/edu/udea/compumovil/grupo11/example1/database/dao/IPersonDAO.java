package co.edu.udea.compumovil.grupo11.example1.database.dao;

import java.util.List;

import android.content.ContentValues;
import co.edu.udea.compumovil.grupo11.example1.model.entity.PersonPK;

public interface IPersonDAO {

	public Integer deletePersons(String whereClause, String[] whereArgs);

	public List<ContentValues> findPersons(Boolean distinct, String[] columns,
			String selection, String[] selectionArgs, String groupBy,
			String having, String orderBy, String limit);

	public ContentValues findPerson(PersonPK personPK);

	public List<ContentValues> findPersonsByAgeRange(Short lower, Short upper);

	public List<ContentValues> findPersonsByDocumentType(String documentType);

	public ContentValues savePerson(ContentValues personContentValues);

	public ContentValues updatePerson(ContentValues personContentValues);

	public Long countPersons();
}