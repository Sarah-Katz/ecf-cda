package co.simplon.sarah.api.ecf.business.service.room;

import java.util.List;

import co.simplon.sarah.api.ecf.business.convert.BedConvert;
import co.simplon.sarah.api.ecf.business.dto.BedDto;
import co.simplon.sarah.api.ecf.persistance.entity.Bed;
import co.simplon.sarah.api.ecf.persistance.repository.room.IRoomRepository;

public class RoomServiceImpl implements IRoomService {
    private IRoomRepository roomRepository;

    public RoomServiceImpl(final IRoomRepository iRoomRepository) {
        this.roomRepository = iRoomRepository;
    }

    public List<BedDto> getAvailableBeds(final int serviceId) {
        List<Bed> beds = roomRepository.getAvailableBeds(serviceId);
        return !beds.isEmpty() ? BedConvert.getInstance().toDtoList(beds) : null;
    }
}
