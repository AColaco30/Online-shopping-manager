// Class done by: André Colaço, 2020220301 and Lino Varela, 2020220433.

package projeto;

/**
 * Subclass that contains a PayLess promotion.
 */
public class PayLess extends Promotion {

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
    public PayLess(Product product, Date startDate, Date finishDate) {
        super(product, startDate, finishDate, "PayLess");
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
     * @return description of a PayLess promotion.
     */
    @Override
    public String toString() {
        return "PayLess " + super.toString();
    }

    /**
     * Method to calculate the price with the discount.
     *
     * @param quantity product quantity you buying.
     */
    @Override
    public void discount(int quantity) {
        discountPrice = 0;
        double percentage = 1;

        for (int i = 0; i < quantity; i++) {
            discountPrice += getProduct().getPrice() * percentage;

            if (percentage > 0.5) percentage -= 0.05;
        }
    }
}
