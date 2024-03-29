package co.simplon.sarah.api.ecf.presentation.controller.patient;

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
class AssignServiceControllerTest {
    @InjectMocks
    private AssignServiceController assignServiceController;

    @Mock
    private IPatientService iPatientService;

    @Test
    void testAssignService() {
        PatientDto patientDto = new PatientDto();
        when(iPatientService.assignService(patientDto, 1)).thenReturn(true);
        assignServiceController.assignService(patientDto, 1);
        verify(iPatientService, times(1)).assignService(patientDto, 1);
    }
}
