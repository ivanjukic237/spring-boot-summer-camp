package com.ag04smarts.sha.repositories;

import com.ag04smarts.sha.models.patient.medicalRecord.PatientMedicalRecord;
import com.ag04smarts.sha.models.patient.medicalRecord.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PatientMedicalRecordRepository extends JpaRepository<PatientMedicalRecord, Long> {

    @Query(value = "select patient.id from PATIENT join PATIENT_MEDICAL_RECORD_SYMPTOM on PATIENT_MEDICAL_RECORD_SYMPTOM.PATIENT_MEDICAL_RECORD_ID = PATIENT.PATIENT_MEDICAL_RECORD_ID where PATIENT_MEDICAL_RECORD_SYMPTOM.SYMPTOM_ID = 1 or PATIENT_MEDICAL_RECORD_SYMPTOM.SYMPTOM_ID = 5", nativeQuery = true)
    public Collection<Long> getBySymptom();
    
}
