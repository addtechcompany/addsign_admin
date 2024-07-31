package com.addtech.admin.exceptions;

public class UpdateException extends RuntimeException {

    public UpdateException() {
        super("Обновление неактуальных данные");
    }

    public UpdateException(String message) {
        super(message);
    }
}
