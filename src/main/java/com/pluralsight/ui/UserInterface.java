package com.pluralsight.ui;


import com.pluralsight.finance.Order;
import com.pluralsight.model.Chips;
import com.pluralsight.model.Drink;
import com.pluralsight.model.Sandwich;

import java.util.Scanner;

public class UserInterface {
    private Scanner theScanner = new Scanner(System.in);

    public void display() {
        boolean running = true;
        Order myOrder = new Order();

        while (running) {
            System.out.println("\n╔══════════════════════════════════╗");
            System.out.println("║       Deli-cious Restaurant \uD83D\uDC4D   ║");
            System.out.println("╠══════════════════════════════════╣");
            System.out.println("║  1. [New Order]                  ║");
            System.out.println("║  0. [Exit Application]           ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.print("  >> Select an option: ");
            String option = theScanner.nextLine();

            switch (option) {
                case "1" -> {

                    order(myOrder);
                }
                case "0" -> {
                    running = false;
                    System.out.println("Thank you, goodbye!");
                }
               default -> System.out.println("Error: Option not valid, try again. ");
            }
        }
    }


    public void order(Order order){
        boolean ordering = true;
        while (ordering){

            System.out.println("\n╔══════════════════════════════════╗");
            System.out.println("║         ORDERING CENTER          ║");
            System.out.println("╠══════════════════════════════════╣");
            System.out.println("║  1. Add Sandwich                 ║");
            System.out.println("║  2. Add Drink                    ║");
            System.out.println("║  3. Add Chips                    ║");
            System.out.println("║  4. Checkout                     ║");
            System.out.println("║  0. Back to Main Menu            ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.print("  >> Please select an option: ");
        String option = theScanner.nextLine();

        switch (option) {
            case "1" -> addSandwichToOrder(order);
            case "2" -> addDrinkToOrder(order);
            case "3" -> addChipsToOrder(order);
            case "4" -> {
                Checkout(order);
                ordering = false;
            }

            case "0" -> ordering = false;
        }
        }




    }

    //order menu
    public void addSandwichToOrder(Order order){


        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║         --- BUILDING YOUR SANDWICH ---       ║");
        System.out.println("╚══════════════════════════════════════════════╝");

        System.out.println("Bread options: [White, Wheat, Rye, Wrap]");
        System.out.print("  >> Select bread: ");
        String bread = theScanner.nextLine();

        while (!bread.equalsIgnoreCase("White") && !bread.equalsIgnoreCase("Wheat") && !bread.equalsIgnoreCase("Rye") && !bread.equalsIgnoreCase("Wrap")) {
            System.out.println("\nInvalid input. Please, select between: White, Wheat, Rye, Wrap");
            bread = theScanner.nextLine().trim();
        }

        System.out.println("\nSizes available: [4\", 8\", 12\"]");
        System.out.print("  >> Select size: ");
        int size = Integer.parseInt(theScanner.nextLine());

        while (size != 4 && size != 8 && size != 12) {
            System.out.println("\nError, input not valid. Please select between 4, 8, or 12");
            size = Integer.parseInt(theScanner.nextLine());
        }


        System.out.print("\n  >> Would you like it toasted? (y/n): ");
        String isToastedInput = theScanner.nextLine().trim();

        while (!isToastedInput.equalsIgnoreCase("y") && !isToastedInput.equalsIgnoreCase("n")) {
            System.out.println("\nInvalid input. Please enter 'y' for yes or 'n' for no.");
            isToastedInput = theScanner.nextLine().trim();
        }


        boolean isToasted = isToastedInput.equalsIgnoreCase("y");

        Sandwich sandwich = new Sandwich(size, bread, isToasted);

        System.out.println("\n  >>  Would you like to add meat? (y/n): ");
        String addMeatChoice = theScanner.nextLine();

        while (!addMeatChoice.equalsIgnoreCase("y") && !addMeatChoice.equalsIgnoreCase("n")) {
            System.out.println("  [!] Invalid input. Please enter 'y' for Yes or 'n' for No.");
            addMeatChoice = theScanner.nextLine().trim();
        }


        while(addMeatChoice.equalsIgnoreCase("y")){
            System.out.println("               AVAILABLE MEATS                 ");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.println("║  • Steak        • Ham        • Salami        ║");
            System.out.println("║  • Roast Beef   • Chicken    • Bacon         ║");
            System.out.println("╚══════════════════════════════════════════════╝");
            System.out.print("  >> Which meat would you like?: ");
            String meat = theScanner.nextLine();

            while (!meat.equalsIgnoreCase("Steak") && !meat.equalsIgnoreCase("Ham")
                    && !meat.equalsIgnoreCase("Salami") && !meat.equalsIgnoreCase("Roast Beef")
                    && !meat.equalsIgnoreCase("Chicken") && !meat.equalsIgnoreCase("Bacon")) {
                System.out.println("  ! Invalid meat selection.");
                System.out.println("    Available: Steak | Ham | Salami | Roast Beef | Chicken | Bacon");
                System.out.print("  >> Try again: ");
                meat = theScanner.nextLine().trim();
            }



            System.out.println("\nWould you like extra meat? (y/n)");
            boolean isExtra = theScanner.nextLine().equalsIgnoreCase("y");



            sandwich.addMeat(meat, isExtra);

            System.out.println("   Meat added successfully. ✅");
            System.out.print("  >> Add another meat? (y/n): ");
            addMeatChoice = theScanner.nextLine();


            while (!addMeatChoice.equalsIgnoreCase("y") && !addMeatChoice.equalsIgnoreCase("n")) {
                System.out.println("  [!] Invalid input. Please enter 'y' for Yes or 'n' for No.");
                addMeatChoice = theScanner.nextLine().trim();
            }

        }

        System.out.println("\nWould you like to add cheese? (y/n)");
        String addCheeseChoice = theScanner.nextLine();

        while (!addCheeseChoice.equalsIgnoreCase("y") && !addCheeseChoice.equalsIgnoreCase("n")) {
            System.out.println("  [!] Invalid input. Please enter 'y' for Yes or 'n' for No.");
            addCheeseChoice = theScanner.nextLine().trim();
        }

        while (addCheeseChoice.equalsIgnoreCase("y")){
            System.out.println("               AVAILABLE CHEESES               ");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.println("║  • American      • Provolone                 ║");
            System.out.println("║  • Cheddar       • Swiss                     ║");
            System.out.println("╚══════════════════════════════════════════════╝");
            System.out.print("  >> Which cheese would you like?: ");
            String cheese = theScanner.nextLine();

            System.out.println("\nWould you like extra cheese? (y/n)");
            boolean isExtra = theScanner.nextLine().equalsIgnoreCase("y");

            sandwich.addCheese(cheese, isExtra);



            System.out.println("   Cheese added successfully. ✅");
            System.out.print("  >> Add another cheese? (y/n): ");
            addCheeseChoice = theScanner.nextLine();
        }




        System.out.println("Would you like to add toppings? (y/n)?");
        String addToppingChoice = theScanner.nextLine();

        while (!addToppingChoice.equalsIgnoreCase("y") && !addToppingChoice.equalsIgnoreCase("n")) {
            System.out.println("  [!] Invalid input. Please enter 'y' for Yes or 'n' for No.");
            addToppingChoice = theScanner.nextLine().trim();
        }




        while (addToppingChoice.equalsIgnoreCase("y")){
            System.out.println("               AVAILABLE TOPPINGS              ");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.println("║  • Lettuce      • Peppers    • Onions        ║");
            System.out.println("║  • Tomatoes     • Jalapenos  • Cucumbers     ║");
            System.out.println("║  • Pickles      • Guacamole  • Mushrooms     ║");
            System.out.println("╚══════════════════════════════════════════════╝");
            System.out.print("  >> Which topping would you like?: ");
            String topping = theScanner.nextLine();

            sandwich.addTopping((topping));

            System.out.println("   Toppings added successfully. ✅");
            System.out.print("  >> Add another topping? (y/n): ");
            addToppingChoice = theScanner.nextLine();
        }

        System.out.println("Would you like to add Sauces? (y/n)?");
        String addSauceChoice = theScanner.nextLine();

        while (!addSauceChoice.equalsIgnoreCase("y") && !addSauceChoice.equalsIgnoreCase("n")) {
            System.out.println("  [!] Invalid input. Please enter 'y' for Yes or 'n' for No.");
            addSauceChoice = theScanner.nextLine().trim();
        }

        while(addSauceChoice.equalsIgnoreCase("y")){
            System.out.println("               AVAILABLE SAUCES                ");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.println("║  • Mayo           • Mustard                  ║");
            System.out.println("║  • Ketchup        • Ranch                    ║");
            System.out.println("║  • Thousand Is.   • Vinaigrette              ║");
            System.out.println("╚══════════════════════════════════════════════╝");
            System.out.print("  >> Which sauce would you like?: ");
            String sauce = theScanner.nextLine();

            sandwich.addSauce(sauce);

            System.out.println("   Sauces added successfully. ✅");
            System.out.print("  >> Add another sauce? (y/n): ");
            addSauceChoice = theScanner.nextLine();


        }

        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║                ADDITIONAL SIDES              ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.println("║  • Au Jus        • Sauce        • None       ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        System.out.print("  >> Select a side option: ");
        String sideChoice = theScanner.nextLine().toLowerCase();

        while (!sideChoice.equalsIgnoreCase("au jus") && !sideChoice.equalsIgnoreCase("sauce")
        && !sideChoice.equalsIgnoreCase("none")){
            System.out.println("  [!] Invalid input.");
            sideChoice = theScanner.nextLine().trim();
        }

        if (!sideChoice.equals("none")){
            sandwich.addSauce(sideChoice);
            System.out.println(sideChoice + " added! ✅");
        }

        order.addSandwich(sandwich);
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║         SANDWICH ADDED TO ORDER!   ✅        ║");
        System.out.println("╚══════════════════════════════════════════════╝");




    }
    public void addDrinkToOrder(Order order){
        String addDrinkChoice = "y";

        while (addDrinkChoice.equalsIgnoreCase("y")){

            System.out.println("╔══════════════════════════════════════════════╗");
            System.out.println("║                DRINK SIZE                    ║");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.println("║  • Small        • Medium        • Large      ║");
            System.out.println("╚══════════════════════════════════════════════╝");
            System.out.print("  >> Select size: ");
            String size = theScanner.nextLine();

            while (!size.equalsIgnoreCase("Small") && !size.equalsIgnoreCase("Medium") && !size.equalsIgnoreCase("Large")) {
                System.out.println("\nNot valid input, please select between: Small, Medium o Large:");
                size = theScanner.nextLine().trim();
            }

            System.out.println("╔══════════════════════════════════════════════╗");
            System.out.println("║                DRINK FLAVOR                  ║");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.println("║  • Coke         • Sprite                     ║");
            System.out.println("║  • Fanta        • Water                      ║");
            System.out.println("╚══════════════════════════════════════════════╝");
            System.out.print("  >> Select flavor: ");
            String flavor = theScanner.nextLine();

            while (!flavor.equalsIgnoreCase("Coke") && !flavor.equalsIgnoreCase("Sprite") && !flavor.equalsIgnoreCase("Fanta") && !flavor.equalsIgnoreCase("Water")) {
                System.out.println("Invalid input. Please, select between: Coke, Sprite, Fanta, Water");
                flavor = theScanner.nextLine().trim();
            }

            Drink drink = new Drink (size, flavor);
            order.addDrink(drink);
            System.out.println("\nDrink added! ✅");

            System.out.println("\nAdd another drink? (y/n)?");
            addDrinkChoice = theScanner.nextLine();
        }




    }
    public void addChipsToOrder(Order order){
        System.out.println("Add Chips selected!");

        String addChipsChoice = "y";


        while (addChipsChoice.equalsIgnoreCase("y")){

            System.out.println("╔══════════════════════════════════════════════╗");
            System.out.println("║              AVAILABLE CHIPS                 ║");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.println("║  • Regular        • BBQ                      ║");
            System.out.println("║  • Jalapeño       • Salt & Vinegar           ║");
            System.out.println("╚══════════════════════════════════════════════╝");
            System.out.print("  >> Which chips would you like?: ");
            String chipsOption = theScanner.nextLine();

            Chips chips = new Chips (chipsOption, 1.50);
            order.addChips(chips);
            System.out.println("\nChips added! ✅");

            System.out.println("\nAdd another bag of chips? (y/n)?");
            addChipsChoice = theScanner.nextLine();

        }
    }
    public void Checkout(Order order){


        if (order.getItems().isEmpty()){
            System.out.println("\n╔══════════════════════════════════════════════╗");
            System.out.println("║          [!] ORDER IS EMPTY                  ║");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.println("║  You must add at least one item              ║");
            System.out.println("║  before proceeding to checkout.              ║");
            System.out.println("╚══════════════════════════════════════════════╝");
            return;
        }

        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║            ORDER SUMMARY RECEIPT             ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.println(order.getOrderSummary());
        System.out.println("╚══════════════════════════════════════════════╝");


        System.out.println("────────────────────────────────────────────────");
        System.out.println("  >> Would you like to confirm and save your order? [y/n]");
        System.out.print("  >> Selection: ");
        String confirm = theScanner.nextLine();

        if (confirm.equalsIgnoreCase("y")){
            com.pluralsight.finance.ReceiptWriter.saveReceipt(order);
            System.out.println("\n╔══════════════════════════════════════════════╗");
            System.out.println("║          ✓ PAYMENT SUCCESSFUL!               ║");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.println("║  Thank you for your order.                   ║");
            System.out.println("║  Your receipt has been generated.            ║");
            System.out.println("╚══════════════════════════════════════════════╝");
            order.clearOrder();
        } else {
            System.out.println("Order canceled.");
            order.clearOrder();
        }
    }
}