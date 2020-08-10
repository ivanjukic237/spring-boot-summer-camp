package com.ag04smarts.sha.repositories;

import com.ag04smarts.sha.models.patient.medicalRecord.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymptomRepository extends JpaRepository<Symptom, Long> {
}
