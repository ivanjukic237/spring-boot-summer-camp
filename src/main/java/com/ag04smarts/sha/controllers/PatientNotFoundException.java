package com.ag04smarts.sha.controllers;

/**
 * Custom exception class for when the http methods can't find the patient in
 * the repository.
 *
 * @Author Ivan Jukić
 */

public class PatientNotFoundException extends RuntimeException {

    /**
     * Constructor for the exception. It shows the custom error message containing the id of the missing patient.
     *
     * @param id id of the missing patient
     */

    public PatientNotFoundException(Long id) {
        super("Couldn't find patient: " + id);
    }
}
