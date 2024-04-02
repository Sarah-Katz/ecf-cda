package co.simplon.sarah.api.ecf.unit.persistance.repository;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.sarah.api.ecf.persistance.entity.Patient;
import co.simplon.sarah.api.ecf.persistance.repository.patient.IPatientRepository;

@ExtendWith(MockitoExtension.class)
class PatientRepositoryTest {
    @Mock
    private IPatientRepository patientRepository;

    @Test
    @DisplayName("Test query patient by service name")
    void testQueryPatientByServiceName() {
        when(patientRepository.findByService("name")).thenReturn(List.of(new Patient()));
        List<Patient> list = patientRepository.findByService("name");
        // Assert mock has been called
        verify(patientRepository, times(1)).findByService("name");
        assert list.size() == 1;
        assert list.get(0) instanceof Patient;
    }
}
