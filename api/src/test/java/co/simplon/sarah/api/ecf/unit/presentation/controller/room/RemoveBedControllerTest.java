package co.simplon.sarah.api.ecf.unit.presentation.controller.room;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.sarah.api.ecf.business.dto.BedDto;
import co.simplon.sarah.api.ecf.business.service.room.IRoomService;
import co.simplon.sarah.api.ecf.presentation.controller.room.RemoveBedController;

@ExtendWith(MockitoExtension.class)
class RemoveBedControllerTest {
    @InjectMocks
    private RemoveBedController removeBedController;
    @Mock
    private IRoomService roomService;

    @Test
    void removeBed() {
        doNothing().when(roomService).removeBed(any(BedDto.class));
        removeBedController.removeBed(new BedDto());
        verify(roomService).removeBed(any(BedDto.class));
    }
}
