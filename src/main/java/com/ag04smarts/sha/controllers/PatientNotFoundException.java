package com.ag04smarts.sha.controllers;

public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException(Long id){
        super("Couldn't find patient: " + id);
    }
}
