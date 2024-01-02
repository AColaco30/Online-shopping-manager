// Class done by: André Colaço, 2020220301 and Lino Varela, 2020220433.

package projeto;

import java.io.*;
import java.util.ArrayList;

/**
 * Class that contains methods to use in a file.
 */
public class Files {

    /**
     * File name.
     */
    private String name;

    /**
     * Constructor with the param.
     *
     * @param name name of file.
     */
    public Files(String name) {
        this.name = name;
    }

    /**
     * Getter.
     *
     * @return file name.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter.
     *
     * @param name file name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ToString.
     *
     * @return description of the file.
     */
    @Override
    public String toString() {
        return "Files -> " + "nome: " + name + ";";
    }

    /**
     * Method to read text files.
     */
    public void readTextFile() {
        File f = new File(name + ".txt");

        // Initialize ArrayLists.
        ArrayList<Frequent> frequents = new ArrayList<>();
        ArrayList<Regular> regulars = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Promotion> promotions = new ArrayList<>();

        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);

                String line;
                // Parsing through the text file.
                while ((line = br.readLine()) != null) {
                    parseLine(line, frequents, regulars, products, promotions);
                }

                br.close();
                fr.close();

                //Write ArrayLists in Object file
                writeObjFile(frequents, regulars, products, promotions);

            } catch (FileNotFoundException e) {
                System.out.println("Erro a abrir o ficheiro de texto!");
            } catch (IOException e) {
                System.out.println("Erro a ler o ficheiro de texto!");
            }

        } else System.out.println("Ficheiro de texto nao existe!");
    }

    /**
     * Method to read line and separate the information in it.
     *
     * @param line       line in the file.
     * @param frequents  arrayList of frequent clients.
     * @param regulars   arrayList of regular Clients.
     * @param products   arrayList of products.
     * @param promotions arrayList of promotions.
     */
    private void parseLine(String line, ArrayList<Frequent> frequents, ArrayList<Regular> regulars, ArrayList<Product> products, ArrayList<Promotion> promotions) {
        // Split line.
        String[] lineSplit = line.split("\\+");

        // For each case, adds the information for its respective arrayList.
        // The first part of the line, will decide what kind of information is in the line and where it has to go.
        switch (lineSplit[0]) {
            case "Frequent" -> {
                // Get date in the line.
                String[] dateSplit = lineSplit[5].split("/");
                Date d = new Date(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[2]));

                // Create new Frequent Client.
                Frequent f = new Frequent(lineSplit[1], lineSplit[2], lineSplit[3], Integer.parseInt(lineSplit[4]), d);
                frequents.add(f);
            }
            case "Regular" -> {
                // Get date in the line.
                String[] dateSplit = lineSplit[5].split("/");
                Date d = new Date(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[2]));

                // Create new Regular Client.
                Regular r = new Regular(lineSplit[1], lineSplit[2], lineSplit[3], Integer.parseInt(lineSplit[4]), d);
                regulars.add(r);
            }
            case "Food" -> {
                // Create new food product.
                Food f = new Food(lineSplit[1], Integer.parseInt(lineSplit[2]), Integer.parseInt(lineSplit[3]), Double.parseDouble(lineSplit[4]), Double.parseDouble(lineSplit[5]), Double.parseDouble(lineSplit[6]));
                products.add(f);
            }
            case "Cleaning" -> {
                // Create new cleaning product.
                Cleaning c = new Cleaning(lineSplit[1], Integer.parseInt(lineSplit[2]), Integer.parseInt(lineSplit[3]), Double.parseDouble(lineSplit[4]), Integer.parseInt(lineSplit[5]));
                products.add(c);
            }
            case "Furniture" -> {
                // Create new furniture product.
                Furniture f = new Furniture(lineSplit[1], Integer.parseInt(lineSplit[2]), Integer.parseInt(lineSplit[3]), Double.parseDouble(lineSplit[4]), Double.parseDouble(lineSplit[5]), Double.parseDouble(lineSplit[6]), Double.parseDouble(lineSplit[7]), Double.parseDouble(lineSplit[8]));
                products.add(f);
            }
            case "Pay3Get4" -> {
                //Get dates (start and finish).
                String[] date1Split = lineSplit[2].split("/");
                Date date1 = new Date(Integer.parseInt(date1Split[0]), Integer.parseInt(date1Split[1]), Integer.parseInt(date1Split[2]));

                String[] date2Split = lineSplit[3].split("/");
                Date date2 = new Date(Integer.parseInt(date2Split[0]), Integer.parseInt(date2Split[1]), Integer.parseInt(date2Split[2]));

                // Checks if the product name in the line is in the arrayList of products.
                for (Product pro : products) {
                    if (pro.getName().equals(lineSplit[1])) {
                        // Create a new PayThreeGetFour promotion.
                        PayThreeGetFour p = new PayThreeGetFour(pro, date1, date2);
                        promotions.add(p);
                        break;
                    }
                }
            }
            case "PayLess" -> {
                //Get dates (start and finish).
                String[] date1Split = lineSplit[2].split("/");
                Date date1 = new Date(Integer.parseInt(date1Split[0]), Integer.parseInt(date1Split[1]), Integer.parseInt(date1Split[2]));

                String[] date2Split = lineSplit[3].split("/");
                Date date2 = new Date(Integer.parseInt(date2Split[0]), Integer.parseInt(date2Split[1]), Integer.parseInt(date2Split[2]));

                // Checks if the product name in the line is in the arrayList of products.
                for (Product pro : products) {
                    if (pro.getName().equals(lineSplit[1])) {
                        // Create a new PayLess promotion.
                        PayLess p = new PayLess(pro, date1, date2);
                        promotions.add(p);
                        break;
                    }
                }
            }
        }
    }

    /**
     * Method to write the ArrayLists on Object file.
     *
     * @param frequents  arrayList of frequent clients.
     * @param regulars   arrayList of regular Clients.
     * @param products   arrayList of products.
     * @param promotions arrayList of promotions.
     */
    public void writeObjFile(ArrayList<Frequent> frequents, ArrayList<Regular> regulars, ArrayList<Product> products, ArrayList<Promotion> promotions) {
        File f = new File(name + ".obj");

        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(frequents);
            oos.writeObject(regulars);
            oos.writeObject(products);
            oos.writeObject(promotions);


            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("Erro a escrever no ficheiro de objeto!");
        }
    }
}
