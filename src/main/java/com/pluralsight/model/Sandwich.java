package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements IOrderable {

    private int size;
    private String breadType;
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
        } else if (size ==8){
            price = 7.00;
        }else if (size == 12){
            price = 8.50;
        }



    }

    public void addMeat (String meat, boolean isExtra){
        meats.add(meat);

         price += (isExtra) ? .50 : 1.00;
    }

    public void addCheese (String cheese, boolean isExtra){
        cheeses.add(cheese);

        price += (isExtra) ? 0.30 : 0.75;
    }

    public void adTopping(String topping){
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
        return size + "\" " + breadType + " Sandwich | Toasted: " + isToasted +
                " | Meats: " + meats + " | Cheeses: " + cheeses +
                " | Toppings: " + toppings + " | Total: $" + String.format("%.2f", price);
    }


    }



