package co.simplon.sarah.api.ecf.business.convert;

import co.simplon.sarah.api.ecf.business.dto.PatientDto;
import co.simplon.sarah.api.ecf.persistance.entity.Patient;

/**
 * This class is used to convert a PatientDto to a Patient entity and
 * vice-versa, get the instance of this class using
 * {@link PatientConvert#getInstance()}
 */
public class PatientConvert {
    private static PatientConvert instance = new PatientConvert();

    private PatientConvert() {
        throw new IllegalStateException("use getInstance() method to get an instance");
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
     * Converts a Patient entity to a PatientDto
     * 
     * @param dto the dto to convert
     * @return the converted entity
     */
    public Patient toEntity(final PatientDto dto) {
        final Patient entity = new Patient();
        entity.setIdPatient(dto.getIdPatient());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setBirthdate(dto.getBirthdate());
        entity.setSocialSecurityNumber(dto.getSocialSecurityNumber());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setModifiedAt(dto.getModifiedAt());
        return entity;
    }

    /**
     * Converts a PatientDto to a Patient entity
     * 
     * @param entity the entity to convert
     * @return the converted entity
     */
    public PatientDto toDto(final Patient entity) {
        final PatientDto dto = new PatientDto();
        dto.setIdPatient(entity.getIdPatient());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setBirthdate(entity.getBirthdate());
        dto.setSocialSecurityNumber(entity.getSocialSecurityNumber());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setModifiedAt(entity.getModifiedAt());
        return dto;
    }
}
