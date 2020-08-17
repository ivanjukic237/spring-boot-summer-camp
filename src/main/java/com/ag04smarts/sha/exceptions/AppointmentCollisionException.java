package com.ag04smarts.sha.exceptions;

public class AppointmentCollisionException extends RuntimeException {

    public AppointmentCollisionException() {
        super("Person already has an appointment at that date.");
    }
}
