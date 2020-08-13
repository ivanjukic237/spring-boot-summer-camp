package com.ag04smarts.sha.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class AppointmentForm {

    private Long patientId;
    private Long doctorId;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date appointmentDate;

}
