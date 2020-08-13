package com.ag04smarts.sha.commands;

import com.ag04smarts.sha.models.appointment.Appointment;
import com.ag04smarts.sha.models.patient.Gender;
import com.ag04smarts.sha.models.patient.PatientTreatmentHistory;
import com.ag04smarts.sha.models.patient.Status;
import com.ag04smarts.sha.models.patient.medicalRecord.PatientMedicalRecord;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class EnlistmentForm {

    private Long id;

    @NotBlank
    @Size(min = 1, max = 255)
    private String firstName;

    @NotBlank
    @Size(min = 1, max = 255)
    private String lastName;

    @Email(message = "Email should be valid.")
    private String email;

    @Min(0)
    @Max(150)
    private Integer age;

    @Size(min = 1, max = 255)
    private String phoneNumber;
    private Gender gender;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date enlistmentDate;

    private Status status;
    private PatientMedicalRecord patientMedicalRecord;
    private Set<PatientTreatmentHistory> patientTreatmentHistories;
    private Set<Appointment> appointments;

}
