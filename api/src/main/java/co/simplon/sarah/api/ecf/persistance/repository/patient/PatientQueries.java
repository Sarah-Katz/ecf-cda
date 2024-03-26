package co.simplon.sarah.api.ecf.persistance.repository.patient;

public class PatientQueries {
    private PatientQueries() {
        throw new IllegalStateException("Utility class not meant to be instantiated");
    }

    public static final String FIND_BY_SERVICE_NAME = "SELECT p FROM Patient p JOIN Bed b JOIN Room r JOIN Service s WHERE s.name = :name";
}
