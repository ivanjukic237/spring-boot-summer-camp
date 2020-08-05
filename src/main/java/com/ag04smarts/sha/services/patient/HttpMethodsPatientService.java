package com.ag04smarts.sha.services.patient;

import com.ag04smarts.sha.controllers.patient.PatientController;
import com.ag04smarts.sha.controllers.patient.PatientModelAssembler;
import com.ag04smarts.sha.controllers.patient.PatientNotFoundException;
import com.ag04smarts.sha.models.patient.Patient;
import com.ag04smarts.sha.repositories.PatientRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Implementation of the PatientService for replacing, getting and deleting patients.
 *
 * @author Ivan Jukić
 */

@Service
public class HttpMethodsPatientService implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientModelAssembler patientModelAssembler;

    /**
     * Constructor for the class.
     *
     * @param patientRepository     repository of Patient entities
     * @param patientModelAssembler hyperlink patient model assembler
     */

    public HttpMethodsPatientService(PatientRepository patientRepository, PatientModelAssembler patientModelAssembler) {
        this.patientRepository = patientRepository;
        this.patientModelAssembler = patientModelAssembler;
    }

    /**
     * Returns all of the patients in the repository given as a hyperlink model.
     *
     * @return collection of all patients from the repository
     */

    @Override
    public CollectionModel<EntityModel<Patient>> mapEveryPatient() {
        //Maps every patient in repository to EntityModel<Patient> and puts them in the List<EntityModel<Patient>>.
        List<EntityModel<Patient>> patients = patientRepository.findAll()
                .stream()
                .map(patient -> patientModelAssembler.toModel(patient))
                .collect(Collectors.toList());

        return CollectionModel.of(patients,
                linkTo(methodOn(PatientController.class).all()).withSelfRel());
    }

    /**
     * Creates a new patient as a hyperlink model and adds it in the repository.
     *
     * @param newPatient new patient to be created
     * @return created patient
     */

    @Override
    public EntityModel<Patient> newPatient(Patient newPatient) {
        return patientModelAssembler.toModel(patientRepository.save(newPatient));
    }

    /**
     * Returns a specific patient for the given id.
     *
     * @param id id of the patient
     * @return created patient
     */

    @Override
    public EntityModel<Patient> getPatient(long id) {
        Patient patient = patientRepository.findById(id).
                orElseThrow(() -> new
                        PatientNotFoundException(id));
        return patientModelAssembler.toModel(patient);
    }

    /**
     * Method to replace the patient for the given id.
     * If the patient by the given id exists, then all attributes of the patient
     * is replaced by the attributes of the given patient. If the patient by the
     * given id doesn't exist, then an exception is thrown.
     *
     * @param newPatient new patient to replace the old one
     * @param id         id of the patient
     * @return created or replaced patient
     */

    @Override
    public EntityModel<Patient> replacePatient(Patient newPatient, long id) {

        Patient patient = patientRepository.findById(id).
                orElseThrow(() -> new
                        PatientNotFoundException(id));

        patient.setFirstName(newPatient.getFirstName());
        patient.setLastName(newPatient.getLastName());
        patient.setAge(newPatient.getAge());
        patient.setEmail(newPatient.getEmail());
        patient.setPhoneNumber(newPatient.getPhoneNumber());
        patient.setGender(newPatient.getGender());
        patient.setEnlistmentDate(newPatient.getEnlistmentDate());
        patient.setStatus(newPatient.getStatus());

        return patientModelAssembler.toModel(patientRepository.save(patient));
    }

    /**
     * Deletes a patient from the repository for a given id.
     *
     * @param id id of the patient to be deleted
     */

    @Override
    public void deletePatient(long id) {
        patientRepository.deleteById(id);
    }
}