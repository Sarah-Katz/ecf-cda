package co.simplon.sarah.api.ecf.unit.presentation.controller.room;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.sarah.api.ecf.business.dto.RoomDto;
import co.simplon.sarah.api.ecf.business.service.room.IRoomService;
import co.simplon.sarah.api.ecf.presentation.controller.room.GetRoomByPatientController;

@ExtendWith(MockitoExtension.class)
class GetRoomByPatientControllerTest {
    @InjectMocks
    private GetRoomByPatientController getRoomByPatientController;
    @Mock
    private IRoomService roomService;

    @Test
    void getRoomByPatient() {
        when(roomService.getRoomByPatient(anyInt())).thenReturn(new RoomDto());
        getRoomByPatientController.getRoomByPatient(1);
        verify(roomService, times(1)).getRoomByPatient(anyInt());
    }
}
