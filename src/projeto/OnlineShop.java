// Work done by: André Colaço, 2020220301 and Lino Varela, 2020220433.

package projeto;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class that contains an online shop.
 */
public class OnlineShop {

    /**
     * ArrayList with frequent clients.
     */
    ArrayList<Frequent> frequentClients;

    /**
     * ArrayList with regular clients.
     */
    ArrayList<Regular> regularClients;

    /**
     * ArrayList with the products.
     */
    ArrayList<Product> products;

    /**
     * ArrayList with the promotions.
     */
    ArrayList<Promotion> promotions;

    /**
     * Constructor without param.
     */
    public OnlineShop() {
        frequentClients = new ArrayList<>();
        regularClients = new ArrayList<>();
        products = new ArrayList<>();
        promotions = new ArrayList<>();
    }

    /**
     * Main static method.
     *
     * @param args args.
     */
    public static void main(String[] args) {
        OnlineShop shop = new OnlineShop();
        shop.start("Information");
    }

    /**
     * Start of the program.
     *
     * @param name name of the file.
     */
    private void start(String name) {
        File f = new File(name + ".obj");

        // Checks if the object file exists.
        if (!f.exists()) {
            Files file = new Files(name);
            file.readTextFile();
        }

        readObjFile(name);

        Date date = new Date(9, 12, 2021);
        int i;

        do {
            update(name, date);

            System.out.println("\n(1)-Login.");
            System.out.println("(2)-Add a new client.");
            System.out.println("(3)-Change the date.");
            System.out.println("(4)-Admin.");
            System.out.println("(5)-Exit.");
            System.out.println("Current Date-" + date);
            System.out.print("Choose what you want to do by the number -> ");

            i = readInt();
            switch (i) {
                case 1 -> doLogin(date);
                case 2 -> addNewClient();
                case 3 -> changeDate(date);
                case 4 -> admin();
            }
        } while (i != 5);
    }

