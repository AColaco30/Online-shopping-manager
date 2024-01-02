// Class done by: André Colaço, 2020220301 and Lino Varela, 2020220433.

package projeto;

import java.io.Serializable;

/**
 * Abstract superclass that contains a promotion.
 */
public abstract class Promotion implements Serializable {

    /**
     * Product that has a promotion.
     */
    private Product product;

    /**
     * Promotion start date.
     */
    private Date startDate;

    /**
     * Promotion finish date.
     */
    private Date finishDate;

    /**
     * Type of promotion.
     */
    private String type;

    /**
     * Constructor with all param.
     *
     * @param product    product with its attributes.
     * @param startDate  start date for the promotion.
     * @param finishDate finish date for the promotion.
     * @param type       type of promotion.
     */
    public Promotion(Product product, Date startDate, Date finishDate, String type) {
        this.product = product;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.type = type;
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
     * @return start date.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Setter.
     *
     * @param startDate start date.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Getter.
     *
     * @return finish date.
     */
    public Date getFinishDate() {
        return finishDate;
    }

    /**
     * Setter.
     *
     * @param finishDate finish date.
     */
    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    /**
     * Getter.
     *
     * @return promotion type.
     */
    public String getType() {
        return type;
    }

    /**
     * Setter.
     *
     * @param type promotion type.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * ToString.
     *
     * @return description of a promotion.
     */
    @Override
    public String toString() {
        return "-> " + "product: " + product.getName() + ", startDate: " + startDate + ", finishDate: " + finishDate + ";";
    }

    /**
     * Abstract method used in the subclasses.
     *
     * @param quantity product quantity you're buying.
     */
    public abstract void discount(int quantity);
}
