package co.simplon.sarah.api.ecf.presentation.controller.service;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.sarah.api.ecf.business.dto.ServiceDto;
import co.simplon.sarah.api.ecf.business.service.service.IServiceService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin
@Tag(name = "Services")
public class GetAllServicesController {
    private IServiceService serviceService;

    public GetAllServicesController(final IServiceService serviceService) {
        this.serviceService = serviceService;
    }

    /**
     * @return A list of all the services
     */
    @GetMapping("/services")
    public List<ServiceDto> getAllServices() {
        return serviceService.getAllServices();
    }
}
