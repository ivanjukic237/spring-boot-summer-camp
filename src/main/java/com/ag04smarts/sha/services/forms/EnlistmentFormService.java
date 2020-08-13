package com.ag04smarts.sha.services.forms;

import com.ag04smarts.sha.commands.EnlistmentForm;
import com.ag04smarts.sha.models.patient.Patient;
import org.springframework.hateoas.EntityModel;

public interface EnlistmentFormService {

    EntityModel<Patient> newPatient(EnlistmentForm enlistmentForm);

}
