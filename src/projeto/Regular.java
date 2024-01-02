// Class done by: André Colaço, 2020220301 and Lino Varela, 2020220433.

package projeto;

import java.io.Serializable;

/**
 * Subclass that contains a regular client.
 */
public class Regular extends Client implements Serializable {

    /**
     * Transport price of the client´s cart.
     */
    private double transportPrice;

    /**
     * Constructor without param.
     */
    public Regular() {
        super();
    }

    /**
     * Constructor with all param.
     *
     * @param name     client name.
     * @param address  client address.
     * @param email    client email.
     * @param phone    client phone number.
     * @param birthday client birthdate.
     */
    public Regular(String name, String address, String email, int phone, Date birthday) {
        super(name, address, email, phone, birthday, "Regular");
        this.transportPrice = 0;
    }

    /**
     * Getter.
     *
     * @return transport price.
     */
    public double getTransportPrice() {
        return transportPrice;
    }

    /**
     * Setter.
     *
     * @param transportPrice transport price.
     */
    public void setTransportPrice(double transportPrice) {
        this.transportPrice = transportPrice;
    }

    /**
     * ToString.
     *
     * @return description of a regular client.
     */
    @Override
    public String toString() {
        return "Regular " + super.toString() + "transportPrice: " + transportPrice + ";";
    }

    /**
     * Method to create a new regular client.
     */
    public void create() {
        super.createClient();

        setType("Regular");
    }

    /**
     * Method to calculate the transport price that is going to be for a regular client.
     */
    @Override
    public void transport() {
        transportPrice = furnitureTransport();
        transportPrice += 20;
    }
}
