package com.ag04smarts.sha.models.patient;

import com.ag04smarts.sha.models.Person;
import com.ag04smarts.sha.models.appointment.Appointment;
import com.ag04smarts.sha.models.patient.medicalRecord.PatientMedicalRecord;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author Ivan Jukić
 */

@Data
@Entity
public class Patient extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;
    private Integer age;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date enlistmentDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Lob
    //It has to be a four letter String so it can be in Base64.
    @ApiModelProperty(example = "1234")
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private PatientMedicalRecord patientMedicalRecord;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "patient")
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
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.email = email;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.enlistmentDate = enlistmentDate;
        this.status = status;
    }

    public Patient() {
    }

    @PrePersist
    private void prePersistFunction() {
        System.out.println("Starting pre persist function.");
    }

    @PreUpdate
    private void preUpdateFunction() {
        System.out.println("Starting pre update function.");
    }

}


