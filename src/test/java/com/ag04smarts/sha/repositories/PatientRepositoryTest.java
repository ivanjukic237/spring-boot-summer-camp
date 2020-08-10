package com.ag04smarts.sha.repositories;

import com.ag04smarts.sha.models.patient.Gender;
import com.ag04smarts.sha.models.patient.Patient;
import com.ag04smarts.sha.models.patient.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class PatientRepositoryTest {

    @Autowired
    PatientRepository patientRepository;

    @BeforeEach
    public void init() throws Exception {
        Patient patient1 = new Patient(
                "Ivan", "Ivić", "ivic@net.hr",
                50, "091888888", Gender.MALE,
                new Date(2020 - 1900, 5, 6),
                Status.UNDER_DIAGNOSIS);

        Patient patient2 = new Patient(
                "Ivana", "Ivić", "ivicIvana@net.hr",
                48, "091777777", Gender.FEMALE,
                new Date(2020 - 1900, 5, 1),
                Status.DIAGNOSED);

        Patient patient3 = new Patient(
                "Marko", "Markić", "marko@marko.com",
                18, "0123132", Gender.MALE,
                new Date(2020 - 1900, 1, 4),
                Status.ENLISTED
        );
        patientRepository.save(patient1);
        patientRepository.save(patient2);
        patientRepository.save(patient3);

    }

    @Test
    public void findAllByAgeAndEnlistmentDate() {
        Collection<Patient> patients = patientRepository.findAllByGivenAgeDate();
        System.out.println(patientRepository.findAll());
        assertEquals(2, patients.size());
    }
}