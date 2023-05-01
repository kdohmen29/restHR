package com.astontech.resthr.exceptions;

public class MakeNotFoundException extends RuntimeException {

    public MakeNotFoundException(String id) {
        super("Could not find make with id: " + id);
    }

}
