package co.simplon.sarah.api.ecf.unit.presentation.controller.room;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.sarah.api.ecf.business.dto.BedDto;
import co.simplon.sarah.api.ecf.business.dto.RoomDto;
import co.simplon.sarah.api.ecf.business.service.room.IRoomService;
import co.simplon.sarah.api.ecf.presentation.controller.room.AddBedController;

@ExtendWith(MockitoExtension.class)
class AddBedControllerTest {
    @InjectMocks
    private AddBedController addBedController;
    @Mock
    private IRoomService roomService;

    @Test
    void addBed() {
        doNothing().when(roomService).addBed(any(RoomDto.class), any(BedDto.class));
        addBedController.addBed(new RoomDto(), new BedDto());
        verify(roomService, times(1)).addBed(any(RoomDto.class), any(BedDto.class));
    }
}
