package co.simplon.sarah.api.ecf.business.dto;

import java.util.Date;

public class PatientDto {
    private int idPatient;
    private String firstName;
    private String lastName;
    private Date birthdate;
    private String socialSecurityNumber;
    private Date createdAt;
    private Date modifiedAt;

    /**
     * Returns the patient's id.
     * 
     * @return the patient's id
     */
    public int getIdPatient() {
        return idPatient;
    }

    /**
     * Sets the patient's id.
     * 
     * @param idPatient the patient's id to set
     */
    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    /**
     * Returns the patient's firstname.
     * 
     * @return the patient's firstname
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the patient's firstname.
     * 
     * @param firstName the patient's firstname to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the patient's lastname.
     * 
     * @return the patient's lastname
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the patient's lastname.
     * 
     * @param lastName the patient's lastname to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the patient's birthdate.
     * 
     * @return the patient's birthdate
     */
    public Date getBirthdate() {
        return birthdate;
    }

    /**
     * Sets the patient's birthdate.
     * 
     * @param birthdate the patient's birthdate to set
     */
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Returns the patient's social security number.
     * 
     * @return the patient's social security number
     */
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    /**
     * Sets the patient's social security number.
     * 
     * @param socialSecurityNumber the patient's social security number to set
     */
    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    /**
     * Returns the patient's creation date.
     * 
     * @return the patient's creation date
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the patient's creation date.
     * 
     * @param createdAt the patient's creation date to set
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Returns the patient's last modification date.
     * 
     * @return the patient's last modification date
     */
    public Date getModifiedAt() {
        return modifiedAt;
    }

    /**
     * Sets the patient's last modification date.
     * 
     * @param modifiedAt the patient's last modification date to set
     */
    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
