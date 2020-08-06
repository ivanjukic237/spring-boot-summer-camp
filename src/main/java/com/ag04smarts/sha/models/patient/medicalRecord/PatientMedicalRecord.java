package com.ag04smarts.sha.models.patient.medicalRecord;

import com.ag04smarts.sha.models.patient.Patient;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class PatientMedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Patient patient;

    private String diagnosis;
    private String treatment;

    @ManyToMany(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Symptom> symptoms;

    public PatientMedicalRecord(Patient patient, String diagnosis, String treatment) {
        this.patient = patient;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public PatientMedicalRecord() {
    }
}
