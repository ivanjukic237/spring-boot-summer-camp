package com.ag04smarts.sha.models.patient;

import com.ag04smarts.sha.models.appointment.Appointment;
import com.ag04smarts.sha.models.patient.medicalRecord.PatientMedicalRecord;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * @author Ivan Jukić
 */

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Date enlistmentDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    //@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PatientMedicalRecord patientMedicalRecord;

    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PatientTreatmentHistory> patientTreatmentHistories;

    //@OneToMany(fetch = FetchType.LAZY)
    private Set<Appointment> appointments;

    public Patient() {
    }

    public Patient(String firstName, String lastName, String email, Integer age, String phoneNumber, Gender gender,
                   Date enlistmentDate, Status status) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.enlistmentDate = enlistmentDate;
        this.status = status;

    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Set<PatientTreatmentHistory> getPatientTreatmentHistories() {
        return patientTreatmentHistories;
    }

    public void setPatientTreatmentHistories(Set<PatientTreatmentHistory> patientTreatmentHistories) {
        this.patientTreatmentHistories = patientTreatmentHistories;
    }

    public PatientMedicalRecord getPatientMedicalRecord() {
        return patientMedicalRecord;
    }

    public void setPatientMedicalRecord(PatientMedicalRecord patientMedicalRecord) {
        this.patientMedicalRecord = patientMedicalRecord;
        patientMedicalRecord.setPatient(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getEnlistmentDate() {
        return enlistmentDate;
    }

    public void setEnlistmentDate(Date enlistmentDate) {
        this.enlistmentDate = enlistmentDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id &&
                Objects.equals(firstName, patient.firstName) &&
                Objects.equals(lastName, patient.lastName) &&
                Objects.equals(email, patient.email) &&
                Objects.equals(age, patient.age) &&
                Objects.equals(phoneNumber, patient.phoneNumber) &&
                gender == patient.gender &&
                Objects.equals(enlistmentDate, patient.enlistmentDate) &&
                status == patient.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, age, phoneNumber, gender, enlistmentDate, status);
    }
}


