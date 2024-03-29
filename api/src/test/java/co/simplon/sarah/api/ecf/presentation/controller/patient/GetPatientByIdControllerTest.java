package co.simplon.sarah.api.ecf.presentation.controller.patient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.sarah.api.ecf.business.dto.PatientDto;
import co.simplon.sarah.api.ecf.business.service.patient.IPatientService;

@ExtendWith(MockitoExtension.class)
class GetPatientByIdControllerTest {
    @InjectMocks
    private GetPatientByIdController getPatientByIdController;

    @Mock
    private IPatientService patientService;

    @Test
    void getPatientById() {
        when(patientService.getPatientById(anyInt())).thenReturn(new PatientDto());
        PatientDto patient = getPatientByIdController.getPatientById(anyInt());
        verify(patientService, times(1)).getPatientById(anyInt());
        assertEquals(PatientDto.class, patient.getClass());
    }
}
