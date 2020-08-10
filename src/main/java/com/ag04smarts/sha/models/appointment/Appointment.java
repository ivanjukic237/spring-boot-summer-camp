package com.ag04smarts.sha.models.appointment;

import com.ag04smarts.sha.models.doctor.Doctor;
import com.ag04smarts.sha.models.patient.Patient;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;

    private Date appointmentDate;

}
