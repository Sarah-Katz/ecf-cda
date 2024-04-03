package co.simplon.sarah.api.ecf.business.service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.sarah.api.ecf.business.convert.ServiceConvert;
import co.simplon.sarah.api.ecf.business.dto.ServiceDto;
import co.simplon.sarah.api.ecf.persistance.repository.service.IServiceRepository;

@Service
public class ServiceServiceImpl implements IServiceService {
    private IServiceRepository serviceRepository;

    public ServiceServiceImpl(final IServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<ServiceDto> getAllServices() {
        return ServiceConvert.getInstance().toDtoList(serviceRepository.findAll());
    }

}
