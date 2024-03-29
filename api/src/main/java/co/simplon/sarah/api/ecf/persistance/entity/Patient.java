package co.simplon.sarah.api.ecf.persistance.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_patient")
    private int idPatient;

    @Column(name = "firstName", nullable = false, length = 50)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 50)
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthdate", nullable = false)
    private Date birthdate;

    @Column(name = "social_security_number", nullable = false, length = 15)
    private String socialSecurityNumber;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.DATE)
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
     * @return the patient's firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the patient's firstName to set
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the patient's lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the patient's lastName to set
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the patient's birthdate
     */
    public Date getBirthdate() {
        return birthdate;
    }

    /**
     * @param birthdate the patient's birthdate to set
     */
    public void setBirthdate(final Date birthdate) {
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
