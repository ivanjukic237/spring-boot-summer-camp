package com.ag04smarts.sha.repositories;

import com.ag04smarts.sha.models.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface of a patient repository where the domain type of the repository is
 * a Patient entity.
 *
 * @author Ivan Jukić
 */

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
