package com.ag04smarts.sha.Services;

import com.ag04smarts.sha.controllers.PatientController;
import com.ag04smarts.sha.controllers.PatientModelAssembler;
import com.ag04smarts.sha.controllers.PatientNotFoundException;
import com.ag04smarts.sha.models.Patient;
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
 * @Author Ivan Jukić
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
     * given id doesn't exist, then a new patient is created and saved.
     *
     * @param newPatient new patient to replace the old one
     * @param id         id of the patient
     * @return created or replaced patient
     */

    @Override
    public EntityModel<Patient> replacePatient(Patient newPatient, long id) {
        return patientModelAssembler.toModel(patientRepository.findById(id)
                .map(patient -> {
                    patient.setFirstName(newPatient.getFirstName());
                    patient.setLastName(newPatient.getLastName());
                    patient.setDateOfBirth(newPatient.getDateOfBirth());
                    patient.setSex(newPatient.getSex());
                    patient.setTherapy(newPatient.getTherapy());
                    patient.setSSN(newPatient.getSSN());
                    return patientRepository.save(patient);
                })
                .orElseGet(() -> {
                    newPatient.setId(id);
                    return patientRepository.save(newPatient);
                }));
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
