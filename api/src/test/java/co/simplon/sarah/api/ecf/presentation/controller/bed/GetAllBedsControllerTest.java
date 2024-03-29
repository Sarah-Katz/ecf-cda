package co.simplon.sarah.api.ecf.presentation.controller.bed;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.sarah.api.ecf.business.dto.BedDto;
import co.simplon.sarah.api.ecf.business.service.bed.IBedService;

@ExtendWith(MockitoExtension.class)
class GetAllBedsControllerTest {
    @InjectMocks
    private GetAllBedsController getAllBedsController;
    @Mock
    private IBedService bedService;

    @Test
    void getAllBeds() {
        when(bedService.getAllBeds()).thenReturn(List.of(new BedDto()));
        getAllBedsController.getAllBeds();
        verify(bedService, times(1)).getAllBeds();
    }
}
