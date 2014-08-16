package co.edu.udea.compumovil.ahorcatooth.persistence.contract;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
public final class LanguagesContract extends PersistanceContract {

	public static final String TABLE_NAME = "LANGUAGES";

	private LanguagesContract() {
		super();
	}

	public static final class Column {

		public static final String ISO_CODE = "iso_code";
		public static final String TONGUE = "tongue";
		public static final String DESCRIPTION = "description";

		private Column() {
			super();
		}

		public static final String[] getAllColumns() {

			return (new String[] { ISO_CODE, TONGUE, DESCRIPTION });
		}
	}
}