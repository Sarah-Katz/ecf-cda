package co.simplon.sarah.api.ecf.persistance.repository;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.sarah.api.ecf.persistance.entity.Bed;
import co.simplon.sarah.api.ecf.persistance.entity.Room;
import co.simplon.sarah.api.ecf.persistance.repository.room.IRoomRepository;

@ExtendWith(MockitoExtension.class)
class RoomRepositoryTest {
    @Mock
    private IRoomRepository roomRepository;

    @Test
    @DisplayName("Test Get Available Beds")
    void testGetAvailableBeds() {
        when(roomRepository.getAvailableBeds(1)).thenReturn(List.of(new Bed()));
        List<Bed> list = roomRepository.getAvailableBeds(1);
        verify(roomRepository, times(1)).getAvailableBeds(1);
        assert list.size() == 1;
        assert list.get(0) instanceof Bed;
    }

    @Test
    @DisplayName("Test Find By Patient Id")
    void testFindByPatientId() {
        when(roomRepository.findByPatientId(1)).thenReturn(new Room());
        Room room = roomRepository.findByPatientId(1);
        verify(roomRepository, times(1)).findByPatientId(1);
        assert room != null;
        assert room instanceof Room;
    }

    @Test
    @DisplayName("Test Find By Service Id")
    void testFindByServiceId() {
        when(roomRepository.findByService(1)).thenReturn(List.of(new Room()));
        List<Room> list = roomRepository.findByService(1);
        verify(roomRepository, times(1)).findByService(1);
        assert list.size() == 1;
        assert list.get(0) instanceof Room;
    }
}
