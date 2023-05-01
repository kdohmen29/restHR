package com.astontech.resthr.exceptions;

public class ModelNotFoundException extends RuntimeException{
    public ModelNotFoundException(String id) {
        super("Could not find model with id " + id);
    }
}
