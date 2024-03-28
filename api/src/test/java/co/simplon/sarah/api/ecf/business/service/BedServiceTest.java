package co.simplon.sarah.api.ecf.business.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.sarah.api.ecf.business.dto.BedDto;
import co.simplon.sarah.api.ecf.business.service.bed.BedServiceImpl;
import co.simplon.sarah.api.ecf.persistance.entity.Bed;
import co.simplon.sarah.api.ecf.persistance.repository.bed.IBedRepository;

@ExtendWith(MockitoExtension.class)
class BedServiceTest {
    @InjectMocks
    private BedServiceImpl bedService;

    @Mock
    private IBedRepository bedRepository;

    @Test
    void testGetAllBeds() {
        when(bedRepository.findAll()).thenReturn(List.of(new Bed()));
        List<BedDto> beds = bedService.getAllBeds();
        verify(bedRepository, times(1)).findAll();
        assertEquals(BedDto.class, beds.get(0).getClass());
    }

    @Test
    void getBedByPatient() {
        when(bedRepository.findByPatientId(1)).thenReturn(new Bed());
        BedDto bed = bedService.getBedByPatient(1);
        verify(bedRepository, times(1)).findByPatientId(1);
        assertEquals(BedDto.class, bed.getClass());
    }

    @Test
    void saveBed() {
        when(bedRepository.save(any(Bed.class))).thenReturn(null);
        bedService.saveBed(new BedDto());
        verify(bedRepository, times(1)).save(any(Bed.class));
    }
}
