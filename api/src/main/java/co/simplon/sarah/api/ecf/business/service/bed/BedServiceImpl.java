package co.simplon.sarah.api.ecf.business.service.bed;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.sarah.api.ecf.business.convert.BedConvert;
import co.simplon.sarah.api.ecf.business.dto.BedDto;
import co.simplon.sarah.api.ecf.persistance.repository.bed.IBedRepository;

@Service
public class BedServiceImpl implements IBedService {
    private IBedRepository bedRepository;

    public BedServiceImpl(final IBedRepository bedRepository) {
        this.bedRepository = bedRepository;
    }

    @Override
    public List<BedDto> getAllBeds() {
        return BedConvert.getInstance().toDtoList(bedRepository.findAll());
    }

    @Override
    public BedDto getBedByPatient(final int idPatient) {
        return BedConvert.getInstance().toDto(bedRepository.findByPatientId(idPatient));
    }

    @Override
    public void saveBed(final BedDto bedDto) {
        bedRepository.save(BedConvert.getInstance().toEntity(bedDto));
    }
}
