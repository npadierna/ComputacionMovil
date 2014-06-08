package co.edu.udea.compumovil.grupo11.example1.database.sqlite.dao.impl;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.format.DateFormat;
import android.util.Log;
import co.edu.udea.compumovil.grupo11.example1.database.contract.PersonContract;
import co.edu.udea.compumovil.grupo11.example1.database.dao.IPersonDAO;
import co.edu.udea.compumovil.grupo11.example1.database.sqlite.PersonDatabaseHelper;
import co.edu.udea.compumovil.grupo11.example1.model.entity.Person;
import co.edu.udea.compumovil.grupo11.example1.model.entity.PersonPK;
import co.edu.udea.compumovil.grupo11.example1.model.enums.DocumentTypeEnum;

public class PersonDAOImpl implements IPersonDAO {

	private static final String TAG = PersonDAOImpl.class.getSimpleName();

	private PersonDatabaseHelper personDatabaseHelper;

	public PersonDAOImpl(Context context) {
		super();
		this.personDatabaseHelper = new PersonDatabaseHelper(context);
	}

	@Override()
	public Person deletePerson(PersonPK personPK) {

		return null;
	}

	@Override()
	public List<Person> findAllPersons() {

		return null;
	}

	@Override()
	public Person findPerson(PersonPK personPK) {

		return null;
	}

	@Override()
	public List<Person> findPersonsByAgeRange(short lower, short upper) {

		return null;
	}

	@Override()
	public List<Person> findPersonsByDocumentType(
			DocumentTypeEnum documentTypeEnum) {

		return null;
	}

	@Override()
	public Person savePerson(Person person) {
		Log.i(TAG, String.format("savePerson(Person):Person -> %s", person
				.getPersonPK().toString()));

		SQLiteDatabase sqliteDatabase = this.personDatabaseHelper
				.getWritableDatabase();
		long rowId = sqliteDatabase.insertWithOnConflict(
				PersonContract.TABLE_NAME, null, this.convertTo(person),
				SQLiteDatabase.CONFLICT_IGNORE);

		return ((rowId != -1) ? person : null);
	}

	@Override()
	public Person updatePerson(Person person) {

		return null;
	}

	@Override()
	public long countPersons() {

		return 0;
	}

	private ContentValues convertTo(Person person) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(PersonContract.Column.AGE, person.getAge());
		contentValues.put(PersonContract.Column.BIRTHDAY,
				DateFormat.format("dd/MM/yyyy", person.getBirthday())
						.toString());
		contentValues.put(PersonContract.Column.DOCUMENT_TYPE, person
				.getPersonPK().getDocumentTypeEnum().toString());
		contentValues.put(PersonContract.Column.E_MAIL, person.getEMail());
		contentValues.put(PersonContract.Column.FIRST_NAMES,
				person.getFirstNames());
		contentValues.put(PersonContract.Column.HEIGHT, person.getHeight());
		contentValues.put(PersonContract.Column.ID_NUMBER, person.getPersonPK()
				.getIdNumber());
		contentValues.put(PersonContract.Column.LAST_NAMES,
				person.getLastNames());
		contentValues.put(PersonContract.Column.PHONE_NUMBER,
				person.getPhoneNumber());

		return (contentValues);
	}
}