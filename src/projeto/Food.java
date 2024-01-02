// Class done by: André Colaço, 2020220301 and Lino Varela, 2020220433.

package projeto;

/**
 * Subclass that contains a food product.
 */
public class Food extends Product {

    /**
     * Food fat percentage.
     */
    private double fatPercentage;

    /**
     * Food calories.
     */
    private double calories;

    /**
     * Constructor without param.
     */
    public Food() {
        super();
    }

    /**
     * Constructor with all param.
     *
     * @param name          name of the product.
     * @param identifier    number to identify product.
     * @param stock         product stock number.
     * @param price         price of the product.
     * @param fatPercentage fat percentage of the Food.
     * @param calories      calories of the Food.
     */
    public Food(String name, int identifier, int stock, double price, double fatPercentage, double calories) {
        super(name, identifier, stock, price);
        this.fatPercentage = fatPercentage;
        this.calories = calories;
    }

    /**
     * Getter.
     *
     * @return fat percentage.
     */
    public double getFatPercentage() {
        return fatPercentage;
    }

    /**
     * Setter.
     *
     * @param fatPercentage fat percentage.
     */
    public void setFatPercentage(double fatPercentage) {
        this.fatPercentage = fatPercentage;
    }

    /**
     * Getter.
     *
     * @return calories.
     */
    public double getCalories() {
        return calories;
    }

    /**
     * Setter.
     *
     * @param calories calories.
     */
    public void setCalories(double calories) {
        this.calories = calories;
    }

    /**
     * ToString.
     *
     * @return food description.
     */
    @Override
    public String toString() {
        return "Food " + super.toString() + "fatPercentage: " + fatPercentage + ", calories: " + calories + ";";
    }

    /**
     * Method to create a new food.
     *
     * @param b number that differs the product type.
     */
    public void create(int b) {
        //Method in the Superclass to create a new product.
        super.createProduct(b);

        OnlineShop os = new OnlineShop();

        //Adding food attributes.

        System.out.print("Write the fat percentage: ");
        setFatPercentage(os.readDouble());

        System.out.print("Write the calories: ");
        setCalories(os.readDouble());
    }
}
