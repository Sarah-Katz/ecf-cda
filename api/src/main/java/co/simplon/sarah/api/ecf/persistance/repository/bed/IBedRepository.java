package co.simplon.sarah.api.ecf.persistance.repository.bed;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.simplon.sarah.api.ecf.persistance.entity.Bed;

public interface IBedRepository extends JpaRepository<Bed, Integer> {

    /**
     * Finds the bed assigned to a patient.
     * 
     * @param idPatient the patient's id
     * @return the bed assigned to the patient
     */
    @Query(BedQueries.FIND_BY_PATIENT_ID)
    Bed findByPatientId(final int idPatient);
}
