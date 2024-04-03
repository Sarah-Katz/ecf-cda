package co.simplon.sarah.api.ecf.business.dto;

public class BedDto {
    private int idBed;
    private PatientDto patient;
    private RoomDto room;

    /**
     * @return the bed's id
     */
    public int getIdBed() {
        return idBed;
    }

    /**
     * @param idBed the bed's id to set
     */
    public void setIdBed(final int idBed) {
        this.idBed = idBed;
    }

    /**
     * @return the bed's patient
     */
    public PatientDto getPatient() {
        return patient;
    }

    /**
     * @param patient the bed's patient to set
     */
    public void setPatient(final PatientDto patient) {
        this.patient = patient;
    }

    /**
     * @return the bed's room
     */
    public RoomDto getRoom() {
        return room;
    }

    /**
     * @param room the bed's room to set
     */
    public void setRoom(final RoomDto room) {
        this.room = room;
    }
}
