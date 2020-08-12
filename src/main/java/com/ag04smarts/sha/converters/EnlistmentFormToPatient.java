package com.ag04smarts.sha.converters;

import com.ag04smarts.sha.commands.EnlistmentForm;
import com.ag04smarts.sha.models.patient.Patient;
import com.sun.istack.Nullable;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class EnlistmentFormToPatient implements Converter<EnlistmentForm, Patient> {

    @Override
    @Nullable
    @Synchronized
    public Patient convert(EnlistmentForm enlistmentForm) {
        if (enlistmentForm == null) {
            return null;
        }

       /* Date date1 = null;

        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(enlistmentForm.getEnlistmentDate());
        } catch (ParseException exception) {
            exception.printStackTrace();
        }*/

        final Patient patient = new Patient(
                enlistmentForm.getFirstName(), enlistmentForm.getLastName(), enlistmentForm.getEmail(),
                enlistmentForm.getAge(), enlistmentForm.getPhoneNumber(), enlistmentForm.getGender(),
                enlistmentForm.getEnlistmentDate(), enlistmentForm.getStatus()
        );

        return patient;
    }
}
