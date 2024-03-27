package co.simplon.sarah.api.ecf.persistance.repository.room;

public class RoomQueries {
    private RoomQueries() {
        throw new IllegalStateException("Utility class cannot be instantiated");
    }

    public static final String GET_AVAILABLE_BEDS = "SELECT b FROM Bed b JOIN Room r WHERE r.service.id = :idService AND b.user IS NULL";
    public static final String FIND_BY_PATIENT_ID = "SELECT r FROM Room r JOIN Bed b WHERE bed.patient.id = :idPatient";
    public static final String FIND_BY_SERVICE_ID = "SELECT r FROM Room r WHERE r.service.id = :idService";
}
