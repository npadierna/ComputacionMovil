package co.edu.udea.compumovil.grupo11.example1.model.entity;

import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;
import co.edu.udea.compumovil.grupo11.example1.model.enums.DocumentTypeEnum;

public class PersonPK implements Parcelable, Serializable {

	private static final long serialVersionUID = -2689001485643338009L;

	private DocumentTypeEnum documentTypeEnum;
	private String idNumber;

	public PersonPK(Parcel parcel) {
		this.setIdNumber(parcel.readString());
		this.setDocumentTypeEnum(DocumentTypeEnum
				.findDocumentTypeEmunByDocumentType(parcel.readString()));
	}

	public PersonPK(DocumentTypeEnum documentTypeEnum, String idNumber) {
		super();
		this.documentTypeEnum = documentTypeEnum;
		this.idNumber = idNumber;
	}

	public DocumentTypeEnum getDocumentTypeEnum() {

		return (this.documentTypeEnum);
	}

	public void setDocumentTypeEnum(DocumentTypeEnum documentTypeEnum) {
		this.documentTypeEnum = documentTypeEnum;
	}

	public String getIdNumber() {

		return (this.idNumber);
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	@Override()
	public String toString() {

		return (String.format("[%s, %s]",
				this.getDocumentTypeEnum().toString(), this.getIdNumber()));
	}

	@Override()
	public int describeContents() {

		return (0);
	}

	@Override()
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.getIdNumber());
		dest.writeString(this.getDocumentTypeEnum().getDocumentType());
	}

	public static final Parcelable.Creator<PersonPK> CREATOR = new Parcelable.Creator<PersonPK>() {

		@Override()
		public PersonPK createFromParcel(Parcel source) {

			return (new PersonPK(source));
		}

		@Override()
		public PersonPK[] newArray(int size) {

			return (new PersonPK[size]);
		}
	};
}