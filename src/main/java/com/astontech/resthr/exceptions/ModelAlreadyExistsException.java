package com.astontech.resthr.exceptions;

public class ModelAlreadyExistsException extends RuntimeException{
    public ModelAlreadyExistsException(String modelName) {
        super(modelName + " is already in the database");
    }
}
