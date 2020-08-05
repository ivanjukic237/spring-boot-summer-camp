package com.ag04smarts.sha.models.patient;

import com.ag04smarts.sha.models.doctor.Doctor;

import javax.persistence.*;

@Entity
public class PatientTreatmentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ManyToOne
    private Patient patient;

    //@ManyToOne
    private Doctor doctor;

    @Lob
    private String treatmentRemark;
    private Status oldStatus;
    private Status newStatus;


    public PatientTreatmentHistory() {
    }

    public PatientTreatmentHistory(Patient patient, Doctor doctor, String treatmentRemark, Status oldStatus, Status newStatus) {
        this.patient = patient;
        this.doctor = doctor;
        this.treatmentRemark = treatmentRemark;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getTreatmentRemark() {
        return treatmentRemark;
    }

    public void setTreatmentRemark(String treatmentRemark) {
        this.treatmentRemark = treatmentRemark;
    }

    public Status getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(Status oldStatus) {
        this.oldStatus = oldStatus;
    }

    public Status getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(Status newStatus) {
        this.newStatus = newStatus;
    }
}
