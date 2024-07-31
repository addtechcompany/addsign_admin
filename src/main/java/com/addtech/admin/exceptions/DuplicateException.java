package com.addtech.admin.exceptions;

public class DuplicateException extends Exception {
    public DuplicateException(String message) {
        super(message);
    }

    public DuplicateException(String obj,
                              String value,
                              String attribute) {
        this(obj + " с " + attribute + "='" + value + "' уже существует");
    }

}
