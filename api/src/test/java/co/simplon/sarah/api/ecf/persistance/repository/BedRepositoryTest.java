package co.simplon.sarah.api.ecf.persistance.repository;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.sarah.api.ecf.persistance.entity.Bed;
import co.simplon.sarah.api.ecf.persistance.repository.bed.IBedRepository;

@ExtendWith(MockitoExtension.class)
class BedRepositoryTest {
    @Mock
    private IBedRepository bedRepository;

    @Test
    @DisplayName("Test query patient by service name")
    void testQueryPatientByServiceName() {
        when(bedRepository.findByPatientId(1)).thenReturn(new Bed());
        Bed bed = bedRepository.findByPatientId(1);
        verify(bedRepository, times(1)).findByPatientId(1);
        assert bed != null;
        assert bed instanceof Bed;
    }
}
