package co.edu.udea.compumovil.grupo11.example1.model.entity;

import java.io.Serializable;

import co.edu.udea.compumovil.grupo11.example1.model.enums.DocumentTypeEnum;

public class PersonPK implements Serializable {

	private static final long serialVersionUID = -2689001485643338009L;

	private DocumentTypeEnum documentTypeEnum;
	private String idNumber;

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
}