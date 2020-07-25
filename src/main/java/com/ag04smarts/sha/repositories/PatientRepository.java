package com.ag04smarts.sha.repositories;

import com.ag04smarts.sha.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface of a patient repository where the domain type of the repository is
 * a Patient entity.
 *
 * @Author Ivan Jukić
 */

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
