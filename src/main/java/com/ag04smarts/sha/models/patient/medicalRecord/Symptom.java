package com.ag04smarts.sha.models.patient.medicalRecord;

import lombok.Data;

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
    private Set<PatientMedicalRecord> patientMedicalRecords;

}
