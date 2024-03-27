package co.simplon.sarah.api.ecf.business.convert;

import java.util.ArrayList;
import java.util.List;

import co.simplon.sarah.api.ecf.business.dto.BedDto;
import co.simplon.sarah.api.ecf.persistance.entity.Bed;

public class BedConvert {
    private static BedConvert instance;

    private BedConvert() {
    }

    /**
     * @return an instance of the BedConvert class
     */
    public static BedConvert getInstance() {
        if (instance == null) {
            instance = new BedConvert();
        }
        return instance;
    }

    /**
     * @param dto the BedDto to convert
     * @return the corresponding entity
     */
    public Bed toEntity(final BedDto dto) {
        final Bed entity = new Bed();
        entity.setPatient(dto.getPatient() != null ? PatientConvert.getInstance().toEntity(dto.getPatient()) : null);
        entity.setRoom(dto.getRoom() != null ? RoomConvert.getInstance().toEntity(dto.getRoom()) : null);
        return entity;
    }

    /**
     * @param entity the entity to convert
     * @return the corresponding BedDto
     */
    public BedDto toDto(final Bed entity) {
        final BedDto dto = new BedDto();
        dto.setPatient(entity.getPatient() != null ? PatientConvert.getInstance().toDto(entity.getPatient()) : null);
        dto.setRoom(entity.getRoom() != null ? RoomConvert.getInstance().toDto(entity.getRoom()) : null);
        return dto;
    }

    /**
     * @param dtoList the list of BedDto to convert
     * @return the corresponding list of entities
     */
    public List<Bed> toEntityList(final List<BedDto> dtoList) {
        final List<Bed> entityList = new ArrayList<>();
        for (final BedDto dto : dtoList) {
            entityList.add(toEntity(dto));
        }
        return entityList;
    }

    /**
     * @param entityList the list of entities to convert
     * @return the corresponding list of BedDto
     */
    public List<BedDto> toDtoList(final List<Bed> entityList) {
        final List<BedDto> dtoList = new ArrayList<>();
        for (final Bed entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }
}
