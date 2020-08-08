package com.ag04smarts.sha.models.patient.medicalRecord;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Symptom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String description;

    @ManyToMany(mappedBy = "symptoms")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<PatientMedicalRecord> patientMedicalRecords;

    public Symptom() {
    }

    public Symptom(String description) {
        this.description = description;
    }
}
