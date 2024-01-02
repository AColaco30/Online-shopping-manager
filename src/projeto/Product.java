// Class done by: André Colaço, 2020220301 and Lino Varela, 2020220433.

package projeto;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Abstract superclass that contains a product.
 */
public abstract class Product implements Serializable {

    /**
     * Product name.
     */
    private String name;

    /**
     * Product identifier.
     * Between 1 and 10 -> food;
     * Between 11 and 20 -> cleaning;
     * Between 21 and 30 -> furniture;
     */
    private int identifier;

    /**
     * Product stock.
     */
    private int stock;

    /**
     * Product price.
     */
    private double price;

    /**
     * Promotion of the product.
     */
    private Promotion promotion;

    /**
     * Constructor without param.
     */
    public Product() {
    }

    /**
     * Constructor with all param.
     *
     * @param name       name of the product.
     * @param identifier number to identify product.
     * @param stock      product stock number.
     * @param price      price of the product.
     */
    public Product(String name, int identifier, int stock, double price) {
        this.name = name;
        this.identifier = identifier;
        this.stock = stock;
        this.price = price;
    }

    /**
     * Getter.
     *
     * @return product name.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter.
     *
     * @param name product name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter.
     *
     * @return product identifier.
     */
    public int getIdentifier() {
        return identifier;
    }

    /**
     * Setter.
     *
     * @param identifier product identifier.
     */
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    /**
     * Getter.
     *
     * @return product stock.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Setter.
     *
     * @param stock product stock.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Getter.
     *
     * @return product price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter.
     *
     * @param price product price.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getter.
     *
     * @return promotion.
     */
    public Promotion getPromotion() {
        return promotion;
    }

    /**
     * Setter.
     *
     * @param promotion promotion.
     */
    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    /**
     * ToString.
     *
     * @return description of the product.
     */
    @Override
    public String toString() {
        return "-> " + "name: " + name + ", stock: " + stock + ", price: " + price + ", ";
    }

    /**
     * Method to create a new product.
     *
     * @param b number that differs the product type.
     */
    public void createProduct(int b) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Write the name: ");
        setName(sc.nextLine());

        OnlineShop os = new OnlineShop();
        System.out.print("Write the identifier (food between 1 and 10, cleaning between 11 and 20, furniture between 21 and 30): ");
        if (b == 0) {
            setIdentifier(checkIdentifier(1, 10));
        } else if (b == 1) {
            setIdentifier(checkIdentifier(11, 20));
        } else if (b == 2) {
            setIdentifier(checkIdentifier(21, 30));
        }

        System.out.print("Write the stock: ");
        setStock(checkStock());

        System.out.print("Write the price: ");
        setPrice(os.readDouble());
    }

    /**
     * Method to ask the user the identifier and check if it is between the limits.
     *
     * @param lim1 inferior limit.
     * @param lim2 superior limit.
     * @return the identifier.
     */
    private int checkIdentifier(int lim1, int lim2) {
        OnlineShop os = new OnlineShop();

        int id;
        do {
            id = os.readInt();
            if (id < lim1 || id > lim2) System.out.print("Invalid identifier! Try another: ");
        } while (id < lim1 || id > lim2);

        return id;
    }

    /**
     * Method to ask the user the stock and check if it is greater than zero.
     *
     * @return stock.
     */
    private int checkStock() {
        OnlineShop os = new OnlineShop();

        int num;
        do {
            num = os.readInt();
            if (num < 1) System.out.print("Invalid stock! Try another: ");
        } while (num < 1);

        return num;
    }
}
