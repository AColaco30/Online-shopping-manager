// Class done by: André Colaço, 2020220301 and Lino Varela, 2020220433.

package projeto;

import java.io.Serializable;

/**
 * Class that contains a purchase.
 */
public class Purchase implements Serializable {

    /**
     * Product ur buying.
     */
    private Product product;

    /**
     * Quantity ur buying.
     */
    private int quantity;

    /**
     * Constructor with all param.
     *
     * @param product  product you're buying.
     * @param quantity product quantity you're buying.
     */
    public Purchase(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Getter.
     *
     * @return product.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Setter.
     *
     * @param product product.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Getter.
     *
     * @return quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter.
     *
     * @param quantity quantity.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * ToString.
     *
     * @return description of a purchase.
     */
    @Override
    public String toString() {
        return "name: " + product.getName() + ", price: " + product.getPrice() + ", quantity: " + quantity;
    }

    /**
     * Method to buy a product.
     *
     * @param cart cart where we are adding the purchase.
     * @param p    purchase.
     */
    public void buy(Cart cart, Purchase p) {
        // If the quantity is less or equal than the stock.
        if (checkStock()) {
            product.setStock(product.getStock() - quantity);

        } else {
            // Otherwise, we assume that the quantity is equal to the stock.
            this.quantity = product.getStock();
            product.setStock(0);
        }

        cart.addPurchase(p);
    }

    /**
     * Method to check if the quantity is less or equal than the stock.
     *
     * @return true if the quantity is less or equal than the stock, false otherwise.
     */
    private boolean checkStock() {
        return this.quantity <= this.product.getStock();
    }
}
