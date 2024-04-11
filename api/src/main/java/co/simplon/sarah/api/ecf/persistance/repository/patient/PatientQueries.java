package co.simplon.sarah.api.ecf.persistance.repository.patient;

public class PatientQueries {
    private PatientQueries() {
        throw new IllegalStateException("Utility class not meant to be instantiated");
    }

    public static final String FIND_BY_SERVICE_NAME = "SELECT p FROM Patient p JOIN Bed b ON b.patient = p JOIN Room r ON b.room = r JOIN Service s ON r.service = s WHERE s.name = :name";
}
