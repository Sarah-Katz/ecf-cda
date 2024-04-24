package co.simplon.sarah.api.ecf.business.convert;

import java.util.ArrayList;
import java.util.List;

import co.simplon.sarah.api.ecf.business.dto.ServiceDto;
import co.simplon.sarah.api.ecf.persistance.entity.Service;

public class ServiceConvert {
    private static ServiceConvert instance;

    private ServiceConvert() {
    }

    /**
     * @return an instance of the ServiceConvert class
     */
    public static ServiceConvert getInstance() {
        if (instance == null) {
            instance = new ServiceConvert();
        }
        return instance;
    }

    /**
     * @param dto the ServiceDto to convert
     * @return the corresponding entity
     */
    public Service toEntity(final ServiceDto dto) {
        final Service entity = new Service();
        try {
            entity.setIdService(dto.getIdService());
            entity.setName(dto.getName());
        } catch (final NullPointerException e) {
            return null;
        }
        return entity;
    }

    /**
     * @param entity the entity to convert
     * @return the corresponding ServiceDto
     */
    public ServiceDto toDto(final Service entity) {
        final ServiceDto dto = new ServiceDto();
        try {
            dto.setIdService(entity.getIdService());
            dto.setName(entity.getName());
        } catch (final NullPointerException e) {
            return null;
        }
        return dto;
    }

    /**
     * @param dtoList the list of ServiceDto to convert
     * @return the corresponding list of entities
     */
    public List<Service> toEntityList(final List<ServiceDto> dtoList) {
        final List<Service> entityList = new ArrayList<>();
        for (final ServiceDto dto : dtoList) {
            entityList.add(toEntity(dto));
        }
        return entityList;
    }

    /**
     * @param entityList the list of entities to convert
     * @return the corresponding list of ServiceDto
     */
    public List<ServiceDto> toDtoList(final List<Service> entityList) {
        final List<ServiceDto> dtoList = new ArrayList<>();
        for (final Service entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }
}
