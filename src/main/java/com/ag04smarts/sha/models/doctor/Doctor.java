package com.ag04smarts.sha.models.doctor;

import com.ag04smarts.sha.models.appointment.Appointment;
import com.ag04smarts.sha.models.patient.PatientTreatmentHistory;
import lombok.Data;

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
    private DoctorExpertise doctorExpertise;

    @OneToMany
    private Set<PatientTreatmentHistory> patientTreatmentHistories;

    @OneToMany
    private Set<Appointment> appointments;

}
