package co.simplon.sarah.api.ecf.presentation.controller.patient;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.sarah.api.ecf.business.service.patient.IPatientService;

@ExtendWith(MockitoExtension.class)
class DeletePatientControllerTest {
    @InjectMocks
    private DeletePatientController deletePatientController;

    @Mock
    private IPatientService patientService;

    @Test
    void deletePatient() {
        doNothing().when(patientService).deletePatient(anyInt());
        deletePatientController.deletePatientById(anyInt());
        verify(patientService, times(1)).deletePatient(anyInt());
    }
}
