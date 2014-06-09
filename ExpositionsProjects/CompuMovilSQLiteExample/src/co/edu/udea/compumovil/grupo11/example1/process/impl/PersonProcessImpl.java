package co.edu.udea.compumovil.grupo11.example1.process.impl;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import android.text.format.DateFormat;
import co.edu.udea.compumovil.grupo11.example1.database.contract.PersonContract;
import co.edu.udea.compumovil.grupo11.example1.database.dao.IPersonDAO;
import co.edu.udea.compumovil.grupo11.example1.database.sqlite.dao.impl.PersonDAOImpl;
import co.edu.udea.compumovil.grupo11.example1.model.entity.Person;
import co.edu.udea.compumovil.grupo11.example1.model.entity.PersonPK;
import co.edu.udea.compumovil.grupo11.example1.process.IPersonProcess;

public class PersonProcessImpl implements IPersonProcess {

	private static final String TAG = PersonProcessImpl.class.getSimpleName();

	private IPersonDAO personDAO;

	public PersonProcessImpl(Context context) {
		super();
		this.personDAO = PersonDAOImpl.getInstance(context);
	}

	public int deletePerson(Person person) {
		if (this.isValidPerson(person)) {
			PersonPK personPK = person.getPersonPK();
			String whereClause = String.format("%s = ? AND %s = ?",
					PersonContract.Column.DOCUMENT_TYPE,
					PersonContract.Column.ID_NUMBER);
			String[] whereArgs = new String[] {
					personPK.getDocumentTypeEnum().toString(),
					personPK.getIdNumber() };

			return (this.personDAO.deletePersons(whereClause, whereArgs)
					.intValue());
		}

		return (-1);
	}

	@Override()
	public List<Person> findAllPersons() {

		return (null);
	}

	@Override()
	public Person savePerson(Person person) {
		if (this.isValidPerson(person)) {

			return ((this.personDAO.savePerson(this
					.convertPersonToContentValues(person)) != null) ? person
					: null);
		}

		return (null);
	}

	private boolean isValidPerson(Person person) {
		if (person == null) {

			return (false);
		}

		PersonPK personPK = person.getPersonPK();
		if ((personPK == null) || (personPK.getDocumentTypeEnum() == null)
				|| (TextUtils.isEmpty(personPK.getIdNumber()))) {

			return (false);
		}

		return (true);
	}

	private ContentValues convertPersonToContentValues(Person person) {
		ContentValues contentValues = new ContentValues();

		contentValues
				.put(PersonContract.Column.WEIGHT,
						((person.getWeight() != (short) 0) ? person.getWeight()
								: null));
		contentValues.put(PersonContract.Column.BIRTHDAY,
				DateFormat.format("dd/MM/yyyy", person.getBirthday())
						.toString());
		contentValues.put(PersonContract.Column.DOCUMENT_TYPE, person
				.getPersonPK().getDocumentTypeEnum().toString());
		contentValues.put(PersonContract.Column.E_MAIL, person.getEMail());
		contentValues.put(PersonContract.Column.FIRST_NAMES,
				person.getFirstNames());
		contentValues
				.put(PersonContract.Column.HEIGHT,
						((person.getHeight() != (short) 0) ? person.getHeight()
								: null));
		contentValues.put(PersonContract.Column.ID_NUMBER, person.getPersonPK()
				.getIdNumber());
		contentValues.put(PersonContract.Column.LAST_NAMES,
				person.getLastNames());
		contentValues.put(PersonContract.Column.PHONE_NUMBER,
				person.getPhoneNumber());

		return (contentValues);
	}
}