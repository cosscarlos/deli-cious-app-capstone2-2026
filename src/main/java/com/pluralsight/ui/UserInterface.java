package com.pluralsight.ui;


import com.pluralsight.finance.Order;
import com.pluralsight.model.Sandwich;

import java.util.Scanner;

public class UserInterface {
    private Scanner theScanner = new Scanner(System.in);

    public void display() {
        boolean running = true;

        while (running) {
            System.out.println("Deli-cious app");
            System.out.println("Please select one option: ");
            System.out.println(" ");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            String option = theScanner.nextLine();

            switch (option) {
                case "1" -> {
                    Order myOrder = new Order();
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

        System.out.println("==================");
        System.out.println("=     Ordering   =");
        System.out.println("==================");

        System.out.println("1) Add Sandwich");
        System.out.println("2) Add Drink");
        System.out.println("3) Add Chips");
        System.out.println("4) Checkout");
        String option = theScanner.nextLine();

        switch (option){
            case "1" -> addSandwichToOrder(order);
            case "2" -> addDrink();
            case "3" -> addChips();
            case "4" -> Checkout();
            case "0" -> display();
        }




    }

    //order menu
    public void addSandwichToOrder(Order order){


        System.out.println("Add Sandwich selected!");
        System.out.println("--- Building your Sandwich ---");

        System.out.println("What kind of bread do you prefer? (White, Wheat, Rye, Wrap)");
        String bread = theScanner.nextLine();

        System.out.println("What size? (4, 8, or 12");
        int size = Integer.parseInt(theScanner.nextLine());

        System.out.println("Would you like it toasted? (y/n)");
        boolean toasted = theScanner.nextLine().equalsIgnoreCase("y");

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        System.out.println("Would you like to add meat? (y/n)");
        String addMeatChoice = theScanner.nextLine();



        while(addMeatChoice.equalsIgnoreCase("y")){
            System.out.println("Available meats: Steak, Ham, Salami, Roast Beef, Chicken, Bacon");
            System.out.println("Which meat would you like? ");
            String meat = theScanner.nextLine();

            System.out.println("Would you like extra meat? (y/n)");
            boolean isExtra = theScanner.nextLine().equalsIgnoreCase("y");

            sandwich.addMeat(meat, isExtra);

            System.out.println("Meat added! Add another meat? (y/n)");
            addMeatChoice = theScanner.nextLine();

        }



        System.out.println("Would you like to add cheese? (y/n)");
        String addCheeseChoice = theScanner.nextLine();

        while (addCheeseChoice.equalsIgnoreCase("y")){
            System.out.println("Available cheeses: American, Provolone, Cheddar, Swiss");
            System.out.println("Which cheese would you like");
            String cheese = theScanner.nextLine();

            System.out.println("Would you like extra cheese? (y/n)");
            boolean isExtra = theScanner.nextLine().equalsIgnoreCase("y");

            sandwich.addCheese(cheese, isExtra);

            System.out.println("Cheese added! Add another cheese? (y/n)");
            addCheeseChoice = theScanner.nextLine();
        }

        order.addSandwich(sandwich);
        System.out.println("Sandwich added to your order!");


        System.out.println("Would you like to add toppings? (y/n)?");
        String addToppingChoice = theScanner.nextLine();

        while (addToppingChoice.equalsIgnoreCase("y")){
            System.out.println("Available: Lettuce, Peppers, Onions, Tomatoes, Jalapenos, Cucumbers, ");
            System.out.println("Which topping would you like? ");
            String topping = theScanner.nextLine();

            sandwich.addTopping((topping));

            System.out.println("Topping added! Add another? (y/n");
            addToppingChoice = theScanner.nextLine();
        }

        System.out.println("Would you like to add Sauces? (y/n)?");
        String addSauceChoice = theScanner.nextLine();

        while(addSauceChoice.equalsIgnoreCase("y")){
            System.out.println("Sauces available: Mayo, Mustard, Ketchup, Ranch, Thousand Island, Vinaigrette");
            System.out.println("Which sauce would you like? ");
            String sauce = theScanner.nextLine();

            sandwich.addSauce(sauce);

            System.out.println("Sauce added! Add another? (y/n)?");
            addSauceChoice = theScanner.nextLine();
        }







    }
    public void addDrink(){
        System.out.println("Add Drink selected!");
    }
    public void addChips(){
        System.out.println("Add Chips selected!");
    }
    public void Checkout(){
        System.out.println("Checkout selected!");
    }




}


