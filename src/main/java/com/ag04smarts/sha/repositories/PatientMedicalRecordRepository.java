package com.ag04smarts.sha.repositories;

import com.ag04smarts.sha.models.patient.medicalRecord.PatientMedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientMedicalRecordRepository extends JpaRepository<PatientMedicalRecord, Long> {
}
