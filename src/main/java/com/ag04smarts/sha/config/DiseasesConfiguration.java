package com.ag04smarts.sha.config;

import com.ag04smarts.sha.models.Patient;
import com.ag04smarts.sha.models.SexOptions;
import com.ag04smarts.sha.repositories.PatientRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.*;

/**
 * Configuration class that makes the map where the key is a disease in the
 * repository and the key is the number of patients that have that disease.
 * Also, this class has Beans that return the same map but only for male/female
 * patients.
 *
 * @author Ivan Jukić
 */

@Configuration
public class DiseasesConfiguration {

    private final PatientRepository patientRepository;

    /**
     * Constructor for the class. Initializes the patient repository.
     *
     * @param patientRepository repository of patients
     */

    public DiseasesConfiguration(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    /**
     * Bean with name "diseases" that returns the map where the keys are all
     * unique diseases of patients and the value is the number of patients that
     * have that disease.
     *
     * @return map of diseases
     */

    @Bean("diseases")
    @Primary
    Map<String, Long> getMapOfAllDiseases() {
        return getMap(null);
    }

    /**
     * Bean that returns the map of diseases for all female patients.
     *
     * @return map of diseases for all female patients
     */

    @Bean("diseasesFemale")
    Map<String, Long> getMapOfAllDiseasesFemale() {
        return getMap(SexOptions.FEMALE);
    }

    /**
     * Bean that returns the map of diseases for all male patients.
     *
     * @return map of diseases for all male patients
     */

    @Bean("diseasesMale")
    Map<String, Long> getMapOfAllDiseasesMale() {
        return getMap(SexOptions.MALE);
    }

    /**
     * Helper method that creates a TreeMap of the diseases with a given
     * sexOption constraint. If the option is null, all patients are taken.
     * If the option is sexOption.MALE the map will be populated with only
     * male patients. If the option is sexOption.FEMALE the map will be
     * populated with only female options.
     *
     * @param sexOptionConstraint sexOption constraint
     * @return map of all patients with a given constraint
     */

    private Map<String, Long> getMap(SexOptions sexOptionConstraint) {
        TreeMap<String, Long> map = new TreeMap<>();

        for (Patient patient : patientRepository.findAll()) {
            if (sexOptionConstraint == null || patient.getSex() == sexOptionConstraint) {
                String disease = patient.getDisease();
                if (map.containsKey(disease)) {
                    map.put(disease, map.get(disease) + 1);
                } else {
                    map.put(disease, 1L);
                }
            }
        }
        return map;
    }

}
