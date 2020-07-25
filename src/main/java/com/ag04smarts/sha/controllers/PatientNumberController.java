package com.ag04smarts.sha.controllers;

import com.ag04smarts.sha.Services.NumberOfPatientsService;
import org.springframework.stereotype.Controller;

/**
 * Controller that returns the number of patients
 * depending on the condition given by the NumberOfPatientsService.
 *
 * @Author Ivan Jukić
 */

@Controller
public class PatientNumberController {

    private final NumberOfPatientsService numberOfPatientsService;

    /**
     * Constructor for the class.
     *
     * @param numberOfPatientsService interface of the service which provide the condition
     */

    public PatientNumberController(NumberOfPatientsService numberOfPatientsService) {
        this.numberOfPatientsService = numberOfPatientsService;
    }

    /**
     * Returns the number of patients depending on the condition from the service.
     *
     * @return number of patients
     */

    public long numberOfPatients() {
        return numberOfPatientsService.getNumberOfPatients();
    }

}
