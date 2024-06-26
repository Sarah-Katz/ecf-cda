package co.simplon.sarah.api.ecf.unit.business.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.sarah.api.ecf.business.dto.ServiceDto;
import co.simplon.sarah.api.ecf.business.service.service.ServiceServiceImpl;
import co.simplon.sarah.api.ecf.persistance.entity.Service;
import co.simplon.sarah.api.ecf.persistance.repository.service.IServiceRepository;

@ExtendWith(MockitoExtension.class)
class ServiceServiceTest {
    @InjectMocks
    private ServiceServiceImpl serviceService;

    @Mock
    private IServiceRepository serviceRepository;

    @Test
    void getAllServices() {
        when(serviceRepository.findAll()).thenReturn(List.of(new Service()));
        List<ServiceDto> services = serviceService.getAllServices();
        verify(serviceRepository, times(1)).findAll();
        assertEquals(ServiceDto.class, services.get(0).getClass());
    }
}
