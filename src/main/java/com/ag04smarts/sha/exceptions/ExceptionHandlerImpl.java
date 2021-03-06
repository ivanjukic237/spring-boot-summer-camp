package com.ag04smarts.sha.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Controller advice class that sends the response with the custom error message.
 *
 * @author Ivan Jukić
 */

@ControllerAdvice
public class ExceptionHandlerImpl {

    @ResponseBody
    @ExceptionHandler(PersonNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String patientNotFoundHandler(PersonNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(AppointmentCollisionException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String appointmentCollisionHandler(AppointmentCollisionException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ImageUploadException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String imageUploadHandler(ImageUploadException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(UpdateException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String updateHandler(UpdateException ex) {
        return ex.getMessage();
    }

}
