package com.ag04smarts.sha.converters;

import com.ag04smarts.sha.commands.AppointmentForm;
import com.ag04smarts.sha.models.appointment.Appointment;
import com.ag04smarts.sha.repositories.DoctorRepository;
import com.ag04smarts.sha.repositories.PatientRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AppointmentFormToAppointment implements Converter<AppointmentForm, Appointment> {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public AppointmentFormToAppointment(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public Appointment convert(AppointmentForm source) {
        if (source == null) {
            return null;
        }

        final Appointment appointment = new Appointment();

        appointment.setAppointmentDate(source.getAppointmentDate());
        appointment.setDoctor(doctorRepository.findById(source.getDoctorId()).orElseThrow());
        appointment.setPatient(patientRepository.findById(source.getPatientId()).orElseThrow());

        return appointment;
    }

}
