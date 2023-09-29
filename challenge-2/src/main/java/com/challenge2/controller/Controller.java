package com.challenge2.controller;


import com.challenge2.model.FoodItem;
import com.challenge2.model.Order;
import com.challenge2.service.TextFileWriter;
import com.challenge2.view.View;

import java.util.List;

public class Controller {
    private Order order;
    private View view;
    private TextFileWriter textFileWriter;
    private List<FoodItem> menu;

    public Controller(Order order, View view, TextFileWriter textFileWriter, List<FoodItem> menu) {
        this.order = order;
        this.view = view;
        this.textFileWriter = textFileWriter;
        this.menu = menu;
    }

    public void start() {
        view.displayWelcomeMessage();
        boolean isRunning = true;

        while (isRunning) {
            view.displayMenu(menu);
            int choice = view.getUserChoice();

            switch (choice) {
                case 1, 2, 3, 4, 5:
                    orderMenu(menu.get(choice - 1));
                    break;
                case 99:
                    orderConfirmation();
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    view.displayInvalidChoiceMessage();
                    break;
            }
        }
        view.closeScanner();
    }

    private void orderMenu(FoodItem item) {
        view.displayOrderMenu(item);
        int qty = view.getQuantity();

        if (qty > 0) {
            order.addItem(item, qty);
            view.displayOrderAddedConfirmation(item, qty);
        } else {
            view.displayOrderCancelled();
        }
    }

    private void orderConfirmation() {
        view.displayOrderSummary(order);
        int paymentChoice = view.getPaymentChoice();

        if (paymentChoice == 1) {
            textFileWriter.writeReceipt(order, "invoice.txt");
            view.displayPaymentConfirmation();
        }
    }
}