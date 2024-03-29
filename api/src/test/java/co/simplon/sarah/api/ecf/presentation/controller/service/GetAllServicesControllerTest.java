package co.simplon.sarah.api.ecf.presentation.controller.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.sarah.api.ecf.business.dto.ServiceDto;
import co.simplon.sarah.api.ecf.business.service.service.IServiceService;

@ExtendWith(MockitoExtension.class)
class GetAllServicesControllerTest {
    @InjectMocks
    private GetAllServicesController getAllServicesController;
    @Mock
    private IServiceService serviceService;

    @Test
    void getAllServices() {
        when(serviceService.getAllServices()).thenReturn(List.of(new ServiceDto()));
        getAllServicesController.getAllServices();
        verify(serviceService).getAllServices();
    }
}
