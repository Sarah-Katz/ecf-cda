package co.simplon.sarah.api.ecf.persistance.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_patient")
    private int idPatient;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "birthdate", nullable = false)
    private String birthdate;

    @Column(name = "social_security_number", nullable = false)
    private String socialSecurityNumber;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "modified_at")
    private Date modifiedAt;

    /**
     * @return the patient's id
     */
    public int getIdPatient() {
        return idPatient;
    }

    /**
     * @param idPatient the patient's id to set
     */
    public void setIdPatient(final int idPatient) {
        this.idPatient = idPatient;
    }

    /**
     * @return the patient's firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the patient's firstname to set
     */
    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the patient's lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the patient's lastname to set
     */
    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the patient's birthdate
     */
    public String getBirthdate() {
        return birthdate;
    }

    /**
     * @param birthdate the patient's birthdate to set
     */
    public void setBirthdate(final String birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * @return the patient's social security number
     */
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    /**
     * @param socialSecurityNumber the patient's social security number to set
     */
    public void setSocialSecurityNumber(final String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    /**
     * @return the patient's creation date
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the patient's creation date to set
     */
    public void setCreatedAt(final Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return the patient's last modification date
     */
    public Date getModifiedAt() {
        return modifiedAt;
    }

    /**
     * @param modifiedAt the patient's last modification date to set
     */
    public void setModifiedAt(final Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
