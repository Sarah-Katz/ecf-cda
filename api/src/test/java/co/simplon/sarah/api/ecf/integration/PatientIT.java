package co.simplon.sarah.api.ecf.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import co.simplon.sarah.api.ecf.business.dto.PatientDto;
import co.simplon.sarah.api.ecf.business.service.patient.IPatientService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-tests.properties")
class PatientIT {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private IPatientService patientService;

    @BeforeEach
    void setUp() {
        PatientDto patient = new PatientDto();
        patient.setFirstName("John");
        patient.setLastName("Doe");
        patient.setSocialSecurityNumber("124356786785465");
        patient.setBirthdate(new Date());
        patient.setCreatedAt(new Date());
        patient.setModifiedAt(new Date());

        PatientDto patient2 = new PatientDto();
        patient2.setFirstName("Jane");
        patient2.setLastName("Smith");
        patient2.setSocialSecurityNumber("265487987674532");
        patient2.setBirthdate(new Date());
        patient2.setCreatedAt(new Date());
        patient2.setModifiedAt(new Date());

        patientService.savePatient(patient);
        patientService.savePatient(patient2);
    }

    @AfterEach
    void tearDown() {
        List<PatientDto> patients = patientService.getAllPatients();
        for (PatientDto patient : patients) {
            patientService.deletePatient(patient.getIdPatient());
        }
    }

    private String getUrl(final String uri) {
        return "http://localhost:" + port + uri;
    }

    @Test
    void createPatient() {
        PatientDto patientDto = new PatientDto();
        patientDto.setFirstName("John");
        patientDto.setLastName("Smith");
        patientDto.setSocialSecurityNumber("123456789876876");
        patientDto.setBirthdate(new Date());
        patientDto.setCreatedAt(new Date());
        patientDto.setModifiedAt(new Date());

        ResponseEntity<String> res = this.restTemplate.postForEntity(getUrl("/patients"), patientDto, String.class);

        assertEquals(HttpStatus.OK, res.getStatusCode());
    }

    @Test
    void getAllPatients() throws Exception {
        ResponseEntity<?> res = this.restTemplate.getForEntity(getUrl("/patients"), List.class);
        assertEquals(HttpStatus.OK, res.getStatusCode());
    }
}
