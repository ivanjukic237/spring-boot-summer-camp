package com.ag04smarts.sha.controllers.patient;

import com.ag04smarts.sha.services.patient.PatientService;
import com.ag04smarts.sha.models.Patient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

/**
 * Rest controller for http requests GET, POST, DELETE, PUT for Patient object.
 *
 * @author Ivan Jukić
 */

@RestController
public class PatientController {

    private final PatientService patientService;

    /**
     * Constructor that initializes the repository created in @PostConstruct in {@Link SHAApplication}.
     *
     * @param patientService service for http methods
     */

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    /**
     * Get method to return all of the patient in the repository.
     *
     * @return list of patients in the repository
     */

    @GetMapping("/api/patient")
    public CollectionModel<EntityModel<Patient>> all() {
        return patientService.mapEveryPatient();
    }

    /**
     * Post method for saving a new patient in the repository.
     *
     * @param newPatient new patient to be saved
     * @return the saved patient
     */

    @PostMapping("/api/patient")
    public EntityModel<Patient> newPatient(@RequestBody Patient newPatient) {
        return patientService.newPatient(newPatient);
    }

    /**
     * Get method for retrieving a specific patient given by the id parameter.
     *
     * @param id id of the patient
     * @return patient with the given id
     */

    @GetMapping("/api/patient/{id}")
    public EntityModel<Patient> one(@PathVariable Long id) {
        return patientService.getPatient(id);
    }

    /**
     * PUT http method with the given new patient entity request body and the patient id.
     *
     * @param newPatient new patient
     * @param id         id of the patient
     * @return saved patient entity
     */

    @PutMapping("/api/patient/{id}")
    public EntityModel<Patient> replacePatient(@RequestBody Patient newPatient, @PathVariable Long id) {
        return patientService.replacePatient(newPatient, id);
    }

    /**
     * Deletes the patient entity for the given id.
     *
     * @param id id of the patient entity
     */

    @DeleteMapping("/api/patient/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }
}
