package co.simplon.sarah.api.ecf.unit.presentation.controller.room;

import static org.mockito.ArgumentMatchers.anyInt;
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
import co.simplon.sarah.api.ecf.business.service.room.IRoomService;
import co.simplon.sarah.api.ecf.presentation.controller.room.GetAvailableBedsController;

@ExtendWith(MockitoExtension.class)
class GetAvailableBedsControllerTest {
    @InjectMocks
    private GetAvailableBedsController getAvailableBedsController;

    @Mock
    private IRoomService roomService;

    @Test
    void getAvailableBeds() {
        when(roomService.getAvailableBeds(anyInt())).thenReturn(List.of(new BedDto()));
        getAvailableBedsController.getAvailableBeds(1);
        verify(roomService, times(1)).getAvailableBeds(anyInt());
    }
}
