package co.simplon.sarah.api.ecf.business.dto;

public class ServiceDto {
    private int idService;
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
