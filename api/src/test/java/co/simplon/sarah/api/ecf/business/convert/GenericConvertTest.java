package co.simplon.sarah.api.ecf.business.convert;

import org.junit.jupiter.api.Test;

import co.simplon.sarah.api.ecf.business.dto.PatientDto;
import co.simplon.sarah.api.ecf.persistance.entity.Patient;

class GenericConvertTest {
    final GenericConvert genericConvert = GenericConvert.getInstance();

    @Test
    void testGenericConvert() {
        Patient patient = new Patient();
        patient.setIdPatient(1);
        patient.setFirstname("John");
        PatientDto dto = genericConvert.toDto(patient, PatientDto.class);
        assert dto != null;
        assert dto instanceof PatientDto;
        assert dto.getIdPatient() == 1;
        assert dto.getFirstName().equals("John");
    }
}
