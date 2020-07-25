package com.ag04smarts.sha.controllers;

import com.ag04smarts.sha.models.Patient;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Assembles the hypermedia for Patient entity.
 *
 * @Author Ivan Jukić
 */

@Component
public class PatientModelAssembler implements RepresentationModelAssembler<Patient, EntityModel<Patient>> {

    /**
     * Creates the EntityModel for one patient with links in reference to self and all patients.
     *
     * @param patient patient object to model as EntityModel.
     * @return EntityModel of the patient with link references
     */

    @Override
    public EntityModel<Patient> toModel(Patient patient) {
        return EntityModel.of(patient,
                linkTo(methodOn(PatientController.class).one(patient.getId())).withSelfRel(),
                linkTo(methodOn(PatientController.class).all()).withRel("api/patient"));
    }

}
