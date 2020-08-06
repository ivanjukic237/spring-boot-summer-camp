package com.ag04smarts.sha.models.patient;

import com.ag04smarts.sha.models.appointment.Appointment;
import com.ag04smarts.sha.models.patient.medicalRecord.PatientMedicalRecord;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private PatientMedicalRecord patientMedicalRecord;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<PatientTreatmentHistory> patientTreatmentHistories;

    @OneToMany(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<Appointment> appointments;

    public Patient(String firstName, String lastName, String email,
                   Integer age, String phoneNumber, Gender gender,
                   Date enlistmentDate, Status status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.enlistmentDate = enlistmentDate;
        this.status = status;
    }

    public Patient() {
    }
}


