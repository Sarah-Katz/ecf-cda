package co.simplon.sarah.api.ecf.business.convert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import co.simplon.sarah.api.ecf.business.dto.PatientDto;
import co.simplon.sarah.api.ecf.persistance.entity.Bed;
import co.simplon.sarah.api.ecf.persistance.entity.Patient;

class GenericConvertTest {
    final GenericConverter genericConvert = GenericConverter.getInstance();

    @Test
    void testGenericConvertEntityToDto() {
        Patient patient = new Patient();
        patient.setIdPatient(1);
        patient.setFirstName("John");
        PatientDto dto = null;
        try {
            dto = genericConvert.convert(patient, PatientDto.class);
        } catch (GenericConverterException e) {
            fail(e);
        }
        assertNotNull(dto);
        assertTrue(dto instanceof PatientDto);
        assertEquals(1, dto.getIdPatient());
        assertEquals("John", dto.getFirstName());
    }

    @Test
    void testGenericConvertDtoToEntity() {
        PatientDto dto = new PatientDto();
        dto.setIdPatient(1);
        dto.setFirstName("John");
        Patient patient = null;
        try {
            patient = genericConvert.convert(dto, Patient.class);
        } catch (GenericConverterException e) {
            fail(e);
        }
        assertNotNull(patient);
        assertTrue(patient instanceof Patient);
        assertEquals(1, patient.getIdPatient());
        assertEquals("John", patient.getFirstName());
    }

    @Test
    void testGenericConvertList() {
        PatientDto dto = new PatientDto();
        dto.setIdPatient(1);
        dto.setFirstName("John");
        PatientDto dto2 = new PatientDto();
        dto2.setIdPatient(2);
        dto2.setFirstName("Jane");
        PatientDto dto3 = new PatientDto();
        dto3.setIdPatient(3);
        dto3.setFirstName("Peter");
        List<PatientDto> dtos = List.of(dto, dto2, dto3);
        List<Patient> patients = null;
        try {
            patients = (genericConvert.convertList(dtos, Patient.class));
        } catch (GenericConverterException e) {
            fail(e);
        }
        assertNotNull(patients);
        assertEquals(3, patients.size());
        assertEquals(1, patients.get(0).getIdPatient());
        assertEquals("John", patients.get(0).getFirstName());
        assertEquals(2, patients.get(1).getIdPatient());
    }

    @Test
    void testGenericConvertException() {
        PatientDto dto = new PatientDto();
        try {
            genericConvert.convert(dto, Bed.class);
        } catch (GenericConverterException e) {
            assertThrows(GenericConverterException.class, () -> genericConvert.convert(dto, Bed.class));
        }
    }
}
