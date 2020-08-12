package com.ag04smarts.sha.services.forms;

import com.ag04smarts.sha.commands.EnlistmentForm;
import com.ag04smarts.sha.controllers.patient.PatientModelAssembler;
import com.ag04smarts.sha.converters.EnlistmentFormToPatient;
import com.ag04smarts.sha.models.patient.Patient;
import com.ag04smarts.sha.repositories.PatientRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

@Service
public class EnlistmentFormService implements FormService {

    private final PatientRepository patientRepository;
    private final PatientModelAssembler patientModelAssembler;
    private final EnlistmentFormToPatient enlistmentFormToPatient;

    public EnlistmentFormService(PatientRepository patientRepository, PatientModelAssembler patientModelAssembler, EnlistmentFormToPatient enlistmentFormToPatient) {
        this.patientRepository = patientRepository;
        this.patientModelAssembler = patientModelAssembler;
        this.enlistmentFormToPatient = enlistmentFormToPatient;
    }

    @Override
    public EntityModel<Patient> newPatient(EnlistmentForm enlistmentForm) {
        return patientModelAssembler.toModel(patientRepository.save(enlistmentFormToPatient.convert(enlistmentForm)));
    }
}
