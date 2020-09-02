package com.ag04smarts.sha;

import com.ag04smarts.sha.models.patient.Patient;
import com.ag04smarts.sha.models.patient.medicalRecord.PatientMedicalRecord;
import com.ag04smarts.sha.models.patient.medicalRecord.Symptom;
import com.ag04smarts.sha.repositories.PatientMedicalRecordRepository;
import com.ag04smarts.sha.repositories.PatientRepository;
import com.ag04smarts.sha.services.EmailServiceImpl;
import com.ag04smarts.sha.sha9Test.Sha9Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * Runner for the Spring Boot Application. This class initializes in @PostConstruct default patients to
 * be saved in the patient repository.
 *
 * @Author Ivan Jukić
 */

@SpringBootApplication
public class SHAApplication {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
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

        System.out.println("Find by age and enlistment date: ");
        System.out.println(patientRepository.findAllByAgeGreaterThanAndEnlistmentDateAfter(21, new Date(2020 - 1900, 1, 1)));
        System.out.println();

        System.out.println("Given date and age: ");
        System.out.println(patientRepository.findAllByGivenAgeDate());

        System.out.println("BY SYMPTOMS: ");
        System.out.println(patientRepository.getBySymptom());

        System.out.println("Number of patients in repository: " + patientRepository.count());
        for (Patient patient : patientRepository.findAll()) {
            System.out.println(patient);
        }

        Sha9Test.test();
    }
}
