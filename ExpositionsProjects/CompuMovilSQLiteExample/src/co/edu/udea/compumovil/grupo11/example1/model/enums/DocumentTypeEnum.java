package co.edu.udea.compumovil.grupo11.example1.model.enums;

import java.util.ArrayList;
import java.util.List;

public enum DocumentTypeEnum {

	CEDULA_DE_CIUDADANIA("Cédula de Ciudadanía"), CEDULA_DE_EXTRANJERIA(
			"Cédula de Extranjería"), NUMERO_IDENTIFICACION_PERSONAL(
			"Número Único de Identificación Personal"), REGISTRO_CIVIL(
			"Registro Civil"), TARJETA_DE_IDENTIDAD("Tarjeta de Identidad");
	private String documentType;

	private DocumentTypeEnum(String documentType) {
		this.setDocumentType(documentType);
	}

	public String getDocumentType() {

		return (this.documentType);
	}

	private void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public static List<String> obtainDocumentsTypesList() {
		List<String> documentsTypeList = new ArrayList<String>();

		for (DocumentTypeEnum e : DocumentTypeEnum.values()) {
			documentsTypeList.add(e.getDocumentType());
		}

		return (documentsTypeList);
	}

	@Override()
	public String toString() {

		return (this.getDocumentType());
	}
}