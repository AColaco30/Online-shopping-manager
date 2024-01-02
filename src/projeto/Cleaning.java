// Class done by: André Colaço, 2020220301 and Lino Varela, 2020220433.

package projeto;

/**
 * Subclass that contains a cleaning product.
 */
public class Cleaning extends Product {

    /**
     * Toxicity degree (between 0-10).
     */
    private int toxicityDegree;

    /**
     * Constructor without param.
     */
    public Cleaning() {
        super();
    }

    /**
     * Constructor with all param.
     *
     * @param name           name of the product.
     * @param identifier     number to identify product.
     * @param stock          product stock number.
     * @param price          price of the product.
     * @param toxicityDegree product degree of toxicity.
     */
    public Cleaning(String name, int identifier, int stock, double price, int toxicityDegree) {
        super(name, identifier, stock, price);
        this.toxicityDegree = toxicityDegree;
    }

    /**
     * Getter.
     *
     * @return toxicityDegree product degree of toxicity.
     */
    public int getToxicityDegree() {
        return toxicityDegree;
    }

    /**
     * Setter.
     *
     * @param toxicityDegree value between 0 and 10.
     */
    public void setToxicityDegree(int toxicityDegree) {
        this.toxicityDegree = toxicityDegree;
    }

    /**
     * ToString.
     *
     * @return cleaning product description.
     */
    @Override
    public String toString() {
        return "Cleaning " + super.toString() + "toxicityDegree: " + toxicityDegree + ";";
    }

    /**
     * Method to create a cleaning product.
     *
     * @param b number that differs the product type.
     */
    public void create(int b) {
        //Method in the Superclass to create a new product.
        super.createProduct(b);

        OnlineShop os = new OnlineShop();

        //Adding Cleaning attribute.

        System.out.print("Write the toxicity degree: ");
        setToxicityDegree(os.readInt());
    }
}
