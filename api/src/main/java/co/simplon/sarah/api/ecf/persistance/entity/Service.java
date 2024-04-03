package co.simplon.sarah.api.ecf.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_service")
    private int idService;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    /**
     * @return the service's id
     */
    public int getIdService() {
        return idService;
    }

    /**
     * @param idService the service's id to set
     */
    public void setIdService(final int idService) {
        this.idService = idService;
    }

    /**
     * @return the service's name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the service's name to set
     */
    public void setName(final String name) {
        this.name = name;
    }
}
