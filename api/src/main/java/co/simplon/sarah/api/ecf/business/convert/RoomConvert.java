package co.simplon.sarah.api.ecf.business.convert;

import java.util.ArrayList;
import java.util.List;

import co.simplon.sarah.api.ecf.business.dto.RoomDto;
import co.simplon.sarah.api.ecf.persistance.entity.Room;

public class RoomConvert {
    private static RoomConvert instance;

    private RoomConvert() {
    }

    /**
     * @return an instance of the RoomConvert class
     */
    public static RoomConvert getInstance() {
        if (instance == null) {
            instance = new RoomConvert();
        }
        return instance;
    }

    /**
     * @param dto the RoomDto to convert
     * @return the corresponding entity
     */
    public Room toEntity(final RoomDto dto) {
        Room room = new Room();
        room.setNumber(dto.getNumber());
        room.setService(dto.getService() != null ? ServiceConvert.getInstance().toEntity(dto.getService()) : null);
        return room;
    }

    /**
     * @param entity the entity to convert
     * @return the corresponding RoomDto
     */
    public RoomDto toDto(final Room entity) {
        RoomDto dto = new RoomDto();
        dto.setIdRoom(entity.getIdRoom());
        dto.setNumber(entity.getNumber());
        dto.setService(entity.getService() != null ? ServiceConvert.getInstance().toDto(entity.getService()) : null);
        return dto;
    }

    /**
     * @param dtoList the list of RoomDto to convert
     * @return the corresponding list of entities
     */
    public List<Room> toEntityList(final List<RoomDto> dtoList) {
        List<Room> entityList = new ArrayList<>();
        for (RoomDto dto : dtoList) {
            entityList.add(toEntity(dto));
        }
        return entityList;
    }

    /**
     * @param entityList the list of entities to convert
     * @return the corresponding list of RoomDto
     */
    public List<RoomDto> toDtoList(final List<Room> entityList) {
        List<RoomDto> dtoList = new ArrayList<>();
        for (Room entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }
}
