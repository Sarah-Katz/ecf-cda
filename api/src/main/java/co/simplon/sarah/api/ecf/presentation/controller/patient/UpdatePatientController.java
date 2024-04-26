package co.simplon.sarah.api.ecf.presentation.controller.patient;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.sarah.api.ecf.business.dto.PatientDto;
import co.simplon.sarah.api.ecf.business.service.patient.IPatientService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin
@Tag(name = "Patients")
public class UpdatePatientController {
    private IPatientService patientService;

    public UpdatePatientController(IPatientService patientService) {
        this.patientService = patientService;
    }

    /**
     * @param patientDto the patientDto to update in the database
     */
    @PutMapping("/patients")
    public void updatePatient(@RequestBody final PatientDto patientDto) {
        patientService.updatePatient(patientDto);
    }
}
