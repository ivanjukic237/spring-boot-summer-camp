package com.ag04smarts.sha.exceptions;

/**
 * Custom exception class for when the http methods can't find a Person in
 * the repository.
 *
 * @author Ivan Jukić
 */

public class PersonNotFoundException extends RuntimeException {

    /**
     * Constructor for the exception. It shows the custom error message containing the id of the missing patient.
     *
     * @param id id of the missing patient
     */

    public PersonNotFoundException(Long id, String personName) {
        super("Couldn't find " + personName + " with id: " + id);
    }
}
