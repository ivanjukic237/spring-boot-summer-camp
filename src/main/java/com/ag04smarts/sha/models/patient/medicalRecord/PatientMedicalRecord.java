package com.ag04smarts.sha.models.patient.medicalRecord;

import com.ag04smarts.sha.models.patient.Patient;

import javax.persistence.*;
import java.util.Set;

@Entity
public class PatientMedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@OneToOne
    private Patient patient;
    private String diagnosis;
    private String treatment;

    //@ManyToMany(fetch = FetchType.LAZY)
    private Set<Symptom> symptoms;

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

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
}
