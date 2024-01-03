# Online-shopping-manager

## About
The aim of this project, was to develop an online sales application for a supermarket chain. The application allows you to perform certain operations, such as logging in, buying products and checking your cart.
It was written in Java, an object-oriented programming language, and thie [UML (class diagram)](doc/UML.pdf) was drawn up to structure the project.

## Application in detail
A client can be regular or frequent and is characterized by their name, address, email, phone number, and date of birth. Products are described by identifier, name, unit price and existing stock. There are three product categories: food, cleaning and furniture. Food products are additionally characterized by the number of calories and fat percentage, cleaning products have to consider the degree of toxicity (0-10) and for furniture products the weight and size.

In order to increase sales, the company runs temporary promotions, only associated with a single product. There are two types of promotion: PayThreeGetFour and PayLess. In the first, clients pay three out of every four items ordered. In the PayLess promotion a unit is paid 100%, with the cost decreasing by 5% for each additional unit, until a maximum discount of 50% of the total purchase value is reached.

For frequent clients, home delivery is free on purchases over 40€. Under this amount, transportation costs 15€. For all other clients, the cost is fixed at 20€. Furniture products over 15kg, have a transportation cost of 10€ and this applies to all clients.

There is also a text file containing data on regular clients, frequent clients, products and promotions. After the first launch of the application, all the data is saved in object files and loaded every time the application is started. To simplify testing the application, it is possible to change the current date.

## JavaDoc
Javadoc is a documentation generator created by Sun Microsystems to document the API of Java programs from source code. You can see all the documentation for each class of this project by opening the [JavaDoc Index File](JavaDoc/index.html)

## How to use
In the main folder of the project run the following commands:

```sh
javac -d out src/projeto/*.java
```

```sh
cd out/
```

```sh
java projeto.OnlineShop
```

## Requirements
[Java](https://www.oracle.com/java/technologies/downloads/)

## License
Distributed under the MIT License. See [LICENSE](LICENSE) for more information.