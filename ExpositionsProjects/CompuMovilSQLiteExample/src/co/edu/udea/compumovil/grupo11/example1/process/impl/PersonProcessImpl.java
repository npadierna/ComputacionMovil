package co.edu.udea.compumovil.grupo11.example1.process.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import co.edu.udea.compumovil.grupo11.example1.database.contract.PersonContract;
import co.edu.udea.compumovil.grupo11.example1.database.dao.IPersonDAO;
import co.edu.udea.compumovil.grupo11.example1.database.sqlite.dao.impl.PersonDAOImpl;
import co.edu.udea.compumovil.grupo11.example1.model.entity.Person;
import co.edu.udea.compumovil.grupo11.example1.model.entity.PersonPK;
import co.edu.udea.compumovil.grupo11.example1.model.enums.DocumentTypeEnum;
import co.edu.udea.compumovil.grupo11.example1.process.IPersonProcess;

public class PersonProcessImpl implements IPersonProcess {

	private static final String TAG = PersonProcessImpl.class.getSimpleName();

	private static final DateFormat DATE_FORMAT = new SimpleDateFormat(
			"dd/MM/yyyy", Locale.getDefault());

	private IPersonDAO personDAO;

	public PersonProcessImpl(Context context) {
		super();
		this.personDAO = PersonDAOImpl.getInstance(context);
	}

