package co.simplon.sarah.api.ecf.persistance.repository.patient;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.simplon.sarah.api.ecf.persistance.entity.Patient;

public interface IPatientRepository extends JpaRepository<Patient, Integer> {

    /**
     * Finds all the patients assigned to a service, filtered by service name.
     * 
     * @param name the service's name
     * @return the list of patients assigned to the service
     */
    @Query(PatientQueries.FIND_BY_SERVICE_NAME)
    List<Patient> findByService(final String name);
}