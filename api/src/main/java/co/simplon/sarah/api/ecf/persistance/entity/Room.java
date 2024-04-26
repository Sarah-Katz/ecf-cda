package co.simplon.sarah.api.ecf.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_room")
    private int idRoom;

    @Column(name = "number", nullable = false, length = 4)
    private String number;

    @ManyToOne
    @JoinColumn(name = "id_service", nullable = false)
    private Service service;

    /**
     * @return the room's id
     */
    public int getIdRoom() {
        return idRoom;
    }

    /**
     * @param idRoom the room's id to set
     */
    public void setIdRoom(final int idRoom) {
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
    public void setNumber(final String number) {
        this.number = number;
    }

    /**
     * @return the room's service
     */
    public Service getService() {
        return service;
    }

    /**
     * @param service the room's service to set
     */
    public void setService(final Service service) {
        this.service = service;
    }
}
