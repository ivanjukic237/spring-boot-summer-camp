package com.ag04smarts.sha.models.doctor;

import com.ag04smarts.sha.models.Person;
import com.ag04smarts.sha.models.appointment.Appointment;
import com.ag04smarts.sha.models.patient.PatientTreatmentHistory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Doctor extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private DoctorExpertise doctorExpertise;

    @OneToMany
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<PatientTreatmentHistory> patientTreatmentHistories;

    @OneToMany
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<Appointment> appointments;

    public Doctor(String firstName, String lastName, DoctorExpertise doctorExpertise) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.doctorExpertise = doctorExpertise;
    }

    public Doctor() {

    }
}