	public int deletePerson(Person person) {
		Log.i(TAG, "deletePerson(Person):int");

		if (this.isValidPerson(person)) {
			PersonPK personPK = person.getPersonPK();
			String whereClause = String.format("%s = ? AND %s = ?",
					PersonContract.Column.DOCUMENT_TYPE,
					PersonContract.Column.ID_NUMBER);
			String[] whereArgs = new String[] {
					personPK.getDocumentTypeEnum().getDocumentType(),
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

	public Person findPerson(PersonPK personPK) {
		Log.i(TAG, "findPerson(PersonPK):Person");

		if (this.isValidPersonPK(personPK)) {
			String selection = String.format("%s = ? AND %s = ?",
					PersonContract.Column.DOCUMENT_TYPE,
					PersonContract.Column.ID_NUMBER);
			String[] selectionArgs = new String[] {
					personPK.getDocumentTypeEnum().getDocumentType(),
					personPK.getIdNumber() };

			List<ContentValues> personsFoundList = this.personDAO.findPersons(
					Boolean.FALSE, null, selection, selectionArgs, null, null,
					null, null);

			if (!personsFoundList.isEmpty()) {

				try {
					return (this.convertContentValuesToPerson(personsFoundList
							.get(0)));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}

		return (null);
	}

	@Override()
	public List<Person> findPersonsByHeightRange(float lowerHeight,
			float upperHeight) {
		Log.i(TAG, "findPersonsByAgeRange(float, float):List<Person>");

		List<Person> personsFoundList = new ArrayList<Person>();

		if ((lowerHeight <= 0.0F) || (lowerHeight > upperHeight)) {

			return (personsFoundList);
		}

		List<ContentValues> contentValuesList = this.personDAO
				.findPersonsByHeightRange(Float.valueOf(lowerHeight),
						Float.valueOf(upperHeight));
		for (ContentValues contentValues : contentValuesList) {
			try {
				personsFoundList.add(this
						.convertContentValuesToPerson(contentValues));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return (personsFoundList);
	}

	@Override()
	public List<Person> findPersonsByDocumentTypeEnum(
			DocumentTypeEnum documentTypeEnum) {
		Log.i(TAG,
				"findPersonsByDocumentTypeEnum(DocumentTypeEnum):List<Person>");

		List<Person> personsFoundList = new ArrayList<Person>();

		if ((documentTypeEnum == null)
				|| (TextUtils.isEmpty(documentTypeEnum.getDocumentType()))) {

			return (personsFoundList);
		}

		List<ContentValues> contentValuesList = this.personDAO
				.findPersonsByDocumentType(documentTypeEnum.getDocumentType());
		for (ContentValues contentValues : contentValuesList) {
			try {
				personsFoundList.add(this
						.convertContentValuesToPerson(contentValues));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return (personsFoundList);
	}

	@Override()
	public Person savePerson(Person person) {
		Log.i(TAG, "savePerson(Person):Person");

		if (this.isValidPerson(person)) {

			return ((this.personDAO.savePerson(this
					.convertPersonToContentValues(person)) != null) ? person
					: null);
		}

		return (null);
	}

	@Override()
	public Person updatePerson(Person person) {
		Log.i(TAG, "updatePerson(Person):Person");

		if (this.isValidPerson(person)) {
			PersonPK personPK = person.getPersonPK();
			String whereClause = String.format("%s = ? AND %s = ?",
					PersonContract.Column.DOCUMENT_TYPE,
					PersonContract.Column.ID_NUMBER);
			String[] whereArgs = new String[] {
					personPK.getDocumentTypeEnum().getDocumentType(),
					personPK.getIdNumber() };

			return ((this.personDAO.updatePerson(
					this.convertPersonToContentValues(person), whereClause,
					whereArgs) != null) ? person : null);
		}

		return (null);
	}

	@Override()
	public long countPersons() {
		Log.i(TAG, "countPersons():void");

		return (this.personDAO.countPersons().longValue());
	}

	private Person convertContentValuesToPerson(ContentValues contentValues)
			throws ParseException {
		PersonPK personPK = new PersonPK(
				DocumentTypeEnum.findDocumentTypeEmunByDocumentType(contentValues
						.getAsString(PersonContract.Column.DOCUMENT_TYPE)),
				contentValues.getAsString(PersonContract.Column.ID_NUMBER));
		Person person = new Person(personPK,
				contentValues.getAsString(PersonContract.Column.FIRST_NAMES),
				contentValues.getAsString(PersonContract.Column.LAST_NAMES),
				DATE_FORMAT.parse(contentValues
						.getAsString(PersonContract.Column.BIRTHDAY)));

		person.setEMail(contentValues.getAsString(PersonContract.Column.E_MAIL));
		person.setPhoneNumber(contentValues
				.getAsString(PersonContract.Column.PHONE_NUMBER));

		Short weight = contentValues.getAsShort(PersonContract.Column.WEIGHT);
		person.setWeight((weight != null) ? weight.shortValue() : (short) 0);

		Float height = contentValues.getAsFloat(PersonContract.Column.HEIGHT);
		person.setHeight((height != null) ? height.floatValue() : 0.0F);

		return (person);
	}

	private ContentValues convertPersonToContentValues(Person person) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(
				PersonContract.Column.WEIGHT,
				((person.getWeight() != (short) 0) ? Short.valueOf(person
						.getWeight()) : null));
		contentValues.put(PersonContract.Column.BIRTHDAY,
				DATE_FORMAT.format(person.getBirthday()));
		contentValues.put(PersonContract.Column.DOCUMENT_TYPE, person
				.getPersonPK().getDocumentTypeEnum().getDocumentType());
		contentValues.put(PersonContract.Column.E_MAIL, person.getEMail());
		contentValues.put(PersonContract.Column.FIRST_NAMES,
				person.getFirstNames());
		contentValues.put(
				PersonContract.Column.HEIGHT,
				((person.getHeight() != 0.0F) ? Float.valueOf(person
						.getHeight()) : null));
		contentValues.put(PersonContract.Column.ID_NUMBER, person.getPersonPK()
				.getIdNumber());
		contentValues.put(PersonContract.Column.LAST_NAMES,
				person.getLastNames());
		contentValues.put(PersonContract.Column.PHONE_NUMBER,
				person.getPhoneNumber());

		return (contentValues);
	}

	private boolean isValidPerson(Person person) {
		if (person == null) {

			return (false);
		}

		return (this.isValidPersonPK(person.getPersonPK()));
	}

	private boolean isValidPersonPK(PersonPK personPK) {
		if (personPK == null) {

			return (false);
		}

		if ((personPK == null) || (personPK.getDocumentTypeEnum() == null)
				|| (TextUtils.isEmpty(personPK.getIdNumber()))) {

			return (false);
		}

		return (true);
	}
}