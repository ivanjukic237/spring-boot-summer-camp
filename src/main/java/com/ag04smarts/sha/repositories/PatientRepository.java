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

    @Query("select p from Patient p where p.age > 21 and p.enlistmentDate > '2020-1-1'")
    Collection<Patient> findAllByGivenAgeDate();

    @Query(value = "select distinct patient.id,first_name,last_name,age,email,enlistment_date,gender,phone_number,status,image,patient.patient_medical_record_id" +
            " from PATIENT inner join PATIENT_MEDICAL_RECORD_SYMPTOM " +
            "on PATIENT_MEDICAL_RECORD_SYMPTOM.PATIENT_MEDICAL_RECORD_ID = PATIENT.PATIENT_MEDICAL_RECORD_ID" +
            " join SYMPTOM on PATIENT_MEDICAL_RECORD_SYMPTOM.SYMPTOM_ID = SYMPTOM.ID" +
            " where DESCRIPTION = 'coughing' or DESCRIPTION = 'fever'", nativeQuery = true)
    Collection<Patient> getBySymptom();

}
