package co.edu.udea.compumovil.grupo11.example1.database.dao;

import java.util.List;

import co.edu.udea.compumovil.grupo11.example1.model.entity.Person;
import co.edu.udea.compumovil.grupo11.example1.model.entity.PersonPK;
import co.edu.udea.compumovil.grupo11.example1.model.enums.DocumentTypeEnum;

public interface IPersonDAO {

	public Person deletePerson(PersonPK personPK);

	public List<Person> findAllPersons();

	public Person findPerson(PersonPK personPK);

	public List<Person> findPersonsByAgeRange(short lower, short upper);

	public List<Person> findPersonsByDocumentType(
			DocumentTypeEnum documentTypeEnum);

	public Person savePerson(Person person);

	public Person updatePerson(Person person);

	public long countPersons();
}