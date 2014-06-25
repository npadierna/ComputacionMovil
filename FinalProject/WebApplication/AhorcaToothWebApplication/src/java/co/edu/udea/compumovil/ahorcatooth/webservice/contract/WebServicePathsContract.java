package co.edu.udea.compumovil.ahorcatooth.webservice.contract;

public final class WebServicePathsContract {

    public static final String ROOT_CONTEXT_PATH = "/rest";

    private WebServicePathsContract() {
        super();
    }

    public static final class CategoryContract {

        /*
         * Paths
         */
        public static final String ALL_CATEGORIES_PATH = "/all";
        public static final String END_POINT_INTERFACE = "co.edu.udea.compumovil.ahorcatooth.webservice.ICategoryWS";
        public static final String FIND_ONE_CATEGORY_PATH = "/find";
        public static final String ROOT_PATH = "/categories";
        /*
         * Query Params
         */
        public static final String CATEGORY_NAME_QUERY = "categoryname";
        public static final String LANGUAGES_ISO_CODE_QUERY = "languagesisocode";

        private CategoryContract() {
            super();
        }
    }

    public static final class HangmanWordContract {

        /*
         * Paths
         */
        public static final String END_POINT_INTERFACE = "co.edu.udea.compumovil.ahorcatooth.webservice.IHangmanWordWS";
        public static final String FIND_HANGMANS_WORDS_BY_CATEGORY_NAME_PATH = "/find/categoryname";
        public static final String ROOT_PATH = "/hangmanwords";
        /*
         * Query Params
         */
        public static final String CATEGORY_NAME_QUERY = "categoryname";
        public static final String LANGUAGE_ISO_CODE_QUERY = "languageisocode";

        private HangmanWordContract() {
            super();
        }
    }

    public static final class LanguagesContract {

        /*
         * Paths
         */
        public static final String ALL_LANGUAGES_PATH = "/all";
        public static final String END_POINT_INTERFACE = "co.edu.udea.compumovil.ahorcatooth.webservice.ILanguagesWS";
        public static final String FIND_ONE_LANGUAGES_PATH = "/find";
        public static final String ROOT_PATH = "/languages";
        /*
         * Query Params
         */
        public static final String LANGUAGES_ISO_CODE_QUERY = "isocode";

        private LanguagesContract() {
            super();
        }
    }
}