package co.edu.udea.compumovil.ahorcatooth.persistance.contract;

public class LanguagesContract {

	public static final String TABLE_NAME = "LANGUAGES";

	private LanguagesContract() {
		super();
	}

	public static class Column {

		public static final String ISO_CODE = "iso_code";
		public static final String TONGUE = "tongue";
		public static final String DESCRIPTION = "description";

		private Column() {
			super();
		}
	}
}