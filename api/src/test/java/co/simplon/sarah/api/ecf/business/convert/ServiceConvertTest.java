package co.simplon.sarah.api.ecf.business.convert;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import co.simplon.sarah.api.ecf.business.dto.ServiceDto;
import co.simplon.sarah.api.ecf.persistance.entity.Service;

class ServiceConvertTest {
    private static ServiceConvert convert = ServiceConvert.getInstance();

    @Test
    void testToEntity() {
        ServiceDto dto = new ServiceDto();
        dto.setIdService(1);
        dto.setName("name");
        Service entity = convert.toEntity(dto);
        assertEquals(1, entity.getIdService());
        assertEquals("name", entity.getName());
        assertEquals(Service.class, entity.getClass());
    }

    @Test
    void testToDto() {
        Service entity = new Service();
        entity.setIdService(1);
        entity.setName("name");
        ServiceDto dto = convert.toDto(entity);
        assertEquals(1, dto.getIdService());
        assertEquals("name", dto.getName());
        assertEquals(ServiceDto.class, dto.getClass());
    }

    @Test
    void testToEntityList() {
        ServiceDto dto = new ServiceDto();
        dto.setIdService(1);
        dto.setName("name");
        ServiceDto dto2 = new ServiceDto();
        dto2.setIdService(2);
        dto2.setName("name2");
        ServiceDto dto3 = new ServiceDto();
        dto3.setIdService(3);
        dto3.setName("name3");
        List<ServiceDto> dtoList = List.of(dto, dto2, dto3);
        List<Service> entityList = convert.toEntityList(dtoList);
        assertEquals(3, entityList.size());
        assertEquals(1, entityList.get(0).getIdService());
        assertEquals("name", entityList.get(0).getName());
        assertEquals(2, entityList.get(1).getIdService());
    }

    @Test
    void testToDtoList() {
        Service entity = new Service();
        entity.setIdService(1);
        entity.setName("name");
        Service entity2 = new Service();
        entity2.setIdService(2);
        entity2.setName("name2");
        Service entity3 = new Service();
        entity3.setIdService(3);
        entity3.setName("name3");
        List<Service> entityList = List.of(entity, entity2, entity3);
        List<ServiceDto> dtoList = convert.toDtoList(entityList);
        assertEquals(3, dtoList.size());
        assertEquals(1, dtoList.get(0).getIdService());
        assertEquals("name", dtoList.get(0).getName());
        assertEquals(2, dtoList.get(1).getIdService());
    }
}
