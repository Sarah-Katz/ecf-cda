package co.simplon.sarah.api.ecf.business.service.bed;

import java.util.List;

import co.simplon.sarah.api.ecf.business.convert.BedConvert;
import co.simplon.sarah.api.ecf.business.dto.BedDto;
import co.simplon.sarah.api.ecf.persistance.repository.bed.IBedRepository;

public class BedServiceImpl implements IBedService {
    private IBedRepository bedRepository;

    public BedServiceImpl(final IBedRepository bedRepository) {
        this.bedRepository = bedRepository;
    }

    @Override
    public List<BedDto> getAllBeds() {
        // TODO: Implement this method
        return null;
    }

    @Override
    public BedDto getBedByPatient(final int idPatient) {
        // TODO: Implement this method
        return null;
    }

    @Override
    public void saveBed(final BedDto bedDto) {
        bedRepository.save(BedConvert.getInstance().toEntity(bedDto));
    }
}
