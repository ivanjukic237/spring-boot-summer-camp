package com.ag04smarts.sha.Services.patient;

import com.ag04smarts.sha.models.Patient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

/**
 * Service for replacing, getting and deleting patients.
 *
 * @author Ivan Jukić
 */

public interface PatientService {

    /**
     * Maps every patient from a repository.
     *
     * @return collection of patients
     */

    CollectionModel<EntityModel<Patient>> mapEveryPatient();

    /**
     * Creates a new patient.
     *
     * @param newPatient new patient to be created
     * @return created patient
     */

    EntityModel<Patient> newPatient(Patient newPatient);

    /**
     * Returns a patient for a given id.
     *
     * @param id id of the patient
     * @return patient for a given id
     */

    EntityModel<Patient> getPatient(long id);

    /**
     * Replaces a patient for a given id for a new given patient.
     *
     * @param newPatient new patient to replace the old one
     * @param id         id of the patient to be replaced
     * @return new patient entity
     */

    EntityModel<Patient> replacePatient(Patient newPatient, long id);

    /**
     * Delete a patient for a given id.
     *
     * @param id id of the patient to be deleted
     */

    void deletePatient(long id);


}
