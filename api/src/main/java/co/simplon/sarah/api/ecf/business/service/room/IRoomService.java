package co.simplon.sarah.api.ecf.business.service.room;

import java.util.List;

import co.simplon.sarah.api.ecf.business.dto.BedDto;
import co.simplon.sarah.api.ecf.business.dto.RoomDto;

public interface IRoomService {
    /**
     * @param serviceId The service's id
     * @return The list of available beds for the given service
     */
    public List<BedDto> getAvailableBeds(final int serviceId);

    /**
     * @param idPatient The patient's id
     * @return The room assigned to the patient
     */
    public RoomDto getRoomByPatient(final int idPatient);

    /**
     * Finds all the rooms assigned to a service.
     * 
     * @param serviceId The service's id
     * @return The list of rooms assigned to the service
     */
    public List<RoomDto> getRoomsByService(final int serviceId);

    /**
     * @param roomDto The room in which to add the bed
     * @param bedDto  The bed to add
     */
    public void addBed(final RoomDto roomDto, final BedDto bedDto);

    /**
     * @param bedDto The bed to remove from a given room
     */
    public void removeBed(final BedDto bedDto);
}
