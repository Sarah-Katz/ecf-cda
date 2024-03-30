package co.simplon.sarah.api.ecf.business.service.patient;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.sarah.api.ecf.business.convert.PatientConvert;
import co.simplon.sarah.api.ecf.business.dto.BedDto;
import co.simplon.sarah.api.ecf.business.dto.PatientDto;
import co.simplon.sarah.api.ecf.business.service.bed.IBedService;
import co.simplon.sarah.api.ecf.business.service.room.IRoomService;
import co.simplon.sarah.api.ecf.persistance.entity.Patient;
import co.simplon.sarah.api.ecf.persistance.repository.patient.IPatientRepository;

@Service
public class PatientServiceImpl implements IPatientService {
    private IPatientRepository patientRepository;
    private IRoomService roomService;
    private IBedService bedService;

    public PatientServiceImpl(final IPatientRepository iPatientRepository, final IRoomService iRoomService,
            final IBedService iBedService) {
        this.patientRepository = iPatientRepository;
        this.roomService = iRoomService;
        this.bedService = iBedService;
    }

    @Override
    public void savePatient(final PatientDto patientDto) {
        patientDto.setCreatedAt(new Date());
        patientRepository.save(PatientConvert.getInstance().toEntity(patientDto));
    }

    @Override
    public void updatePatient(final PatientDto patientDto) {
        patientDto.setModifiedAt(new Date());
        patientRepository.save(PatientConvert.getInstance().toEntity(patientDto));
    }

    @Override
    public List<PatientDto> getAllPatients() {
        return PatientConvert.getInstance().toDtoList(patientRepository.findAll());
    }

    @Override
    public PatientDto getPatientById(final int idPatient) {
        Patient patient = patientRepository.findById(idPatient).orElse(null);
        return patient != null ? PatientConvert.getInstance().toDto(patient) : null;
    }

    @Override
    public List<PatientDto> getPatientsByService(final String serviceName) {
        List<Patient> patients = patientRepository.findByService(serviceName);
        return !patients.isEmpty() ? PatientConvert.getInstance().toDtoList(patients) : null;
    }

    @Override
    public void deletePatient(int idPatient) {
        patientRepository.deleteById(idPatient);
    }

    @Override
    public boolean assignService(PatientDto patientDto, int idService) {
        List<BedDto> beds = roomService.getAvailableBeds(idService);
        BedDto bedToAssign;
        if (!beds.isEmpty()) {
            bedToAssign = beds.get(0);
            bedToAssign.setPatient(patientDto);
        } else {
            return false;
        }
        bedService.saveBed(bedToAssign);
        return true;
    }

    @Override
    public void removeFromService(PatientDto patientDto) {
        BedDto bed = bedService.getBedByPatient(patientDto.getIdPatient());
        bed.setPatient(null);
        bedService.saveBed(bed);
    }
}
