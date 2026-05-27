package com.pluralsight.model;

public class Ingredient {
    String name;
    double price;

    public Ingredient(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s ($%.2f)", name, price);
    }
}
