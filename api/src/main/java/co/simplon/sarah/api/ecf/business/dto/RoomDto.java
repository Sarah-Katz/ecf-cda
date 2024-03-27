package co.simplon.sarah.api.ecf.business.dto;

public class RoomDto {
    private int idRoom;
    private String name;
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
     * @return the room's name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the room's name to set
     */
    public void setName(String name) {
        this.name = name;
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
