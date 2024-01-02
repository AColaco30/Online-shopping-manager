// Class done by: André Colaço, 2020220301 and Lino Varela, 2020220433.

package projeto;

/**
 * Subclass that contains a furniture product.
 */
public class Furniture extends Product {

    /**
     * Furniture height.
     */
    private double height;

    /**
     * Furniture length.
     */
    private double length;

    /**
     * Furniture depth.
     */
    private double depth;

    /**
     * Furniture weight.
     */
    private double weight;

    /**
     * Constructor without param.
     */
    public Furniture() {
        super();
    }

    /**
     * Constructor with all param.
     *
     * @param name       name of the product.
     * @param identifier number to identify product.
     * @param stock      product stock number.
     * @param price      price of the product.
     * @param height     furniture product height.
     * @param length     furniture product length.
     * @param depth      furniture product depth.
     * @param weight     furniture product weight.
     */
    public Furniture(String name, int identifier, int stock, double price, double height, double length, double depth, double weight) {
        super(name, identifier, stock, price);
        this.height = height;
        this.length = length;
        this.depth = depth;
        this.weight = weight;
    }

    /**
     * Getter.
     *
     * @return height.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Setter.
     *
     * @param height height.
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Getter.
     *
     * @return length.
     */
    public double getLength() {
        return length;
    }

    /**
     * Setter.
     *
     * @param length length.
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Getter.
     *
     * @return depth.
     */
    public double getDepth() {
        return depth;
    }

    /**
     * Setter.
     *
     * @param depth depth.
     */
    public void setDepth(double depth) {
        this.depth = depth;
    }

    /**
     * Getter.
     *
     * @return weight.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Setter.
     *
     * @param weight weight.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * ToString.
     *
     * @return description of a furniture product.
     */
    @Override
    public String toString() {
        return "Furniture " + super.toString() + "height: " + height + ", length: " + length + ", depth: " + depth + ", weight: " + weight + ";";
    }

    /**
     * Method to create a new furniture.
     *
     * @param b number that differs the product type.
     */
    public void create(int b) {
        //Method in the Superclass to create a new product.
        super.createProduct(b);

        OnlineShop os = new OnlineShop();

        //Adding furniture attributes.

        System.out.print("Write the height: ");
        setHeight(os.readDouble());

        System.out.print("Write the length: ");
        setLength(os.readDouble());

        System.out.print("Write the depth: ");
        setDepth(os.readDouble());

        System.out.print("Write the weight: ");
        setWeight(os.readDouble());
    }
}
