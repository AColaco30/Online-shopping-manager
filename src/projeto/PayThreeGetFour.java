// Class done by: André Colaço, 2020220301 and Lino Varela, 2020220433.

package projeto;

/**
 * Subclass that contains a PayThreeGetFour promotion.
 */
public class PayThreeGetFour extends Promotion {

    /**
     * Price with the discount.
     */
    private double discountPrice;

    /**
     * Constructor with all param.
     *
     * @param product    product.
     * @param startDate  start date of the promotion.
     * @param finishDate finish date of the promotion.
     */
    public PayThreeGetFour(Product product, Date startDate, Date finishDate) {
        super(product, startDate, finishDate, "Pay3Get4");
        this.discountPrice = 0;
    }

    /**
     * Getter.
     *
     * @return price with discount.
     */
    public double getDiscountPrice() {
        return discountPrice;
    }

    /**
     * Setter.
     *
     * @param discountPrice price with discount.
     */
    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    /**
     * ToString.
     *
     * @return description of a PauThreeGetFour promotion.
     */
    @Override
    public String toString() {
        return "PayThreeGetFour " + super.toString();
    }

    /**
     * Method to calculate the price with the discount.
     *
     * @param quantity product quantity you buying.
     */
    @Override
    public void discount(int quantity) {
        int division = quantity / 4;
        int rest = quantity - (division * 4);

        discountPrice = (3 * division * getProduct().getPrice() + (rest * getProduct().getPrice()));
    }
}
