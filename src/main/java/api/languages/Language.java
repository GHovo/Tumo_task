package api.languages;

public enum Language {
    ENGLISH("gb"),
    ARMENIAN("am");

    private final String titleAttribute;

    Language(String titleAttribute) {
        this.titleAttribute = titleAttribute;
    }

    public String getTitleAttribute() {
        return titleAttribute;
    }
}
