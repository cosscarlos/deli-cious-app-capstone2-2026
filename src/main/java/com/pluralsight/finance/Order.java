package com.pluralsight.finance;

import com.pluralsight.model.Chips;
import com.pluralsight.model.Drink;
import com.pluralsight.model.IOrderable;
import com.pluralsight.model.Sandwich;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<IOrderable> items;

    public Order(){
        this.items = new ArrayList<>();
    }

    public void addSandwich(Sandwich sandwich){
        this.items.add(sandwich);
    }

    public void addDrink(Drink drink){
        this.items.add(drink);
    }

    public void addChips(Chips chips){
        this.items.add(chips);
    }

    public double getTotalPrice(){
        double total = 0.0;
        for (IOrderable item : items){
            total += item.getPrice();
        }
        return total;
    }

    public List<IOrderable> getItems(){
        return items;
    }

    public String getOrderSummary(){
        StringBuilder summary = new StringBuilder("--- Order Summary ---\n");
        for (IOrderable item : items) {
            summary.append(item.getStringDetails()).append("\n");
        }

        summary.append("Total Price: $").append(String.format("%.2f", getTotalPrice()));
        return summary.toString();



    }





}
