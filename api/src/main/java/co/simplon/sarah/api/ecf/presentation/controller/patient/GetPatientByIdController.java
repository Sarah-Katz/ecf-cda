package co.simplon.sarah.api.ecf.presentation.controller.patient;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.sarah.api.ecf.business.dto.PatientDto;
import co.simplon.sarah.api.ecf.business.service.patient.IPatientService;

@RestController
@CrossOrigin
public class GetPatientByIdController {
    private IPatientService patientService;

    public GetPatientByIdController(final IPatientService patientService) {
        this.patientService = patientService;
    }

    /**
     * @param id the id of the patient to retrieve
     * @return the {@link PatientDto} with the given id
     */
    @GetMapping("/patients/{id}")
    public PatientDto getPatientById(@PathVariable final int id) {
        return patientService.getPatientById(id);
    }

}
