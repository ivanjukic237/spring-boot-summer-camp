package com.ag04smarts.sha.services.patient;

import com.ag04smarts.sha.models.Patient;
import com.ag04smarts.sha.models.SexOptions;
import com.ag04smarts.sha.repositories.PatientRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Service that counts the number of female patients in the patient repository.
 * Profile name is "female".
 *
 * @author Ivan Jukić
 */

@Service
@Profile("numberOf_female")
public class NumberOfFemalePatients implements NumberOfPatientsService {

    private final PatientRepository patientRepository;

    /**
     * Constructor for the class.
     *
     * @param patientRepository patient repository
     */

    public NumberOfFemalePatients(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    /**
     * Finds and returns the number of female patients.
     *
     * @return number of female patients
     */

    @Override
    public long getNumberOfPatients() {
        long counter = 0;
        for (Patient patient : patientRepository.findAll()) {
            if (patient.getSex() == SexOptions.FEMALE) {
                counter++;
            }
        }
        return counter;
    }
}
