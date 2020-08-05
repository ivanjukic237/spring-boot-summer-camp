package com.ag04smarts.sha.models.patient;

import com.ag04smarts.sha.models.appointment.Appointment;
import com.ag04smarts.sha.models.patient.medicalRecord.PatientMedicalRecord;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author Ivan Jukić
 */

@Data
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Date enlistmentDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PatientMedicalRecord patientMedicalRecord;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PatientTreatmentHistory> patientTreatmentHistories;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Appointment> appointments;

}


