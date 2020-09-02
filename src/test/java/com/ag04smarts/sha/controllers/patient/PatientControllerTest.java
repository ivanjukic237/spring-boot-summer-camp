package com.ag04smarts.sha.controllers.patient;

import com.ag04smarts.sha.services.EmailService;
import com.ag04smarts.sha.services.patient.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PatientControllerTest {

    @Mock
    PatientService patientService;

    EmailService emailService;
    PatientController patientController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        patientController = new PatientController(patientService, emailService);
    }

    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(patientController).build();
        mockMvc.perform(get("/api/patient"))
                .andExpect(status().isOk());
    }
}
