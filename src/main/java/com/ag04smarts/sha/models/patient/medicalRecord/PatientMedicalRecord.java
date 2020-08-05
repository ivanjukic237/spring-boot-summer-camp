package com.ag04smarts.sha.models.patient.medicalRecord;

import com.ag04smarts.sha.models.patient.Patient;
import lombok.Data;

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
    private Set<Symptom> symptoms;

}
