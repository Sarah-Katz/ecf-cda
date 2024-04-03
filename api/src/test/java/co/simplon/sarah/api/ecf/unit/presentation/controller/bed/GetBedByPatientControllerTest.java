package co.simplon.sarah.api.ecf.unit.presentation.controller.bed;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.sarah.api.ecf.business.dto.BedDto;
import co.simplon.sarah.api.ecf.business.service.bed.IBedService;
import co.simplon.sarah.api.ecf.presentation.controller.bed.GetBedByPatientController;

@ExtendWith(MockitoExtension.class)
class GetBedByPatientControllerTest {
    @InjectMocks
    private GetBedByPatientController getBedByPatientController;
    @Mock
    private IBedService bedService;

    @Test
    void getBedByPatient() {
        when(bedService.getBedByPatient(anyInt())).thenReturn(new BedDto());
        getBedByPatientController.getBedByPatient(1);
        verify(bedService, times(1)).getBedByPatient(anyInt());
    }
}
