package com.pluralsight.model;

public class Chips implements IOrderable {
    private String name;
    private double price;




    @Override
    public double getPrice(){
        return price;
    }

    @Override
    public String getStringDetails(){
        return name + " Chips";
    }



}
