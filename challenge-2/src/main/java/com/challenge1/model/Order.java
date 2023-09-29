package com.challenge1.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<FoodItem> items;
    private List<Integer> quantities;

    public Order() {
        items = new ArrayList<>();
        quantities = new ArrayList<>();
    }

    public void addItem(FoodItem item, int quantity) {
        items.add(item);
        quantities.add(quantity);
    }

    public List<FoodItem> getItems() {
        return items;
    }

    public List<Integer> getQuantities() {
        return quantities;
    }

    public double getTotal() {
        double total = 0.0;
        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getPrice() * quantities.get(i);
        }
        return total;
    }
}
