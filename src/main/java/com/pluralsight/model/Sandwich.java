package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements IOrderable {

    protected int size;
    protected String breadType;
    protected boolean isToasted;
    protected List<Topping> toppings;

    public Sandwich(int size, String breadType, boolean isToasted) {
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.toppings = new ArrayList<>();
    }

    public void addTopping(Topping topping){
        this.toppings.add(topping);
    }


    @Override
    public double getPrice(){
        double price = 0.0;

        switch(size){
            case 4 -> price = 5.50;
            case 8 -> price = 7.00;
            case 12 -> price = 8.50;
            default -> price = 0.0;

        }

        for (Topping topping : toppings){
            price += topping.getPrice();
        }

        return price;


    }
    @Override
    public String getStringDetails(){
        return size + " " + breadType + " sandwich" + (isToasted ? " (Toasted" : "");
    }

}
