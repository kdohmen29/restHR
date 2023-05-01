package com.astontech.resthr.exceptions;

public class MakeAlreadyExistsException extends RuntimeException{
    public MakeAlreadyExistsException(String makeName) {
        super(makeName + " is already in the database");
    }
}
