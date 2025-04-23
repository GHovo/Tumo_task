package configs.reader;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizationReader {
    private final ResourceBundle bundle;

    public LocalizationReader(String langCode) {
        Locale locale = new Locale(langCode);
        this.bundle = ResourceBundle.getBundle("texts", locale);
    }

    public String get(String key) {
        return bundle.getString(key);
    }
}
