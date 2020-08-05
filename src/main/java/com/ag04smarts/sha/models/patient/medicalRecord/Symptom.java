package com.ag04smarts.sha.models.patient.medicalRecord;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Symptom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String description;

    //@ManyToMany(mappedBy = "symptoms")
    private Set<PatientMedicalRecord> patientMedicalRecords;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
