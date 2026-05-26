package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements IOrderable {


    private String breadType;
    private int size;
    private boolean isToasted;
    private List<String> meats;
    private List<String> cheeses;
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
        meats.add(meat);

         price += (isExtra) ? 0.50 : 1.00;
    }

    public void addCheese (String cheese, boolean isExtra){
        cheeses.add(cheese);

        price += (isExtra) ? 0.30 : 0.75;
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
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d\" %s Sandwich (Toasted: %b)\n", size, breadType, isToasted));

        // Aquí desglosamos los ingredientes
        if (!meats.isEmpty()) sb.append("  - Meats: ").append(meats).append("\n");
        if (!cheeses.isEmpty()) sb.append("  - Cheeses: ").append(cheeses).append("\n");
        if (!toppings.isEmpty()) sb.append("  - Toppings: ").append(toppings).append("\n");
        if (!sauces.isEmpty()) sb.append("  - Sides/Sauces: ").append(sauces).append("\n");

        sb.append(String.format("  -> Subtotal: $%.2f", price));
        return sb.toString();
    }

    // generic getters and setters
    public int getSize() {
        return size;
    }

    public String getBreadType() {
        return breadType;
    }
}



