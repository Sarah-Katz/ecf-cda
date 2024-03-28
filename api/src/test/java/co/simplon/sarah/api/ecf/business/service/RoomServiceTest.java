package co.simplon.sarah.api.ecf.business.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
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
import co.simplon.sarah.api.ecf.business.dto.RoomDto;
import co.simplon.sarah.api.ecf.business.service.bed.BedServiceImpl;
import co.simplon.sarah.api.ecf.business.service.room.RoomServiceImpl;
import co.simplon.sarah.api.ecf.persistance.entity.Bed;
import co.simplon.sarah.api.ecf.persistance.entity.Room;
import co.simplon.sarah.api.ecf.persistance.repository.room.IRoomRepository;

@ExtendWith(MockitoExtension.class)
class RoomServiceTest {
    @InjectMocks
    private RoomServiceImpl roomService;
    @Mock
    private IRoomRepository roomRepository;
    @Mock
    private BedServiceImpl bedService;

    @Test
    void getAvailableBeds() {
        when(roomRepository.getAvailableBeds(1)).thenReturn(List.of(new Bed()));
        List<BedDto> list = roomService.getAvailableBeds(1);
        verify(roomRepository, times(1)).getAvailableBeds(1);
        assertEquals(BedDto.class, list.get(0).getClass());
    }

    @Test
    void getRoomByPatient() {
        when(roomRepository.findByPatientId(1)).thenReturn(new Room());
        RoomDto room = roomService.getRoomByPatient(1);
        verify(roomRepository, times(1)).findByPatientId(1);
        assertEquals(RoomDto.class, room.getClass());
    }

    @Test
    void getRoomsByService() {
        when(roomRepository.findByService(1)).thenReturn(List.of(new Room()));
        List<RoomDto> list = roomService.getRoomsByService(1);
        verify(roomRepository, times(1)).findByService(1);
        assertEquals(RoomDto.class, list.get(0).getClass());
    }

    @Test
    void addBed() {
        doNothing().when(bedService).saveBed(any(BedDto.class));
        roomService.addBed(new RoomDto(), new BedDto());
        verify(bedService, times(1)).saveBed(any(BedDto.class));
    }

    @Test
    void removeBed() {
        doNothing().when(bedService).saveBed(any(BedDto.class));
        roomService.removeBed(new BedDto());
        verify(bedService, times(1)).saveBed(any(BedDto.class));
    }
}
