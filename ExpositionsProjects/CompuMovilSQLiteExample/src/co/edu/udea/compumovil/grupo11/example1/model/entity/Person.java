package co.edu.udea.compumovil.grupo11.example1.model.entity;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {

	private static final long serialVersionUID = -2712375203727001082L;

	private PersonPK personPK;
	private String firstNames;
	private String lastNames;
	private String eMail;
	private Date birthday;
	private String phoneNumber;
	private short weight;
	private float height;

	public Person(PersonPK personPK, String firstNames, String lastNames,
			Date birthday) {
		super();
		this.personPK = personPK;
		this.firstNames = firstNames;
		this.lastNames = lastNames;
		this.birthday = birthday;
	}

	public PersonPK getPersonPK() {

		return (this.personPK);
	}

	public void setPersonPK(PersonPK personPK) {
		this.personPK = personPK;
	}

	public String getFirstNames() {

		return (this.firstNames);
	}

	public void setFirstNames(String firstNames) {
		this.firstNames = firstNames;
	}

	public String getLastNames() {

		return (this.lastNames);
	}

	public void setLastNames(String lastNames) {
		this.lastNames = lastNames;
	}

	public String getEMail() {

		return (this.eMail);
	}

	public void setEMail(String eMail) {
		this.eMail = eMail;
	}

	public Date getBirthday() {

		return (this.birthday);
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhoneNumber() {

		return (this.phoneNumber);
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public short getWeight() {

		return (this.weight);
	}

	public void setWeight(short weight) {
		this.weight = weight;
	}

	public float getHeight() {

		return (this.height);
	}

	public void setHeight(float height) {
		this.height = height;
	}
}