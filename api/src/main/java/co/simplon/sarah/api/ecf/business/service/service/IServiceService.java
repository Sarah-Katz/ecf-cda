package co.simplon.sarah.api.ecf.business.service.service;

import java.util.List;

import co.simplon.sarah.api.ecf.business.dto.ServiceDto;

public interface IServiceService {

    /**
     * @return A list of all the services
     */
    public List<ServiceDto> getAllServices();
}
