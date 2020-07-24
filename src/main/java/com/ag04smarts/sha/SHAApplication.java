package com.ag04smarts.sha;

import com.ag04smarts.sha.controllers.PatientNumberController;
import com.ag04smarts.sha.info.PropertyInformation;
import com.ag04smarts.sha.models.Patient;
import com.ag04smarts.sha.models.SexOptions;
import com.ag04smarts.sha.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

/**
 * Runner for the Spring Boot Application. This class initializes in @PostConstruct default patients to
 * be saved in the patient repository.
 *
 * @Author Ivan Jukić
 */

@SpringBootApplication
public class SHAApplication {

    private final PatientRepository patientRepository;

    public SHAApplication(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @PostConstruct
    public void addDefaultPatients() {
        Patient firstPatient = new Patient(
                "Marko", "Markić", "Antibody therapy",
                LocalDate.of(1992, 7, 23), SexOptions.MALE, 123L
        );

        Patient secondPatient = new Patient(
                "Ivan", "Ivić", "Cell therapy",
                LocalDate.of(1939, 1, 1), SexOptions.MALE, 313L
        );

        Patient thirdPatient = new Patient(
                "Maja", "Majić", "Therapy",
                LocalDate.of(2000, 8, 24), SexOptions.FEMALE, 111111L
        );

        patientRepository.save(firstPatient);
        patientRepository.save(secondPatient);
        patientRepository.save(thirdPatient);
    }

    /**
     * Runs the Spring application, initializes the context and writes to console the information about
     * the number and the list of default  patients in the repository. Also, writes to console the number of male/female
     * patients in the repository depending on the set profile (numberOf_female/numberOf_male).
     *
     * @param args command line arguments
     */

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SHAApplication.class, args);

        PatientRepository patientRepository = (PatientRepository)context.getBean("patientRepository");

        System.out.println("Number of patients in repository: " + patientRepository.count());

        for(Patient patient : patientRepository.findAll()) {
            System.out.println(patient);
        }

        PatientNumberController patientNumberController = context.getBean("patientNumberController", PatientNumberController.class);
        PropertyInformation propertyInformation = context.getBean("propertyInformation", PropertyInformation.class);

        System.out.println("Number of " + propertyInformation.getNumberOfPatientsProperty() + " patients: " + patientNumberController.numberOfPatients());
    }
}
