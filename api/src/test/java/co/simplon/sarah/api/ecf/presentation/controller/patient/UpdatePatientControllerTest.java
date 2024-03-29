package co.simplon.sarah.api.ecf.presentation.controller.patient;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.sarah.api.ecf.business.dto.PatientDto;
import co.simplon.sarah.api.ecf.business.service.patient.IPatientService;

@ExtendWith(MockitoExtension.class)
class UpdatePatientControllerTest {
    @InjectMocks
    private UpdatePatientController updatePatientController;

    @Mock
    private IPatientService patientService;

    @Test
    void updatePatient() {
        doNothing().when(patientService).savePatient(any(PatientDto.class));
        updatePatientController.updatePatient(new PatientDto());
        verify(patientService, times(1)).savePatient(any(PatientDto.class));
    }
}
