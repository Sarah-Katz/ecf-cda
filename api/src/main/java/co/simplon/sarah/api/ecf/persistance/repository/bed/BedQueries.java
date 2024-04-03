package co.simplon.sarah.api.ecf.persistance.repository.bed;

public class BedQueries {
    private BedQueries() {
        throw new IllegalStateException("Utility class cannot be instantiated");
    }

    public static final String FIND_BY_PATIENT_ID = "SELECT b FROM Bed b WHERE b.patient.id = :idPatient";
}
