package co.edu.udea.compumovil.ahorcatooth.persistance.contract;

public class CategoryContract {

	public static final String TABLE_NAME = "CATEGORY";

	private CategoryContract() {
		super();
	}

	public static class Column {

		public static final String CATEGORY_NAME = "category_name";
		public static final String LANGUAGES_ISO_CODE = "languages_iso_code";
		public static final String IMAGE_NAME = "image_name";
		public static final String DESCRIPTION = "description";

		private Column() {
			super();
		}
	}
}