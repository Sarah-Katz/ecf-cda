package co.simplon.sarah.api.ecf.business.service.bed;

import java.util.List;

import co.simplon.sarah.api.ecf.business.dto.BedDto;

public interface IBedService {
    public List<BedDto> getAllBeds();

    public BedDto getBedByPatient(final int idPatient);

    public void saveBed(final BedDto bedDto);
}
