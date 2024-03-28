package co.simplon.sarah.api.ecf.business.service.room;

import java.util.List;

import co.simplon.sarah.api.ecf.business.convert.BedConvert;
import co.simplon.sarah.api.ecf.business.convert.RoomConvert;
import co.simplon.sarah.api.ecf.business.dto.BedDto;
import co.simplon.sarah.api.ecf.business.dto.RoomDto;
import co.simplon.sarah.api.ecf.business.service.bed.IBedService;
import co.simplon.sarah.api.ecf.persistance.repository.room.IRoomRepository;

public class RoomServiceImpl implements IRoomService {
    private IRoomRepository roomRepository;
    private IBedService bedService;

    public RoomServiceImpl(final IRoomRepository iRoomRepository, final IBedService iBedService) {
        this.roomRepository = iRoomRepository;
        this.bedService = iBedService;
    }

    public List<BedDto> getAvailableBeds(final int serviceId) {
        return BedConvert.getInstance().toDtoList(roomRepository.getAvailableBeds(serviceId));
    }

    @Override
    public RoomDto getRoomByPatient(final int idPatient) {
        return RoomConvert.getInstance().toDto(roomRepository.findByPatientId(idPatient));
    }

    @Override
    public List<RoomDto> getRoomsByService(final int serviceId) {
        return RoomConvert.getInstance().toDtoList(roomRepository.findByService(serviceId));
    }

    @Override
    public void addBed(final RoomDto roomDto, final BedDto bedDto) {
        bedDto.setRoom(roomDto);
        bedService.saveBed(bedDto);
    }

    @Override
    public void removeBed(final BedDto bedDto) {
        bedDto.setRoom(null);
        bedService.saveBed(bedDto);
    }
}
