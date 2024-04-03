package co.simplon.sarah.api.ecf.business.dto;

public class RoomDto {
    private int idRoom;
    private String number;
    private ServiceDto service;

    /**
     * @return the room's id
     */
    public int getIdRoom() {
        return idRoom;
    }

    /**
     * @param idRoom the room's id to set
     */
    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    /**
     * @return the room's number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the room's number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return the room's service
     */
    public ServiceDto getService() {
        return service;
    }

    /**
     * @param service the room's service to set
     */
    public void setService(ServiceDto service) {
        this.service = service;
    }
}
