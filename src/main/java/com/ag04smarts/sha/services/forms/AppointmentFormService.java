package com.ag04smarts.sha.services.forms;

import com.ag04smarts.sha.commands.AppointmentForm;
import com.ag04smarts.sha.models.appointment.Appointment;

public interface AppointmentFormService {

    Appointment newAppointment(AppointmentForm appointmentForm);
}
