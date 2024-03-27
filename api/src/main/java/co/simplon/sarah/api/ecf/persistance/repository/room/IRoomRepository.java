package co.simplon.sarah.api.ecf.persistance.repository.room;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.simplon.sarah.api.ecf.persistance.entity.Bed;
import co.simplon.sarah.api.ecf.persistance.entity.Room;

public interface IRoomRepository extends JpaRepository<Room, Integer> {
    @Query(RoomQueries.GET_AVAILABLE_BEDS)
    List<Bed> getAvailableBeds(final int idService);

    @Query(RoomQueries.FIND_BY_PATIENT_ID)
    Bed findByPatientId(final int idPatient);

    @Query(RoomQueries.FIND_BY_SERVICE_ID)
    List<Room> findByService(final int idService);
}
