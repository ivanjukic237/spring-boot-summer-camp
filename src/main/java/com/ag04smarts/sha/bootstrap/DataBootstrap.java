package com.ag04smarts.sha.bootstrap;

import com.ag04smarts.sha.models.doctor.Doctor;
import com.ag04smarts.sha.models.doctor.DoctorExpertise;
import com.ag04smarts.sha.models.patient.Gender;
import com.ag04smarts.sha.models.patient.Patient;
import com.ag04smarts.sha.models.patient.PatientTreatmentHistory;
import com.ag04smarts.sha.models.patient.Status;
import com.ag04smarts.sha.models.patient.medicalRecord.PatientMedicalRecord;
import com.ag04smarts.sha.models.patient.medicalRecord.Symptom;
import com.ag04smarts.sha.repositories.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DataBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientMedicalRecordRepository patientMedicalRecordRepository;
    private final PatientRepository patientRepository;
    private final PatientTreatmentHistoryRepository patientTreatmentHistoryRepository;
    private final SymptomRepository symptomRepository;

    public DataBootstrap(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository,
                         PatientMedicalRecordRepository patientMedicalRecordRepository,
                         PatientRepository patientRepository,
                         PatientTreatmentHistoryRepository patientTreatmentHistoryRepository,
                         SymptomRepository symptomRepository) {

        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientMedicalRecordRepository = patientMedicalRecordRepository;
        this.patientRepository = patientRepository;
        this.patientTreatmentHistoryRepository = patientTreatmentHistoryRepository;
        this.symptomRepository = symptomRepository;

    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Symptom symptom1 = new Symptom("coughing");
        Symptom symptom2 = new Symptom("fever");
        Symptom symptom3 = new Symptom("high blood pressure");
        Symptom symptom4 = new Symptom("sore throat");
        Symptom symptom5 = new Symptom("headache");

        Set<Symptom> symptoms = Stream.of(symptom1, symptom2, symptom3, symptom4, symptom5).collect(Collectors.toSet());

        Doctor doctor1 = new Doctor("Doktor", "Doktorić", DoctorExpertise.GENERAL_DOCTOR);

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

        PatientTreatmentHistory patientTreatmentHistory1 = new PatientTreatmentHistory(
                patient1, doctor1,
                "Patient should be given medication before being admitted.",
                Status.ENLISTED, Status.UNDER_DIAGNOSIS);

        PatientTreatmentHistory patientTreatmentHistory2 = new PatientTreatmentHistory(
                patient2, doctor1,
                "Patient is diagnosed",
                Status.UNDER_DIAGNOSIS, Status.DIAGNOSED);

        PatientTreatmentHistory patientTreatmentHistory2_2 = new PatientTreatmentHistory(
                patient2, doctor1,
                "Patient is under diagnosis.",
                Status.ENLISTED, Status.UNDER_DIAGNOSIS);


        //set doctor2 treatment history
        Set<PatientTreatmentHistory> doctor1PatientTreatmentHistorySet = new HashSet<>();
        doctor1PatientTreatmentHistorySet.add(patientTreatmentHistory1);
        doctor1PatientTreatmentHistorySet.add(patientTreatmentHistory2);
        doctor1PatientTreatmentHistorySet.add(patientTreatmentHistory2_2);

        doctor1.setPatientTreatmentHistories(doctor1PatientTreatmentHistorySet);

        //set patient1 treatment history
        Set<PatientTreatmentHistory> patient1TreatmentHistorySet = new HashSet<>();
        patient1TreatmentHistorySet.add(patientTreatmentHistory1);

        patient1.setPatientTreatmentHistories(patient1TreatmentHistorySet);

        //set patient2 treatment history
        Set<PatientTreatmentHistory> patient2TreatmentHistorySet = new HashSet<>();
        patient2TreatmentHistorySet.add(patientTreatmentHistory2);
        patient2TreatmentHistorySet.add(patientTreatmentHistory2_2);

        patient2.setPatientTreatmentHistories(patient2TreatmentHistorySet);

        //patient 1 medical record
        PatientMedicalRecord patient1MedicalRecord = new PatientMedicalRecord(patient1, "Covid-19", "Lupocet");
        Set<Symptom> patient1Symptoms = new HashSet<>();
        patient1Symptoms.add(symptom1);
        patient1Symptoms.add(symptom3);
        patient1Symptoms.add(symptom4);
        patient1MedicalRecord.setSymptoms(patient1Symptoms);

        patient1.setPatientMedicalRecord(patient1MedicalRecord);

        //patient 2 medical record
        PatientMedicalRecord patient2MedicalRecord = new PatientMedicalRecord(patient2, "Flu", "Something");
        Set<Symptom> patient2Symptoms = new HashSet<>();
        patient2Symptoms.add(symptom1);
        patient2Symptoms.add(symptom2);
        patient2Symptoms.add(symptom5);
        patient2MedicalRecord.setSymptoms(patient2Symptoms);

        patient2.setPatientMedicalRecord(patient2MedicalRecord);

        //patient 3 medical record
        PatientMedicalRecord patient3MedicalRecord = new PatientMedicalRecord(patient3, "Disease", "Treatment");
        Set<Symptom> patient3Symptoms = new HashSet<>();
        patient3Symptoms.add(symptom3);
        patient3Symptoms.add(symptom4);
        patient3Symptoms.add(symptom5);
        patient3MedicalRecord.setSymptoms(patient3Symptoms);

        patient3.setPatientMedicalRecord(patient3MedicalRecord);

        doctorRepository.save(doctor1);

        patientMedicalRecordRepository.save(patient1MedicalRecord);
        patientMedicalRecordRepository.save(patient2MedicalRecord);
        patientMedicalRecordRepository.save(patient3MedicalRecord);

        patientTreatmentHistoryRepository.save(patientTreatmentHistory1);
        patientTreatmentHistoryRepository.save(patientTreatmentHistory2);
        patientTreatmentHistoryRepository.save(patientTreatmentHistory2_2);

        patientRepository.save(patient1);
        patientRepository.save(patient2);
        patientRepository.save(patient3);

        symptomRepository.saveAll(symptoms);


    }
}
