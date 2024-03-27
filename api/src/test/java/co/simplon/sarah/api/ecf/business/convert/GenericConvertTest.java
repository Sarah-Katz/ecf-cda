// package co.simplon.sarah.api.ecf.business.convert;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import static org.junit.jupiter.api.Assertions.fail;

// import java.util.List;

// import org.junit.jupiter.api.Test;

// import co.simplon.sarah.api.ecf.business.dto.BedDto;
// import co.simplon.sarah.api.ecf.business.dto.PatientDto;
// import co.simplon.sarah.api.ecf.persistance.entity.Bed;
// import co.simplon.sarah.api.ecf.persistance.entity.Patient;

// class GenericConvertTest {
// final GenericConverter genericConvert = GenericConverter.getInstance();

// @Test
// void testGenericConvertEntityToDto() {
// Patient patient = new Patient();
// patient.setIdPatient(1);
// patient.setFirstName("John");
// PatientDto dto = null;
// try {
// dto = genericConvert.convert(patient, PatientDto.class);
// } catch (GenericConverterException e) {
// fail(e);
// }
// assertNotNull(dto);
// assertTrue(dto instanceof PatientDto);
// assertEquals(1, dto.getIdPatient());
// assertEquals("John", dto.getFirstName());
// }

// @Test
// void testGenericConvertDtoToEntity() {
// PatientDto patientDto = new PatientDto();
// patientDto.setIdPatient(1);
// patientDto.setFirstName("John");
// BedDto dto = new BedDto();
// dto.setIdBed(1);
// dto.setPatient(patientDto);
// Bed bed = null;
// try {
// bed = genericConvert.convert(dto, Bed.class);
// } catch (GenericConverterException e) {
// fail(e);
// }
// assertNotNull(bed);
// assertTrue(bed instanceof Bed);
// assertEquals(1, bed.getIdBed());
// assertEquals("John", bed.getPatient().getFirstName());
// }

// @Test
// void testGenericConvertList() {
// PatientDto dto = new PatientDto();
// dto.setIdPatient(1);
// dto.setFirstName("John");
// PatientDto dto2 = new PatientDto();
// dto2.setIdPatient(2);
// dto2.setFirstName("Jane");
// PatientDto dto3 = new PatientDto();
// dto3.setIdPatient(3);
// dto3.setFirstName("Peter");
// List<PatientDto> dtoList = List.of(dto, dto2, dto3);
// List<Patient> patients = null;
// try {
// patients = (genericConvert.convertList(dtoList, Patient.class));
// } catch (GenericConverterException e) {
// fail(e);
// }
// assertNotNull(patients);
// assertEquals(3, patients.size());
// assertEquals(1, patients.get(0).getIdPatient());
// assertEquals("John", patients.get(0).getFirstName());
// assertEquals(2, patients.get(1).getIdPatient());
// }

// @Test
// void testGenericConvertException() {
// PatientDto dto = new PatientDto();
// try {
// genericConvert.convert(dto, Bed.class);
// } catch (GenericConverterException e) {
// assertThrows(GenericConverterException.class, () ->
// genericConvert.convert(dto, Bed.class));
// }
// }
// }
