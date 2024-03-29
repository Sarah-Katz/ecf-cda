package co.simplon.sarah.api.ecf.presentation.controller.room;

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

import co.simplon.sarah.api.ecf.business.dto.RoomDto;
import co.simplon.sarah.api.ecf.business.service.room.IRoomService;

@ExtendWith(MockitoExtension.class)
class GetRoomsByServiceControllerTest {
    @InjectMocks
    private GetRoomsByServiceController getRoomsByServiceController;
    @Mock
    private IRoomService roomService;

    @Test
    void getRoomsByService() {
        when(roomService.getRoomsByService(anyInt())).thenReturn(List.of(new RoomDto()));
        getRoomsByServiceController.getRoomsByService(1);
        verify(roomService, times(1)).getRoomsByService(anyInt());
    }
}
