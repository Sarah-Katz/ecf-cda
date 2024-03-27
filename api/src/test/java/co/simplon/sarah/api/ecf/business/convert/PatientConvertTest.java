package co.simplon.sarah.api.ecf.business.convert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.List;

import org.junit.jupiter.api.Test;

import co.simplon.sarah.api.ecf.business.dto.PatientDto;
import co.simplon.sarah.api.ecf.persistance.entity.Patient;

class PatientConvertTest {
    private PatientConvert convert = PatientConvert.getInstance();

    @Test
    void convertPatientDtoToPatient() {
        PatientDto patientDto = new PatientDto();
        patientDto.setIdPatient(1);
        patientDto.setFirstName("John");
        patientDto.setLastName("Doe");
        Patient patient = convert.toEntity(patientDto);
        assertEquals(1, patient.getIdPatient());
        assertEquals("John", patient.getFirstName());
        assertEquals("Doe", patient.getLastName());
        assertSame(Patient.class, patient.getClass());
    }

    @Test
    void convertPatientToPatientDto() {
        Patient patient = new Patient();
        patient.setIdPatient(1);
        patient.setFirstName("John");
        patient.setLastName("Doe");
        PatientDto patientDto = convert.toDto(patient);
        assertEquals(1, patientDto.getIdPatient());
        assertEquals("John", patientDto.getFirstName());
        assertEquals("Doe", patientDto.getLastName());
        assertSame(PatientDto.class, patientDto.getClass());
    }

    @Test
    void convertPatientDtoListToPatientList() {
        PatientDto patientDto = new PatientDto();
        patientDto.setIdPatient(1);
        patientDto.setFirstName("John");
        patientDto.setLastName("Doe");
        PatientDto patientDto2 = new PatientDto();
        patientDto2.setIdPatient(2);
        patientDto2.setFirstName("Jane");
        patientDto2.setLastName("Doe");
        List<PatientDto> dtoList = List.of(patientDto, patientDto2);
        List<Patient> patientList = convert.toEntityList(dtoList);
        assertEquals(2, patientList.size());
        assertEquals(1, patientList.get(0).getIdPatient());
        assertEquals("John", patientList.get(0).getFirstName());
        assertEquals("Doe", patientList.get(0).getLastName());
        assertEquals(2, patientList.get(1).getIdPatient());
        assertEquals("Jane", patientList.get(1).getFirstName());
        assertEquals("Doe", patientList.get(1).getLastName());
    }

    @Test
    void convertPatientListToPatientDtoList() {
        Patient patient = new Patient();
        patient.setIdPatient(1);
        patient.setFirstName("John");
        patient.setLastName("Doe");
        Patient patient2 = new Patient();
        patient2.setIdPatient(2);
        patient2.setFirstName("Jane");
        patient2.setLastName("Doe");
        List<Patient> patientList = List.of(patient, patient2);
        List<PatientDto> dtoList = convert.toDtoList(patientList);
        assertEquals(2, dtoList.size());
        assertEquals(1, dtoList.get(0).getIdPatient());
        assertEquals("John", dtoList.get(0).getFirstName());
        assertEquals("Doe", dtoList.get(0).getLastName());
        assertEquals(2, dtoList.get(1).getIdPatient());
        assertEquals("Jane", dtoList.get(1).getFirstName());
    }
}
