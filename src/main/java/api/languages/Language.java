package api.languages;

import lombok.Getter;

@Getter
public enum Language {
    ENGLISH("gb"),
    ARMENIAN("am");

    private final String titleAttribute;

    Language(String titleAttribute) {
        this.titleAttribute = titleAttribute;
    }

}
