package com.ag04smarts.sha;

import com.ag04smarts.sha.models.Patient;
import com.ag04smarts.sha.repositories.PatientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

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
                LocalDate.of(1992, 7, 23), "male", 123L
        );

        Patient secondPatient = new Patient(
                "Ivan", "Ivić", "Cell therapy",
                LocalDate.of(1939, 1, 1), "male", 313L
        );
        patientRepository.save(firstPatient);
        patientRepository.save(secondPatient);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SHAApplication.class, args);
        PatientRepository patientRepository = (PatientRepository)context.getBean("patientRepository");
        System.out.println("Number of patients in repository: " + patientRepository.count());
        for(Patient patient : patientRepository.findAll()) {
            System.out.println(patient);
        }

    }
}
