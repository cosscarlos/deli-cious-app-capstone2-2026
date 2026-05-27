package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements IOrderable {


    private String breadType;
    private int size;
    private boolean isToasted;
    private List<Ingredient> meats;
    private List<Ingredient> cheeses;
    private List<String> toppings;
    private List <String> sauces;
    private double price;

    public Sandwich(int size, String breadType, boolean isToasted) {
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.sauces = new ArrayList<>();

        if (size == 4){
            price = 5.50;
        } else if (size == 8){
            price = 7.00;
        }else if (size == 12){
            price = 8.50;
        }



    }

    public void addMeat (String meat, boolean isExtra){
        double basePrice = (size == 4) ? 1.00 : (size == 8) ? 2.00 : 3.00;
        double extraPrice = (size == 4) ? 0.50 : (size == 8) ? 1.00 : 1.50;
        double cost = isExtra ? extraPrice : basePrice;

        meats.add(new Ingredient(meat, basePrice));
        this.price += basePrice;

        meats.add(new Ingredient(meat + " (Extra)", extraPrice));
        this.price += extraPrice;
    }

    public void addCheese (String cheese, boolean isExtra){
        double basePrice = (size == 4) ? 0.75 : (size == 8) ? 1.50 : 2.25;
        double extraPrice = (size == 4) ? 0.30 : (size == 8) ? 0.60 : 0.90;

        cheeses.add(new Ingredient(cheese, basePrice));
        this.price += basePrice;

        if (isExtra) {
            cheeses.add(new Ingredient(cheese + " (Extra)", extraPrice));
            this.price += extraPrice;
        }
    }

    public void addTopping(String topping){
        toppings.add(topping);
    }

    public void addSauce(String sauce) {
        sauces.add(sauce);
    }


    @Override
    public double getPrice(){
        return  price;
        }
    @Override
    public String getStringDetails() {

        StringBuilder summaryOrder = new StringBuilder();

        double baseSandwichPrice = (size == 4) ? 5.50 : (size == 8) ? 7.00 : 8.50;
        summaryOrder.append(String.format("%d\" %s Sandwich (Toasted: %b) - $%.2f\n", size, breadType, isToasted, baseSandwichPrice));

        for (Ingredient m : meats){
            summaryOrder.append(String.format("  - Meat: %s  $%.2f\n", m.name, m.price));
        }

        for (Ingredient c : cheeses) {
            summaryOrder.append(String.format("  - Cheese: %s  $%.2f\n", c.name, c.price));
        }

        if (!toppings.isEmpty()) summaryOrder.append("  - Toppings: ").append(toppings).append("\n");
        if (!sauces.isEmpty()) summaryOrder.append("  - Sides/Sauces: ").append(sauces).append("\n");

        summaryOrder.append(String.format("  -> Subtotal: $%.2f", price));
        return summaryOrder.toString();

//        StringBuilder sb = new StringBuilder();
//        sb.append(String.format("%d\" %s Sandwich (Toasted: %b)\n", size, breadType, isToasted));
//
//        for (Ingredient m : meats) {
//            sb.append(String.format("  - Meats: [%s]  $%.2f\n", m.name, m.price));
//        }
//        for (Ingredient c : cheeses) {
//            sb.append(String.format("  - Cheeses: [%s]  $%.2f\n", c.name, c.price));
//        }
//
//        sb.append(String.format("  -> Subtotal: $%.2f", price));
//        return sb.toString();
    }

    // generic getters and setters
    public int getSize() {
        return size;
    }

    public String getBreadType() {
        return breadType;
    }
}



