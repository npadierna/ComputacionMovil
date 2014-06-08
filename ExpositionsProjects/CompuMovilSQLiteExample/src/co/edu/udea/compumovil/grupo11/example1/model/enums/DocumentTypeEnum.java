package co.edu.udea.compumovil.grupo11.example1.model.enums;

import java.util.ArrayList;
import java.util.List;

public enum DocumentTypeEnum {

	CEDULA_DE_CIUDADANIA("C�dula de Ciudadan�a"), CEDULA_DE_EXTRANJERIA(
			"C�dula de Extranjer�a"), NUMERO_IDENTIFICACION_PERSONAL(
			"N�mero �nico de Identificaci�n Personal"), REGISTRO_CIVIL(
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