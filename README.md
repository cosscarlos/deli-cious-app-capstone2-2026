# Deli-cious App 🥪

## Description
The **Deli-cious App** is a console-based Java application designed to manage custom sandwich orders. The system allows users to build personalized sandwiches (selecting bread, size, meats, cheeses, vegetables, and sauces), add drinks and sides (chips), and generate a detailed receipt with the exact cost based on the size and ingredients selected.

This project was developed as part of my **Computer Science Engineering** coursework and the **Year Up United** program, applying robust Object-Oriented Programming (OOP) principles.

## Key Features
* **Dynamic Customization:** Premium ingredient selection with pricing logic based on sandwich size (4", 8", or 12").
* **Accurate Calculation:** Advanced pricing logic that transparently sums base costs and extra charges, modeling ingredients as objects to ensure financial accuracy.
* **Robust UI:** Interactive menu with user input validation to prevent runtime errors.
* **Persistence:** Automatic generation of receipts in `.txt` format with a full breakdown of the purchase.
* **Scalable Design:** Use of interfaces and dynamic data structures to manage orders professionally.

## Technologies Used
* **Language:** Java 17
* **Tools:** IntelliJ IDEA
* **Version Control:** Git & GitHub

## Project Structure
The application follows an organized architecture to separate concerns:
* `com.pluralsight.model`: Contains business logic classes (Sandwich, Drink, Chips, Ingredient).
* `com.pluralsight.finance`: Handles pricing logic and receipt export.
* `com.pluralsight.ui`: Manages user interaction and input validation.



## How to Run
1. Ensure you have **JDK 17** or higher installed.
2. Clone this repository:
   ```bash
   git clone [https://github.com/your-username/deli-cious-app.git](https://github.com/your-username/deli-cious-app.git)
