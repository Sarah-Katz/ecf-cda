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
@Table(name = "bed")
public class Bed {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_bed")
    private int idBed;

    @ManyToOne
    @JoinColumn(name = "id_patient")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "id_room")
    private Room room;

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
    public Patient getPatient() {
        return patient;
    }

    /**
     * @param patient the bed's patient to set
     */
    public void setPatient(final Patient patient) {
        this.patient = patient;
    }

    /**
     * @return the bed's room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * @param room the bed's room to set
     */
    public void setRoom(final Room room) {
        this.room = room;
    }
}
