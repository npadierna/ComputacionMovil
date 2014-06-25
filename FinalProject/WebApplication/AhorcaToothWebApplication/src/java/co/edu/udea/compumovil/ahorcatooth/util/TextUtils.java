package co.edu.udea.compumovil.ahorcatooth.util;

public final class TextUtils {

    private TextUtils() {
        super();
    }

    public static boolean isEmpty(String text) {

        return ((text == null) || (text.trim().isEmpty()));
    }

    public static String toLowerCase(String text) {

        return (text.trim().toLowerCase());
    }

    public static String toUpperCase(String text) {

        return (text.trim().toUpperCase());
    }
}