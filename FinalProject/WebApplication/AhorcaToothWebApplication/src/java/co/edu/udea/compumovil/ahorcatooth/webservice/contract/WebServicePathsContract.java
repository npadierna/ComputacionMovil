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
        public static final String END_POINT_INTERFACE = "co.edu.udea.compumovil.ahorcatooth.webservice.ICategoryWS";
        public static final String FIND_ALL_CATEGORIES_PATH = "/find/all";
        public static final String FIND_CATEGORIES_BY_LANGUAGES_ISO_CODE_PATH = "/find/languagesisocode";
        public static final String FIND_ONE_CATEGORY_PATH = "/find";
        public static final String ROOT_PATH = "/categories";
        /*
         * Query Parameters
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
        public static final String FIND_HANGMANS_WORDS_BY_LANGUAGES_ISO_CODE_PATH = "/find/languagesisocode";
        public static final String FIND_LASTEST_HANGMANS_WORDS_PATH = "/find/latest";
        public static final String ROOT_PATH = "/hangmanswords";
        /*
         * Query Parameters
         */
        public static final String CATEGORY_NAME_QUERY = "categoryname";
        public static final String LANGUAGES_ISO_CODE_QUERY = "languagesisocode";
        public static final String MAX_HANGMANS_WORDS_QUERY = "amount";

        private HangmanWordContract() {
            super();
        }
    }

    public static final class LanguagesContract {

        /*
         * Paths
         */
        public static final String END_POINT_INTERFACE = "co.edu.udea.compumovil.ahorcatooth.webservice.ILanguagesWS";
        public static final String FIND_ALL_LANGUAGES_PATH = "/find/all";
        public static final String FIND_ONE_LANGUAGES_PATH = "/find";
        public static final String ROOT_PATH = "/languages";
        /*
         * Query Parameters
         */
        public static final String LANGUAGES_ISO_CODE_QUERY = "isocode";

        private LanguagesContract() {
            super();
        }
    }
}