package co.simplon.sarah.api.ecf.unit.presentation.controller.patient;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.sarah.api.ecf.business.dto.PatientDto;
import co.simplon.sarah.api.ecf.business.service.patient.IPatientService;
import co.simplon.sarah.api.ecf.presentation.controller.patient.GetAllPatientsController;

@ExtendWith(MockitoExtension.class)
class GetAllPatientsControllerTest {
    @InjectMocks
    private GetAllPatientsController getAllPatientsController;
    @Mock
    private IPatientService patientService;

    @Test
    void getAllPatients() {
        when(patientService.getAllPatients()).thenReturn(List.of(new PatientDto()));
        getAllPatientsController.getAllPatients();
        verify(patientService, times(1)).getAllPatients();
    }
}
