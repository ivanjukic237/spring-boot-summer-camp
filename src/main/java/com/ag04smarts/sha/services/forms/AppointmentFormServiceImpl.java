package com.ag04smarts.sha.services.forms;

import com.ag04smarts.sha.commands.AppointmentForm;
import com.ag04smarts.sha.converters.AppointmentFormToAppointment;
import com.ag04smarts.sha.exceptions.AppointmentCollisionException;
import com.ag04smarts.sha.models.appointment.Appointment;
import com.ag04smarts.sha.repositories.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;

@Service
public class AppointmentFormServiceImpl implements AppointmentFormService {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentFormToAppointment appointmentFormToAppointment;

    public AppointmentFormServiceImpl(AppointmentRepository appointmentRepository, AppointmentFormToAppointment appointmentFormToAppointment) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentFormToAppointment = appointmentFormToAppointment;
    }

    @Override
    public Appointment newAppointment(AppointmentForm appointmentForm) {
        Appointment appointment = appointmentFormToAppointment.convert(appointmentForm);

        checkIfDatesCollide(appointment.getDoctor().getAppointments(), appointment.getAppointmentDate());
        checkIfDatesCollide(appointment.getPatient().getAppointments(), appointment.getAppointmentDate());

        //if check doesn't throw exception, then add an appointment to doctor and patient
        appointment.getDoctor().getAppointments().add(appointment);
        appointment.getPatient().getAppointments().add(appointment);

        return appointmentRepository.save(appointment);
    }

    private void checkIfDatesCollide(Set<Appointment> appointments, Date dateOfNewAppointment) {
        int yearNewAppointment = dateOfNewAppointment.getYear();
        int monthNewAppointment = dateOfNewAppointment.getMonth();
        int dayNewAppointment = dateOfNewAppointment.getDay();

        for (Appointment appointment : appointments) {
            int year = appointment.getAppointmentDate().getYear();
            int month = appointment.getAppointmentDate().getMonth();
            int day = appointment.getAppointmentDate().getDay();

            if (yearNewAppointment == year && monthNewAppointment == month && dayNewAppointment == day) {
                throw new AppointmentCollisionException();
            }
        }
    }
}
