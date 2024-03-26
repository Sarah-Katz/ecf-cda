package co.simplon.sarah.api.ecf.persistance.repository.patient;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.simplon.sarah.api.ecf.persistance.entity.Patient;

public interface IPatientRepository extends JpaRepository<Patient, Integer> {
    @Query(PatientQueries.FIND_BY_SERVICE_NAME)
    List<Patient> findByService(final String name);
}