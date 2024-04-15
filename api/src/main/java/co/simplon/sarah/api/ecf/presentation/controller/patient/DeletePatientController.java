package co.simplon.sarah.api.ecf.presentation.controller.patient;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.sarah.api.ecf.business.service.patient.IPatientService;

@RestController
@CrossOrigin
public class DeletePatientController {
    private IPatientService patientService;

    public DeletePatientController(final IPatientService patientService) {
        this.patientService = patientService;
    }

    /**
     * @param id the id of the patient to delete
     */
    @DeleteMapping("/patients/{id}")
    public void deletePatientById(@PathVariable final int id) {
        patientService.deletePatient(id);
    }
}
