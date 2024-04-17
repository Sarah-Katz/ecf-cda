package co.simplon.sarah.api.ecf.presentation.controller.patient;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.sarah.api.ecf.business.dto.PatientDto;
import co.simplon.sarah.api.ecf.business.service.patient.IPatientService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin
@Tag(name = "Patients")
public class AssignServiceController {
    private IPatientService patientService;

    public AssignServiceController(final IPatientService iPatientService) {
        this.patientService = iPatientService;
    }

    /**
     * @param patientDto The patient to assign a bed to
     * @param serviceId  The id of the service to assign
     * @return True if the assignment was successful, false otherwise
     */
    @PostMapping("/patients/assign/{serviceId}")
    public boolean assignService(@RequestBody final PatientDto patientDto, @PathVariable final int serviceId) {
        return this.patientService.assignService(patientDto, serviceId);
    }
}
