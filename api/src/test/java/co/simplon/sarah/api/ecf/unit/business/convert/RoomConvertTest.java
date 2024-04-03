package co.simplon.sarah.api.ecf.unit.business.convert;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import co.simplon.sarah.api.ecf.business.convert.RoomConvert;
import co.simplon.sarah.api.ecf.business.dto.RoomDto;
import co.simplon.sarah.api.ecf.business.dto.ServiceDto;
import co.simplon.sarah.api.ecf.persistance.entity.Room;
import co.simplon.sarah.api.ecf.persistance.entity.Service;

class RoomConvertTest {
    private static RoomConvert convert = RoomConvert.getInstance();

    @Test
    void testToEntity() {
        RoomDto dto = new RoomDto();
        dto.setIdRoom(1);
        dto.setNumber("1A");
        dto.setService(new ServiceDto());
        Room entity = convert.toEntity(dto);
        assertEquals(1, entity.getIdRoom());
        assertEquals("1A", entity.getNumber());
        assertEquals(Service.class, entity.getService().getClass());
    }

    @Test
    void testToDto() {
        Room entity = new Room();
        entity.setIdRoom(1);
        entity.setNumber("1A");
        entity.setService(new Service());
        RoomDto dto = convert.toDto(entity);
        assertEquals(1, dto.getIdRoom());
        assertEquals("1A", dto.getNumber());
        assertEquals(ServiceDto.class, dto.getService().getClass());
    }

    @Test
    void testToEntityList() {
        RoomDto dto = new RoomDto();
        dto.setIdRoom(1);
        dto.setNumber("1A");
        dto.setService(new ServiceDto());
        RoomDto dto2 = new RoomDto();
        dto2.setIdRoom(2);
        dto2.setNumber("2A");
        dto2.setService(new ServiceDto());
        RoomDto dto3 = new RoomDto();
        dto3.setIdRoom(3);
        dto3.setNumber("3A");
        dto3.setService(new ServiceDto());
        List<RoomDto> dtoList = List.of(dto, dto2, dto3);
        List<Room> entities = convert.toEntityList(dtoList);
        assertEquals(3, entities.size());
        assertEquals(1, entities.get(0).getIdRoom());
        assertEquals("2A", entities.get(1).getNumber());
        assertEquals(Service.class, entities.get(2).getService().getClass());
    }

    @Test
    void testToDtoList() {
        Room entity = new Room();
        entity.setIdRoom(1);
        entity.setNumber("1A");
        entity.setService(new Service());
        Room entity2 = new Room();
        entity2.setIdRoom(2);
        entity2.setNumber("2A");
        entity2.setService(new Service());
        Room entity3 = new Room();
        entity3.setIdRoom(3);
        entity3.setNumber("3A");
        entity3.setService(new Service());
        List<Room> entities = List.of(entity, entity2, entity3);
        List<RoomDto> dtoList = convert.toDtoList(entities);
        assertEquals(3, dtoList.size());
        assertEquals(1, dtoList.get(0).getIdRoom());
        assertEquals("2A", dtoList.get(1).getNumber());
    }
}
