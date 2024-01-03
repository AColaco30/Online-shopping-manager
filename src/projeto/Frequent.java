// Class done by: André Colaço, 2020220301 and Lino Varela, 2020220433.

package projeto;

/**
 * Subclass that contains a frequent client.
 */
public class Frequent extends Client {

    /**
     * Transport price of the client´s cart.
     */
    private double transportPrice;

    /**
     * Constructor without param.
     */
    public Frequent() {
        super();
    }

    /**
     * Constructor with all param.
     *
     * @param name     clients name.
     * @param address  clients address.
     * @param email    clients email.
     * @param phone    clients phone number.
     * @param birthday clients birthdate.
     */
    public Frequent(String name, String address, String email, int phone, Date birthday) {
        super(name, address, email, phone, birthday, "Frequent");
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
     * @return description of a frequent client.
     */
    @Override
    public String toString() {
        return "Frequent " + super.toString() + "transportPrice: " + transportPrice + ";";
    }

    /**
     * Method to create a new frequent client.
     */
    public void create() {
        super.createClient();

        setType("Frequent");
    }

    /**
     * Method to calculate the transport price that is going to be for a frequent client.
     */
    @Override
    public void transport() {
        transportPrice = furnitureTransport();

        int limitPrice = 40;
        if (getCarts().get(getCarts().size() - 1).getTotalPrice() < limitPrice) transportPrice += 15;

    }
}
