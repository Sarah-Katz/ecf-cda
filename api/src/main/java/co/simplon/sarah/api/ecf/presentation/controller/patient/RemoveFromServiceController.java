package co.simplon.sarah.api.ecf.presentation.controller.patient;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.sarah.api.ecf.business.dto.PatientDto;
import co.simplon.sarah.api.ecf.business.service.patient.IPatientService;

@RestController
@CrossOrigin
public class RemoveFromServiceController {
    private IPatientService patientService;

    public RemoveFromServiceController(final IPatientService patientService) {
        this.patientService = patientService;
    }

    /**
     * @param patientDto The patient to remove from a service
     */
    @PostMapping("patients/unassign")
    public void removeFromService(@RequestBody final PatientDto patientDto) {
        patientService.removeFromService(patientDto);
    }
}
