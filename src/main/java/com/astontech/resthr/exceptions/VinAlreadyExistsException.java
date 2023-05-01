package com.astontech.resthr.exceptions;

public class VinAlreadyExistsException extends RuntimeException {

    public VinAlreadyExistsException(String vin) {
        super("This VIN is already in the database " + vin);
    }

}
