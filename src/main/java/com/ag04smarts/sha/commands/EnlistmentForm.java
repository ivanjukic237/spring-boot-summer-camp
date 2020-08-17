package com.ag04smarts.sha.commands;

import com.ag04smarts.sha.models.patient.Gender;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;


@Getter
@Setter
@NoArgsConstructor
public class EnlistmentForm {

    private Long id;

    @NotBlank(message = "{NotBlank.enlistmentForm.firstName}")
    @Size(min = 1, max = 255)
    private String firstName;

    @NotBlank(message = "{NotBlank.enlistmentForm.lastName}")
    @Size(min = 1, max = 255)
    private String lastName;

    @Email(message = "{Email.enlistmentForm}")
    private String email;

    @Min(0)
    @Max(150)
    private Integer age;

    @Size(min = 1, max = 255)
    private String phoneNumber;

    private Gender gender;

}
