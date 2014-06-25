package co.edu.udea.compumovil.ahorcatooth.process.util;

public final class TextUtils {

    private TextUtils() {
        super();
    }

    public static boolean isEmpty(String text) {

        return ((text == null) || (text.trim().isEmpty()));
    }
}