package com.challenge1.service;

import com.challenge1.model.FoodItem;
import com.challenge1.model.Order;

import java.util.List;

public class OrderService {
    public void addToOrder(Order order, FoodItem item, int quantity) {
        order.addItem(item, quantity);
    }

    public double calculateTotal(Order order) {
        double total = 0.0;
        List<FoodItem> items = order.getItems();
        List<Integer> quantities = order.getQuantities();

        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getPrice() * quantities.get(i);
        }

        return total;
    }
}
