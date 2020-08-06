package com.ag04smarts.sha.models.patient;

import com.ag04smarts.sha.models.doctor.Doctor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
public class PatientTreatmentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Patient patient;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Doctor doctor;

    @Lob
    private String treatmentRemark;

    @Enumerated(EnumType.STRING)
    private Status oldStatus;

    @Enumerated(EnumType.STRING)
    private Status newStatus;

    public PatientTreatmentHistory(Patient patient, Doctor doctor, String treatmentRemark, Status oldStatus, Status newStatus) {
        this.patient = patient;
        this.doctor = doctor;
        this.treatmentRemark = treatmentRemark;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
    }

    public PatientTreatmentHistory() {
    }
}
