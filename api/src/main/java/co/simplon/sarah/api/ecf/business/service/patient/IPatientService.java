package co.simplon.sarah.api.ecf.business.service.patient;

import java.util.List;

import co.simplon.sarah.api.ecf.business.dto.PatientDto;

public interface IPatientService {

    /**
     * @param patientDto The patient to save
     */
    public void savePatient(final PatientDto patientDto);

    /**
     * @param patientDto The patient to update
     */
    public void updatePatient(final PatientDto patientDto);

    /**
     * @return A list of all the patients
     */
    public List<PatientDto> getAllPatients();

    /**
     * @param idPatient The patient's id
     * @return The patient with the given id
     */
    public PatientDto getPatientById(final int idPatient);

    /**
     * @param serviceName The service's name
     * @return A list of all the patients that are assigned to a service
     */
    public List<PatientDto> getPatientsByService(final String serviceName);

    /**
     * @param idPatient The patient to delete's id
     */
    public void deletePatient(final int idPatient);

    /**
     * Assigns a patient to an available bed in the given service.
     * 
     * @param patientDto The patient to update
     * @param idService  The service's id
     */
    public boolean assignService(final PatientDto patientDto, final int idService);

    /**
     * Removes a patient from a service.
     * 
     * @param patientDto The patient to update
     */
    public void removeFromService(final PatientDto patientDto);
}
