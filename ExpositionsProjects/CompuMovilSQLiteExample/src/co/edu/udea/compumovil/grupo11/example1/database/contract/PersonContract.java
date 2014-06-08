package co.edu.udea.compumovil.grupo11.example1.database.contract;

public final class PersonContract {

	public static final short DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "SQLite_Example.db";
	public static final String TABLE_NAME = "PERSON";

	private PersonContract() {
		super();
	}

	public final class Column {

		public static final String DOCUMENT_TYPE = "DOCUMENT_TYPE";
		public static final String ID_NUMBER = "ID_NUMBER";
		public static final String FIRST_NAMES = "FIRST_NAMES";
		public static final String LAST_NAMES = "LAST_NAMES";
		public static final String E_MAIL = "E_MAIL";
		public static final String BIRTHDAY = "BIRTHDAY";
		public static final String PHONE_NUMBER = "PHONE_NUMBER";
		public static final String AGE = "AGE";
		public static final String HEIGHT = "HEIGHT";

		public Column() {
			super();
		}
	}
}