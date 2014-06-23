package co.edu.udea.compumovil.ahorcatooth.persistance.contract;

public final class CategoryContract extends PersistanceContract{

	public static final String TABLE_NAME = "CATEGORY";

	private CategoryContract() {
		super();
	}

	public static final class Column {

		public static final String CATEGORY_NAME = "category_name";
		public static final String LANGUAGES_ISO_CODE = "languages_iso_code";
		public static final String IMAGE_NAME = "image_name";
		public static final String DESCRIPTION = "description";

		private Column() {
			super();
		}

		public static final String[] getAllColumns() {

			return (new String[] { CATEGORY_NAME, LANGUAGES_ISO_CODE,
					IMAGE_NAME, DESCRIPTION });
		}
	}
}