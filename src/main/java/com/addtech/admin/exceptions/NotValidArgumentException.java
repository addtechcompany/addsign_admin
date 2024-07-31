package com.addtech.admin.exceptions;

import lombok.Getter;

@Getter
public class NotValidArgumentException extends Exception {
    private final String field;

    public NotValidArgumentException(String field, String message) {
        super(message);

        this.field = field;
    }

}
