package co.simplon.sarah.api.ecf.unit.business.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.sarah.api.ecf.business.dto.BedDto;
import co.simplon.sarah.api.ecf.business.dto.PatientDto;
import co.simplon.sarah.api.ecf.business.service.bed.IBedService;
import co.simplon.sarah.api.ecf.business.service.patient.PatientServiceImpl;
import co.simplon.sarah.api.ecf.business.service.room.IRoomService;
import co.simplon.sarah.api.ecf.persistance.entity.Patient;
import co.simplon.sarah.api.ecf.persistance.repository.patient.IPatientRepository;

@ExtendWith(MockitoExtension.class)
class PatientServiceTest {
    @InjectMocks
    private PatientServiceImpl patientService;
    @Mock
    private IPatientRepository iPatientRepository;
    @Mock
    private IRoomService iRoomService;
    @Mock
    private IBedService iBedService;

    @Test
    void testSavePatient() {
        when(iPatientRepository.save(any(Patient.class))).thenReturn(new Patient());
        patientService.savePatient(new PatientDto());
        verify(iPatientRepository, times(1)).save(any(Patient.class));
    }

    @Test
    void testUpdatePatient() {
        when(iPatientRepository.save(any(Patient.class))).thenReturn(new Patient());
        patientService.updatePatient(new PatientDto());
        verify(iPatientRepository, times(1)).save(any(Patient.class));
    }

    @Test
    void testGetAllPatients() {
        when(iPatientRepository.findAll()).thenReturn(List.of(new Patient()));
        patientService.getAllPatients();
        verify(iPatientRepository, times(1)).findAll();
    }

    @Test
    void testGetPatientById() {
        Optional<Patient> optionalPatient = Optional.of(new Patient());
        when(iPatientRepository.findById(any(Integer.class))).thenReturn(optionalPatient);
        patientService.getPatientById(1);
        verify(iPatientRepository, times(1)).findById(any(Integer.class));
    }

    @Test
    void testGetPatientByIdIsNull() {
        Optional<Patient> optionalPatient = Optional.ofNullable((Patient) null);
        when(iPatientRepository.findById(any(Integer.class))).thenReturn(optionalPatient);
        patientService.getPatientById(1);
        verify(iPatientRepository, times(1)).findById(any(Integer.class));
    }

    @Test
    void testGetPatientsByService() {
        when(iPatientRepository.findByService(any(String.class))).thenReturn(List.of(new Patient()));
        patientService.getPatientsByService("name");
        verify(iPatientRepository, times(1)).findByService(any(String.class));
    }

    @Test
    void testGetPatientsByServiceIsEmpty() {
        when(iPatientRepository.findByService(any(String.class))).thenReturn(new ArrayList<>());
        patientService.getPatientsByService("name");
        verify(iPatientRepository, times(1)).findByService(any(String.class));
    }

    @Test
    void testDeletePatient() {
        doNothing().when(iPatientRepository).deleteById(any(Integer.class));
        patientService.deletePatient(1);
        verify(iPatientRepository, times(1)).deleteById(any(Integer.class));
    }

    @Test
    void assignService() {
        when(iRoomService.getAvailableBeds(any(Integer.class))).thenReturn(List.of(new BedDto()));
        doNothing().when(iBedService).saveBed(any(BedDto.class));
        PatientDto patientDto = new PatientDto();
        boolean success = patientService.assignService(patientDto, 1);
        verify(iRoomService, times(1)).getAvailableBeds(any(Integer.class));
        verify(iBedService, times(1)).saveBed(any(BedDto.class));
        assertTrue(success);
    }

    @Test
    void assignServiceFail() {
        when(iRoomService.getAvailableBeds(any(Integer.class))).thenReturn(new ArrayList<>());
        PatientDto patientDto = new PatientDto();
        boolean success = patientService.assignService(patientDto, 1);
        verify(iRoomService, times(1)).getAvailableBeds(any(Integer.class));
        assertFalse(success);
    }

    @Test
    void removeFromService() {
        when(iBedService.getBedByPatient(any(Integer.class))).thenReturn(new BedDto());
        doNothing().when(iBedService).saveBed(any(BedDto.class));
        patientService.removeFromService(new PatientDto());
        verify(iBedService, times(1)).getBedByPatient(any(Integer.class));
        verify(iBedService, times(1)).saveBed(any(BedDto.class));
    }
}
