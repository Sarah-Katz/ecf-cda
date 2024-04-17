package co.simplon.sarah.api.ecf.presentation.controller.bed;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.sarah.api.ecf.business.dto.BedDto;
import co.simplon.sarah.api.ecf.business.service.bed.IBedService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin
@Tag(name = "Beds")
public class GetBedByPatientController {
    private IBedService bedService;

    public GetBedByPatientController(final IBedService bedService) {
        this.bedService = bedService;
    }

    /**
     * @param idPatient Patient's id
     * @return
     */
    @GetMapping("/beds/byPatient/{idPatient}")
    public BedDto getBedByPatient(@PathVariable final int idPatient) {
        return bedService.getBedByPatient(idPatient);
    }
}
