// Class done by: André Colaço, 2020220301 and Lino Varela, 2020220433.

package projeto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class that contains the purchases and the total price.
 */
public class Cart implements Serializable {

    /**
     * ArrayList with all the purchases.
     */
    private ArrayList<Purchase> purchases;

    /**
     * Total price of the cart.
     */
    private double totalPrice;

    /**
     * Constructor without param.
     */
    public Cart() {
        this.purchases = new ArrayList<>();
        this.totalPrice = 0;
    }

    /**
     * Getter.
     *
     * @return cart´s purchases.
     */
    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }

    /**
     * Setter.
     *
     * @param purchases cart´s purchases.
     */
    public void setPurchases(ArrayList<Purchase> purchases) {
        this.purchases = purchases;
    }

    /**
     * Getter.
     *
     * @return cart´s total price.
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Setter.
     *
     * @param totalPrice cart´s total price.
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * ToString.
     *
     * @return Description of Cart with the purchases and total price.
     */
    @Override
    public String toString() {
        return "Cart: \n" + purchases + "\nTotalPrice:" + totalPrice + ", ";
    }

    /**
     * Add to the total price, the param.
     *
     * @param price price you want to add.
     */
    public void addTotalPrice(double price) {
        this.totalPrice += price;
    }

    /**
     * Method to add a purchase with the respective promotion if it exists.
     *
     * @param p purchase.
     */
    public void addPurchase(Purchase p) {
        purchases.add(p);

        // Checks if it has promotion.
        if (p.getProduct().getPromotion() != null) {
            Promotion prom = p.getProduct().getPromotion();
            // Calculate the price with discount.
            prom.discount(p.getQuantity());

            // Verify the promotion and add the price to the total price.
            if (prom.getType().equals("Pay3Get4")) addTotalPrice(((PayThreeGetFour) prom).getDiscountPrice());
            else if (prom.getType().equals("PayLess")) addTotalPrice((((PayLess) prom).getDiscountPrice()));

        } else addTotalPrice(p.getQuantity() * p.getProduct().getPrice());
    }
}
