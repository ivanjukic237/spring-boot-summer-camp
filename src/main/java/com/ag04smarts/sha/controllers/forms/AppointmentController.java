package com.ag04smarts.sha.controllers.forms;

import com.ag04smarts.sha.commands.AppointmentForm;
import com.ag04smarts.sha.models.appointment.Appointment;
import com.ag04smarts.sha.services.forms.AppointmentFormService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
public class AppointmentController {

    private final AppointmentFormService appointmentFormService;

    public AppointmentController(AppointmentFormService appointmentFormService) {
        this.appointmentFormService = appointmentFormService;
    }

    @ApiOperation(value = "Adds a new appointment.")
    @PostMapping("api/newAppointment")
    public Appointment newAppointment(@RequestBody AppointmentForm appointmentForm) {
        return appointmentFormService.newAppointment(appointmentForm);
    }
}
