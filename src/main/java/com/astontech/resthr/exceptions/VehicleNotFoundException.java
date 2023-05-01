package com.astontech.resthr.exceptions;

public class VehicleNotFoundException extends RuntimeException {
    public VehicleNotFoundException(String id) {
        super("Could not find vehicle with id " + id);
    }
}
