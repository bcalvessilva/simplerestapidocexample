package br.com.curtaocodigo.simplerestapidocexample.doc.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * status do usuário
 */
public enum StatusEnum {
    ENABLED("enabled"),

    DISABLED("disabled"),

    PENDING_APPROVAL("pending_approval");

    private String value;

    StatusEnum(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
        for (StatusEnum b : StatusEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
