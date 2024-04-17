package co.simplon.sarah.api.ecf.presentation.controller.bed;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.sarah.api.ecf.business.dto.BedDto;
import co.simplon.sarah.api.ecf.business.service.bed.IBedService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin
@Tag(name = "Beds")
public class GetAllBedsController {
    private IBedService bedService;

    public GetAllBedsController(final IBedService bedService) {
        this.bedService = bedService;
    }

    /**
     * @return Return a list of all beds
     */
    @GetMapping("/beds")
    public List<BedDto> getAllBeds() {
        return bedService.getAllBeds();
    }
}
