package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements IOrderable {

    protected int size;
    protected String breadType;
    protected boolean isToasted;
    protected List<Topping> toppings;

    public Sandwich(String size, String breadType, boolean isToasted) {
        this.size = 4;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.toppings = new ArrayList<>();
    }


    @Override
    public double getPrice(){
        double price = 0.0;

        if (size ==4){
            price = 5.50;
        } else if (size == 8) {
            price = 7.00;
        } else if (size == 12){
            price = 8.50;
        }

        for (Topping topping : toppings){
            price += topping.getPrice();
        }

        return price;


    }
    @Override
    public String getStringDetails(){
        return size + "" + breadType + " sandwich";
    }

}
