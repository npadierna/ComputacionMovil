package co.edu.udea.compumovil.ahorcatooth.persistance.contract;

public final class HangmanWordContract {

	public static final String TABLE_NAME = "HANGMAN_WORD";

	private HangmanWordContract() {
		super();
	}

	public static final class Column {

		public static final String ID = "id";
		public static final String WORD_NAME = "word_name";
		public static final String DESCRIPTION = "description";
		public static final String CATEGORY_NAME = "category_name";
		public static final String LANGUAGES_ISO_CODE = "languages_iso_code";

		private Column() {
			super();
		}

		public static final String[] getAllColumns() {

			return (new String[] { ID, WORD_NAME, DESCRIPTION, CATEGORY_NAME,
					LANGUAGES_ISO_CODE });
		}
	}
}