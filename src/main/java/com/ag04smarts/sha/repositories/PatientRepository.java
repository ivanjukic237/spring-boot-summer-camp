package com.ag04smarts.sha.repositories;

import com.ag04smarts.sha.models.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;

/**
 * Interface of a patient repository where the domain type of the repository is
 * a Patient entity.
 *
 * @author Ivan Jukić
 */

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Collection<Patient> findAllByAgeGreaterThanAndEnlistmentDateAfter(Integer age, Date date);

}
