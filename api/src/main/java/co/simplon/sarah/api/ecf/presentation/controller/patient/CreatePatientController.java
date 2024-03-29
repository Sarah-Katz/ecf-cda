package co.simplon.sarah.api.ecf.presentation.controller.patient;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.sarah.api.ecf.business.dto.PatientDto;
import co.simplon.sarah.api.ecf.business.service.patient.IPatientService;

@RestController
@CrossOrigin
public class CreatePatientController {
    private IPatientService patientService;

    public CreatePatientController(IPatientService patientService) {
        this.patientService = patientService;
    }

    /**
     * @param patientDto the patientDto to add to the database
     */
    @PostMapping("/patients")
    public void createPatient(@RequestBody final PatientDto patientDto) {
        patientService.savePatient(patientDto);
    }
}
