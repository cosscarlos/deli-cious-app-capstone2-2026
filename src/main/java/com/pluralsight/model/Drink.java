package com.pluralsight.model;

public class Drink implements IOrderable {
    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    @Override
    public double getPrice(){
        return switch (size.toLowerCase()){
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 2.00;
        };


    }

    @Override
    public String getStringDetails(){
        return size + " " + flavor + " Drink - $" + String.format("%.2f", getPrice());
    }


}
