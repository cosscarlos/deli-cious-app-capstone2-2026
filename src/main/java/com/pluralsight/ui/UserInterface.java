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
                case "1" -> order();
                case "0" -> {
                    running = false;
                    System.out.println("Thank you, goodbye!");
                }
               default -> System.out.println("Error: Option not valid, try again. ");
            }
        }
    }


    public void order(){

        System.out.println("==================");
        System.out.println("=     Ordering   =");
        System.out.println("==================");

        System.out.println("1) Add Sandwich");
        System.out.println("2) Add Drink");
        System.out.println("3) Add Chips");
        System.out.println("4) Checkout");
        String option = theScanner.nextLine();

        switch (option){
            case "1" -> addSandwichToOrder();
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

        System.out.println("Would you like it toasted?");
        boolean toasted = Boolean.parseBoolean(theScanner.nextLine());

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        System.out.println("Would you like to add meat? (y/n)");
        String addMeatChoice = theScanner.nextLine();

        if(theScanner.nextLine().equalsIgnoreCase("y")){
            System.out.println("Available meats: Steak, Hamm Salami, Roast Beef, Chicken, Bacon");
            System.out.println("Which meat would you like? ");
            String meat = theScanner.nextLine();

            System.out.println("Would you like extra meat? (y/n): ");
            boolean isExtra = theScanner.nextLine().equalsIgnoreCase("y");

            sandwich.addMeat(meat, isExtra);

            System.out.println("Meat added! Add another meat? (y/n)");
            addMeatChoice = theScanner.nextLine();
        }

        order.addSandwich(sandwich);
        System.out.println("Sandwich added to your order!");

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


