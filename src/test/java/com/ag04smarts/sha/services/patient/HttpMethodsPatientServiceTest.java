package com.ag04smarts.sha.services.patient;

import com.ag04smarts.sha.controllers.patient.PatientModelAssembler;
import com.ag04smarts.sha.repositories.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class HttpMethodsPatientServiceTest {

    PatientService patientService;

    PatientModelAssembler patientModelAssembler = new PatientModelAssembler();

    @Mock
    PatientRepository patientRepository;

    @BeforeEach
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);

        patientService = new HttpMethodsPatientService(patientRepository, patientModelAssembler);
    }

    @Test
    public void findAllPatients() {
        patientService.mapEveryPatient();
        verify(patientRepository, times(1)).findAll();
    }
}