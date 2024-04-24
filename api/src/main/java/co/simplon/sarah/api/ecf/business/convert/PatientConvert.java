package co.simplon.sarah.api.ecf.business.convert;

import java.util.List;

import co.simplon.sarah.api.ecf.business.dto.PatientDto;
import co.simplon.sarah.api.ecf.persistance.entity.Patient;

public class PatientConvert {
    private static PatientConvert instance;

    private PatientConvert() {
    }

    /**
     * @return an instance of the PatientConvert class
     */
    public static PatientConvert getInstance() {
        if (instance == null) {
            instance = new PatientConvert();
        }
        return instance;
    }

    /**
     * @param dto the PatientDto to convert
     * @return the corresponding entity
     */
    public Patient toEntity(final PatientDto dto) {
        final Patient entity = new Patient();
        try {
            entity.setIdPatient(dto.getIdPatient());
            entity.setFirstName(dto.getFirstName());
            entity.setLastName(dto.getLastName());
            entity.setBirthdate(dto.getBirthdate());
            entity.setSocialSecurityNumber(dto.getSocialSecurityNumber());
            entity.setCreatedAt(dto.getCreatedAt());
            entity.setModifiedAt(dto.getModifiedAt());
        } catch (final NullPointerException e) {
            return null;
        }
        return entity;
    }

    /**
     * @param entity the entity to convert
     * @return the corresponding PatientDto
     */
    public PatientDto toDto(final Patient entity) {
        final PatientDto dto = new PatientDto();
        try {
            dto.setIdPatient(entity.getIdPatient());
            dto.setFirstName(entity.getFirstName());
            dto.setLastName(entity.getLastName());
            dto.setBirthdate(entity.getBirthdate());
            dto.setSocialSecurityNumber(entity.getSocialSecurityNumber());
            dto.setCreatedAt(entity.getCreatedAt());
            dto.setModifiedAt(entity.getModifiedAt());
        } catch (final NullPointerException e) {
            return null;
        }
        return dto;
    }

    /**
     * @param dtoList the list of PatientDto to convert
     * @return the corresponding list of entities
     */
    public List<Patient> toEntityList(final List<PatientDto> dtoList) {
        final List<Patient> entityList = new java.util.ArrayList<>();
        for (final PatientDto dto : dtoList) {
            entityList.add(toEntity(dto));
        }
        return entityList;
    }

    /**
     * @param entityList the list of entities to convert
     * @return the corresponding list of PatientDto
     */
    public List<PatientDto> toDtoList(final List<Patient> entityList) {
        final List<PatientDto> dtoList = new java.util.ArrayList<>();
        for (final Patient entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }
}
