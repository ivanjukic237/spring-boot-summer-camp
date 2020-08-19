package com.ag04smarts.sha.controllers.forms;

import com.ag04smarts.sha.commands.EnlistmentForm;
import com.ag04smarts.sha.models.patient.Patient;
import com.ag04smarts.sha.services.forms.EnlistmentFormService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api
@RestController
public class EnlistmentController {

    private final EnlistmentFormService enlistmentFormService;

    public EnlistmentController(EnlistmentFormService enlistmentFormService) {
        this.enlistmentFormService = enlistmentFormService;
    }

    @ApiOperation(value = "Adds a new patient.")
    @PostMapping("api/enlistmentForm")
    public EntityModel<Patient> newPatient(@RequestBody @Valid EnlistmentForm enlistmentForm) {
        return enlistmentFormService.newPatient(enlistmentForm);
    }
}
