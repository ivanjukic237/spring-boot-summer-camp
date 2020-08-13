package com.ag04smarts.sha.controllers.forms;

import com.ag04smarts.sha.commands.EnlistmentForm;
import com.ag04smarts.sha.models.patient.Patient;
import com.ag04smarts.sha.services.forms.EnlistmentFormService;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnlistmentController {

    private final EnlistmentFormService enlistmentFormService;

    public EnlistmentController(EnlistmentFormService enlistmentFormService) {
        this.enlistmentFormService = enlistmentFormService;
    }

    @PostMapping("api/enlistmentForm")
    public EntityModel<Patient> newPatient(@ModelAttribute EnlistmentForm enlistmentForm) {
        return enlistmentFormService.newPatient(enlistmentForm);
    }
}
