package com.ag04smarts.sha.controllers.patient;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Controller advice class that sends the response with the custom error message
 * from the {@link PatientNotFoundException}.
 *
 * @author Ivan Jukić
 */

@ControllerAdvice
public class PatientNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(PatientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String patientNotFoundHandler(PatientNotFoundException ex) {
        return ex.getMessage();
    }
}
