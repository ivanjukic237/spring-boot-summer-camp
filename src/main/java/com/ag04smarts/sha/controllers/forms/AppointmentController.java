package com.ag04smarts.sha.controllers.forms;

import com.ag04smarts.sha.commands.AppointmentForm;
import com.ag04smarts.sha.models.appointment.Appointment;
import com.ag04smarts.sha.services.forms.AppointmentFormService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {

    private final AppointmentFormService appointmentFormService;

    public AppointmentController(AppointmentFormService appointmentFormService) {
        this.appointmentFormService = appointmentFormService;
    }

    @PostMapping("api/newAppointment")
    public Appointment newAppointment(@ModelAttribute AppointmentForm appointmentForm) {
        return appointmentFormService.newAppointment(appointmentForm);
    }
}
