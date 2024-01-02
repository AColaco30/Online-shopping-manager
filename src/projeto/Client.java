// Class done by: André Colaço, 2020220301 and Lino Varela, 2020220433.

package projeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Abstract class that contains a client.
 */
public abstract class Client implements Serializable {

    /**
     * Client name.
     */
    private String name;

    /**
     * Client address.
     */
    private String address;

    /**
     * Client email.
     */
    private String email;

    /**
     * Client phone number.
     */
    private int phone;

    /**
     * Client birthday.
     */
    private Date birthday;

    /**
     * Type of client.
     */
    private String type;

    /**
     * Several carts for each client.
     */
    private ArrayList<Cart> carts;

    /**
     * Constructor without param.
     */
    public Client() {
    }

    /**
     * Constructor with all param.
     *
     * @param name     client name.
     * @param address  client address.
     * @param email    client email.
     * @param phone    client phone number.
     * @param birthday client date of birth.
     * @param type     type of client.
     */
    public Client(String name, String address, String email, int phone, Date birthday, String type) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.type = type;
        carts = new ArrayList<>();
    }

    /**
     * Getter.
     *
     * @return name of client
     */
    public String getName() {
        return name;
    }

    /**
     * Setter.
     *
     * @param name client name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter.
     *
     * @return client address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter.
     *
     * @param address client address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter.
     *
     * @return client email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter.
     *
     * @param email client address.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter.
     *
     * @return client phone number.
     */
    public int getPhone() {
        return phone;
    }

    /**
     * Setter.
     *
     * @param phone client phone number.
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    /**
     * Getter.
     *
     * @return client birthday.
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * Setter.
     *
     * @param birthday client birthday.
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * Getter.
     *
     * @return type of client.
     */
    public String getType() {
        return type;
    }

    /**
     * Setter.
     *
     * @param type type of client.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Getter.
     *
     * @return client carts
     */
    public ArrayList<Cart> getCarts() {
        return carts;
    }

    /**
     * Setter.
     *
     * @param carts client carts.
     */
    public void setCarts(ArrayList<Cart> carts) {
        this.carts = carts;
    }

    /**
     * ToString.
     *
     * @return description of client.
     */
    @Override
    public String toString() {
        return "Client -> " + "name: " + name + ", address: " + address + ", email: " + email + ", phone: " + phone + ", birthday: " + birthday + ", cart: " + carts + ";";
    }

    /**
     * Method to create a new client.
     */
    public void createClient() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Write your email: ");
        setEmail(sc.nextLine());

        System.out.print("Write your name: ");
        setName(sc.nextLine());

        System.out.print("Write your address: ");
        setAddress(sc.nextLine());

        OnlineShop os = new OnlineShop();

        System.out.print("Write your phone: ");
        setPhone(os.readInt());

        System.out.println("Write your birthday: ");
        // Create a new date.
        Date d = new Date();
        d.newDate();
        setBirthday(d);
    }

    /**
     * Method to add cart to ArrayList.
     *
     * @param cart client cart.
     */
    public void addCart(Cart cart) {
        carts.add(cart);
    }

    /**
     * Method used in the Subclasses.
     */
    public abstract void transport();

    /**
     * Method to calculate the transport of the furniture.
     *
     * @return price of furnitureTransport.
     */
    public double furnitureTransport() {
        double maxWeight = 0;

        //Goes through the purchases to check the weight of the furniture's.
        for (Purchase p : getCarts().get(getCarts().size() - 1).getPurchases()) {
            // Checks if it is a furniture product.
            if (21 <= p.getProduct().getIdentifier() && p.getProduct().getIdentifier() <= 30) {
                Furniture f = (Furniture) p.getProduct();
                maxWeight += f.getWeight() * p.getQuantity();
            }
        }

        if (maxWeight > 15) return 10;
        else return 0;
    }
}
