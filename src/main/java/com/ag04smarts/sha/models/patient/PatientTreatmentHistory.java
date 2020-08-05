package com.ag04smarts.sha.models.patient;

import com.ag04smarts.sha.models.doctor.Doctor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class PatientTreatmentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;

    @Lob
    private String treatmentRemark;
    private Status oldStatus;
    private Status newStatus;

}
