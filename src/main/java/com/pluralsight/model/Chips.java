package com.pluralsight.model;

public class Chips implements IOrderable {
    private String name;
    private double price;

    public Chips(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice(){
        return price;
    }

    @Override
    public String getStringDetails(){
        return name + "Chips -$ " + String.format("%.2f", price);
    }



}
