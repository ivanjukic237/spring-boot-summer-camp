package com.ag04smarts.sha.controllers;

import com.ag04smarts.sha.models.Patient;
import org.springframework.web.bind.annotation.*;
import com.ag04smarts.sha.repositories.PatientRepository;

import java.util.List;

/**
 * Rest controller for http requests GET, POST, DELETE, PUT for Patient object.
 *
 * @Author Ivan Jukić
 */

@RestController
public class PatientController {

    private final PatientRepository patientRepository;

    /**
     * Constructor that initializes the repository created in @PostConstruct in {@Link SHAApplication}.
     *
     * @param patientRepository repository of patients
     */

    public PatientController(PatientRepository patientRepository) {

        this.patientRepository = patientRepository;
    }

    /**
     * Get method to return all of the patient in the repository.
     *
     * @return list of patients in the repository
     */

    @GetMapping("/api/patient")
    List<Patient> all() {
        return patientRepository.findAll();
    }

    /**
     * Post method for saving a new patient in the repository.
     *
     * @param newPatient new patient to be saved
     * @return the saved patient
     */

    @PostMapping("/api/patient")
    Patient newPatient(@RequestBody Patient newPatient) {
        return patientRepository.save(newPatient);
    }

    /**
     * Get method for retrieving a specific patient given by the id parameter.
     *
     * @param id id of the patient
     * @return patient with the given id
     */

    @GetMapping("/api/patient/{id}")
    Patient one(@PathVariable Long id) {
        return patientRepository.findById(id).
                orElseThrow(() -> new
                        PatientNotFoundException(id));
    }

    /**
     * PUT http method with the given new patient entity request body and the patient id.
     * If the patient by the given id exists, then all attributes of the patient
     * is replaced by the attributes of the given patient. If the patient by the
     * given id doesn't exist, then a new patient is created and saved.
     *
     * @param newPatient new patient
     * @param id         id of the patient
     * @return saved patient entity
     */

    @PutMapping("/api/patient/{id}")
    Patient replacePatient(@RequestBody Patient newPatient, @PathVariable Long id) {
        return patientRepository.findById(id)
                .map(patient -> {
                    patient.setFirstName(newPatient.getFirstName());
                    patient.setLastName(newPatient.getLastName());
                    patient.setDateOfBirth(newPatient.getDateOfBirth());
                    patient.setSex(newPatient.getSex());
                    patient.setTherapy(newPatient.getTherapy());
                    patient.setSSN(newPatient.getSSN());
                    return patientRepository.save(newPatient);
                })
                .orElseGet(() -> {
                    newPatient.setId(id);
                    return patientRepository.save(newPatient);
                });
    }

    /**
     * Deletes the patient entity for the given id.
     *
     * @param id id of the patient entity
     */

    @DeleteMapping("/api/{id}")
    void deletePatient(@PathVariable Long id) {
        patientRepository.deleteById(id);
    }
}
