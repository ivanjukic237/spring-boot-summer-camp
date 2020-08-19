package com.ag04smarts.sha.commands;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class AppointmentForm {

    @ApiModelProperty(value = "ID of the patient.", required = true)
    private Long patientId;

    @ApiModelProperty(value = "ID of the doctor.", required = true)
    private Long doctorId;

    @ApiModelProperty(value = "Date of the appointment", required = true)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date appointmentDate;

}