    /**
     * Method to read an object file.
     *
     * @param name name of the object file.
     */
    private void readObjFile(String name) {
        File f = new File(name + ".obj");

        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            // Save the content in the respective ArrayLists.
            frequentClients = (ArrayList<Frequent>) ois.readObject();
            regularClients = (ArrayList<Regular>) ois.readObject();
            products = (ArrayList<Product>) ois.readObject();
            promotions = (ArrayList<Promotion>) ois.readObject();

            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error opening object file!");
        } catch (IOException e) {
            System.out.println("Error reading object file!");
        } catch (ClassNotFoundException e) {
            System.out.println("Error converting object!");
        }
    }

    /**
     * Method to update the program by checking the available promotions on that date and re-writing to the object file.
     *
     * @param name name of the object file.
     * @param date date.
     */
    private void update(String name, Date date) {
        // Set the promotion in each product to null.
        for (Product prod : products) {
            prod.setPromotion(null);
        }

        // Checks if the promotion for each product is available on that date.
        for (Promotion promotion : promotions) {
            for (Product product : products) {
                if (promotion.getProduct() == product) {
                    if (date.dateComparation(promotion.getStartDate()) && promotion.getFinishDate().dateComparation(date)) {
                        product.setPromotion(promotion);
                        break;
                    }
                }
            }
        }

        // Re-write the ArrayLists to the object file.
        Files f1 = new Files(name);
        f1.writeObjFile(frequentClients, regularClients, products, promotions);
    }

    /**
     * Method to login.
     *
     * @param date date.
     */
    private void doLogin(Date date) {
        // Asks the user his email and checks if that client exists.
        Client client = null;
        while (client == null) {
            client = login();
            if (client == null) System.out.println("Client does not exists!");
        }

        // Create a new cart.
        Cart cart = new Cart();

        // Goes to the next part.
        afterLogin(client, cart, date);
    }

    /**
     * Method that ask the user his email to login.
     *
     * @return the client or null if the client does not exist.
     */
    private Client login() {
        Scanner sc = new Scanner(System.in);

        // Ask client email.
        System.out.print("Write your email -> ");
        String email = sc.nextLine();

        // Checks if that client exists.
        for (Frequent fre : frequentClients) {
            if (fre.getEmail().equals(email)) {
                System.out.println("Welcome " + fre.getName() + " (Frequent)");
                return fre;
            }
        }
        for (Regular reg : regularClients) {
            if (reg.getEmail().equals(email)) {
                System.out.println("Welcome " + reg.getName() + " (Regular)");
                return reg;
            }
        }
        return null;
    }

    /**
     * Method that presents the menu after the login.
     *
     * @param client client.
     * @param cart   cart.
     * @param date   date.
     */
    private void afterLogin(Client client, Cart cart, Date date) {
        int i;
        boolean checkBuy = false;

        do {
            System.out.println("\n(1)-View available products.");
            System.out.println("(2)-Buy a product.");
            System.out.println("(3)-Checkout.");
            System.out.print("Choose what you want to do by the number -> ");

            i = readInt();
            switch (i) {
                case 1 -> availableProducts(date);
                case 2 -> checkBuy = buyProduct(cart);
            }
        } while (i != 3);

        // It only shows the checkout if the client bought ate least one product.
        if (checkBuy) checkout(client, cart);
    }

    /**
     * Method to list the promotions and the products that are available.
     *
     * @param date date.
     */
    private void availableProducts(Date date) {
        System.out.println("\nPromotions:");

        // Checks if the product that has a promotion exist and if it does print the promotion.
        for (Promotion promo : promotions) {
            boolean checkPromo = false;
            for (Product product : products) {
                if (promo.getProduct() == product) {
                    checkPromo = true;
                    break;
                }
            }
            if (checkPromo && date.dateComparation(promo.getStartDate()) && promo.getFinishDate().dateComparation(date))
                System.out.println(promo);
        }

        int index = 0;
        System.out.println("\nProducts:");

        // Show the products that exists.
        for (Product pro : products) {
            System.out.println("(" + index + ")-" + pro);
            index++;
        }
    }

    /**
     * Method to buy a product.
     *
     * @param cart cart.
     * @return true.
     */
    private boolean buyProduct(Cart cart) {
        int i = products.size();

        // Asks the user the product he wants to buy and checks if it is correct.
        while (i >= products.size() || i < 0) {
            System.out.print("Choose what you want to buy by the number -> ");
            i = readInt();
        }

        System.out.print("Choose the amount you want to buy -> ");
        int quantity = readInt();

        // New purchase.
        Purchase p = new Purchase(products.get(i), quantity);

        // Buy the product and add to the cart.
        p.buy(cart, p);

        // If the stock of the product is less or equal to zero, than remove from the list.
        if (products.get(i).getStock() <= 0) products.remove(i);

        return true;
    }

    /**
     * Method to do the checkout.
     *
     * @param client client.
     * @param cart   cart.
     */
    private void checkout(Client client, Cart cart) {
        // Add the cart to the client.
        client.addCart(cart);

        // Calculate the transport price.
        client.transport();

        if (client.getType().equals("Frequent")) {
            Frequent freClient = (Frequent) client;

            // Add to the total price of the cart, the transport price.
            freClient.getCarts().get(freClient.getCarts().size() - 1).addTotalPrice(freClient.getTransportPrice());

            // Prints the cart with the transport price included.
            System.out.println("\n" + cart + "with the transport price included: " + freClient.getTransportPrice() + ";\n");

        } else if (client.getType().equals("Regular")) {
            Regular regClient = (Regular) client;

            // Add to the total price of the cart, the transport price.
            regClient.getCarts().get(regClient.getCarts().size() - 1).addTotalPrice(regClient.getTransportPrice());

            // Prints the cart with the transport price included.
            System.out.println("\n" + cart + "with the transport price included: " + regClient.getTransportPrice() + ";\n");
        }
    }

    /**
     * Method to add a new client.
     */
    private void addNewClient() {
        // Asks the user what type of client he is.
        System.out.print("\nFrequent client(0) or regular client(1): ");
        while (true) {
            int a = readInt();
            if (a == 0) {
                Frequent frequent = new Frequent();

                // Create a new frequent client.
                frequent.create();
                // Add to the ArrayList.
                frequentClients.add(frequent);
                break;
            } else if (a == 1) {
                Regular regular = new Regular();

                // Create a new regular client.
                regular.create();
                // Add to the ArrayList.
                regularClients.add(regular);
                break;
            }
        }
    }

    /**
     * Method to change the date.
     *
     * @param date date.
     */
    private void changeDate(Date date) {
        // Ask the user a new date.
        date.newDate();

        // Checks if the date is valid.
        while (!date.checkDate()) {
            System.out.println("Invalid date! Try another:");
            date.newDate();
        }
    }

    /**
     * Method that contains especial methods (add a product and a promotion).
     */
    private void admin() {
        int a;

        do {
            System.out.println("\n(1)-Add a product.");
            System.out.println("(2)-Add a promotion.");
            System.out.println("(3)-Exit.");
            System.out.print("Choose what you want to do by the number -> ");

            a = readInt();
            switch (a) {
                case 1 -> addProduct();
                case 2 -> addPromotion();
            }
        } while (a != 3);

    }

    /**
     * Method to add a new product.
     */
    private void addProduct() {
        System.out.print("\nFood (0), Cleaning(1), Furniture(2): ");
        while (true) {
            int b = readInt();
            if (b == 0) {
                Food f = new Food();
                f.create(b);
                products.add(f);
                break;

            } else if (b == 1) {
                Cleaning c = new Cleaning();
                c.create(b);
                products.add(c);
                break;

            } else if (b == 2) {
                Furniture f = new Furniture();
                f.create(b);
                products.add(f);
                break;
            }
            System.out.print("Invalid number! Try another: ");
        }
    }

    /**
     * Method to add a new promotion.
     */
    private void addPromotion() {
        int i = 0;

        System.out.println();

        // Shows the products that don't have a promotion, so that the user can add a promotion to that product.
        for (Product product : products) {
            boolean check = false;
            for (Promotion promotion : promotions)
                if (product == promotion.getProduct()) {
                    check = true;
                    break;
                }
            if (!check) System.out.println("(" + i + ")-" + product);
            i++;
        }

        System.out.print("Choose the product: ");
        Product p;

        // Ask the user the product.
        while (true) {
            int a = readInt();
            if (a >= 0 && a <= products.size() - 1) {
                p = products.get(a);
                break;
            }
        }

        System.out.print("\nPay three get four (0), Pay less (1): ");
        while (true) {
            int b = readInt();
            if (b == 0) {
                // Aks the start date.
                Date startDate = new Date();
                System.out.println("Write the start date:");
                startDate.newDate();

                // Aks the finish date.
                Date finishDate = new Date();
                System.out.println("Write the finish date:");
                finishDate.newDate();

                PayThreeGetFour pro = new PayThreeGetFour(p, startDate, finishDate);
                promotions.add(pro);
                break;
            } else if (b == 1) {
                // Aks the start date.
                Date startDate = new Date();
                System.out.println("Write the start date:");
                startDate.newDate();

                // Aks the finish date.
                Date finishDate = new Date();
                System.out.println("Write the finish date:");
                finishDate.newDate();

                PayLess pro = new PayLess(p, startDate, finishDate);
                promotions.add(pro);
                break;
            }
        }
    }

    /**
     * Method to ask the user an integer and checks for exceptions.
     *
     * @return number that the user wrote.
     */
    public int readInt() {
        int num;

        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                num = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.print("Invalid number! Try another: ");
            }
        }

        return num;
    }

    /**
     * Method to ask the user a double and checks for exceptions.
     *
     * @return number that the user wrote.
     */
    public double readDouble() {
        double num;

        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                num = sc.nextDouble();
                break;
            } catch (Exception e) {
                System.out.print("Invalid number! Try another: ");
            }
        }

        return num;
    }
}