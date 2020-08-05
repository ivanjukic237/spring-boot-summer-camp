package com.ag04smarts.sha.models.doctor;

import com.ag04smarts.sha.models.appointment.Appointment;
import com.ag04smarts.sha.models.patient.PatientTreatmentHistory;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private DoctorExpertise doctorExpertise;

    //@OneToMany
    private Set<PatientTreatmentHistory> patientTreatmentHistories;

    //@OneToMany
    private Set<Appointment> appointments;

    public Doctor() {
    }

    public Doctor(String firstName, String lastName, DoctorExpertise doctorExpertise) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.doctorExpertise = doctorExpertise;
    }

    public Set<PatientTreatmentHistory> getPatientTreatmentHistories() {
        return patientTreatmentHistories;
    }

    public void setPatientTreatmentHistories(Set<PatientTreatmentHistory> patientTreatmentHistories) {
        this.patientTreatmentHistories = patientTreatmentHistories;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DoctorExpertise getDoctorExpertise() {
        return doctorExpertise;
    }

    public void setDoctorExpertise(DoctorExpertise doctorExpertise) {
        this.doctorExpertise = doctorExpertise;
    }
}
