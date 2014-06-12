package co.edu.udea.compumovil.ahorcatooth.webservice.contract;

public final class WebServicePathsContract {

    public static final String ROOT_CONTEXT = "/rest";

    private WebServicePathsContract() {
        super();
    }

    public static final class CategoryContract {

        public static final String END_POINT_INTERFACE = "co.edu.udea.compumovil.ahorcatooth.webservice.ICategoryWS";
        public static final String ROOT_PATH = "/categories";
        public static final String ALL_CATEGORIES_PATH = ROOT_PATH + "/all";

        private CategoryContract() {
            super();
        }
    }

    public static final class HangmanWordContract {

        public static final String END_POINT_INTERFACE = "co.edu.udea.compumovil.ahorcatooth.webservice.IHangmanWordWS";
        public static final String ROOT_PATH = "/hangmanwords";

        private HangmanWordContract() {
            super();
        }
    }

    public static final class LanguagesContract {

        public static final String END_POINT_INTERFACE = "co.edu.udea.compumovil.ahorcatooth.webservice.ILanguagesWS";
        public static final String ROOT_PATH = "/languages";

        private LanguagesContract() {
            super();
        }
    }

    public static final class WordContract {

        public static final String END_POINT_INTERFACE = "co.edu.udea.compumovil.ahorcatooth.webservice.IWordWS";
        public static final String ROOT_PATH = "/words";

        private WordContract() {
            super();
        }
    }
}