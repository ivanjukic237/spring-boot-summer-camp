package com.ag04smarts.sha.Services;

import com.ag04smarts.sha.models.Patient;
import com.ag04smarts.sha.models.SexOptions;
import com.ag04smarts.sha.repositories.PatientRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Service that counts the number of male patients in the patient repository.
 * Profile name is "male".
 *
 * @Author Ivan Jukić
 */

@Service
@Profile("numberOf_male")
public class NumberOfMalePatients implements NumberOfPatientsService {

    private final PatientRepository patientRepository;

    /**
     * Constructor for the class.
     *
     * @param patientRepository patient repository
     */

    public NumberOfMalePatients(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    /**
     * Finds and returns the number of male patients.
     *
     * @return number of male patients
     */

    @Override
    public long getNumberOfPatients() {
        long counter = 0;
        for (Patient patient : patientRepository.findAll()) {
            if (patient.getSex() == SexOptions.MALE) {
                counter++;
            }
        }
        return counter;

    }
}
