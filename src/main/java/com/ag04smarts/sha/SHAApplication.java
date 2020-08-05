package com.ag04smarts.sha;

import com.ag04smarts.sha.config.Therapies;
import com.ag04smarts.sha.models.patient.Patient;
import com.ag04smarts.sha.repositories.PatientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;

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

        PatientRepository patientRepository = (PatientRepository) context.getBean("patientRepository");

        System.out.println("Number of patients in repository: " + patientRepository.count());
        for (Patient patient : patientRepository.findAll()) {
            System.out.println(patient);
        }
    }
}
