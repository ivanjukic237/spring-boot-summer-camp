package com.ag04smarts.sha.converters;

import com.ag04smarts.sha.commands.EnlistmentForm;
import com.ag04smarts.sha.models.patient.Patient;
import com.ag04smarts.sha.models.patient.Status;
import com.sun.istack.Nullable;
import lombok.Synchronized;
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

        Date enlistmentDate = null;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String enlistmentDateString = sdf.format(new Date());
        try {
            enlistmentDate = sdf.parse(enlistmentDateString);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        final Patient patient = new Patient(
                enlistmentForm.getFirstName(), enlistmentForm.getLastName(), enlistmentForm.getEmail(),
                enlistmentForm.getAge(), enlistmentForm.getPhoneNumber(), enlistmentForm.getGender(),
                enlistmentDate, Status.ENLISTED
        );

        return patient;
    }
}
