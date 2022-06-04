package br.com.curtaocodigo.simplerestapidocexample.doc.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * grupo do usuário
 */
public enum GroupEnum {
    USER("user"),

    MANAGER("manager"),

    ADMIN("admin");

    private String value;

    GroupEnum(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static GroupEnum fromValue(String text) {
        for (GroupEnum b : GroupEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
