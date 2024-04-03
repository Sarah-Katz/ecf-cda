package co.simplon.sarah.api.ecf.persistance.repository.room;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.simplon.sarah.api.ecf.persistance.entity.Bed;
import co.simplon.sarah.api.ecf.persistance.entity.Room;

@Repository
public interface IRoomRepository extends JpaRepository<Room, Integer> {

    /**
     * Finds the available beds in the rooms for a service.
     * 
     * @param idService the service's id
     * @return the list of available beds in the rooms for the service
     */
    @Query(RoomQueries.GET_AVAILABLE_BEDS)
    List<Bed> getAvailableBeds(final int idService);

    /**
     * Finds the room assigned to a patient.
     * 
     * @param idPatient the patient's id
     * @return the room assigned to the patient
     */
    @Query(RoomQueries.FIND_BY_PATIENT_ID)
    Room findByPatientId(final int idPatient);

    /**
     * Finds all the rooms assigned to a service.
     * 
     * @param idService the service's id
     * @return the list of rooms assigned to the service
     */
    @Query(RoomQueries.FIND_BY_SERVICE_ID)
    List<Room> findByService(final int idService);
}
