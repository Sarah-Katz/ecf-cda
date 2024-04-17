package co.simplon.sarah.api.ecf.presentation.controller.patient;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.sarah.api.ecf.business.dto.PatientDto;
import co.simplon.sarah.api.ecf.business.service.patient.IPatientService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin
@Tag(name = "Patients")
public class GetAllPatientsController {
    private IPatientService patientService;

    public GetAllPatientsController(final IPatientService patientService) {
        this.patientService = patientService;
    }

    /**
     * @return Returns a list of all the patients
     */
    @GetMapping("/patients")
    public List<PatientDto> getAllPatients() {
        return patientService.getAllPatients();
    }
}
