package com.ag04smarts.sha.models.doctor;

import com.ag04smarts.sha.models.appointment.Appointment;
import com.ag04smarts.sha.models.patient.PatientTreatmentHistory;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private DoctorExpertise doctorExpertise;

    @OneToMany
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<PatientTreatmentHistory> patientTreatmentHistories;

    @OneToMany
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Appointment> appointments;

    public Doctor(String firstName, String lastName, DoctorExpertise doctorExpertise) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.doctorExpertise = doctorExpertise;
    }

    public Doctor() {

    }
}
