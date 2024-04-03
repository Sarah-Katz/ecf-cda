package co.simplon.sarah.api.ecf.business.service.bed;

import java.util.List;

import co.simplon.sarah.api.ecf.business.dto.BedDto;

public interface IBedService {
    /**
     * @return A list of all the beds.
     */
    public List<BedDto> getAllBeds();

    /**
     * @param idPatient the patient's id
     * @return the bed assigned to the given patient.
     */
    public BedDto getBedByPatient(final int idPatient);

    /**
     * @param bedDto the bed to save.
     */
    public void saveBed(final BedDto bedDto);
}
