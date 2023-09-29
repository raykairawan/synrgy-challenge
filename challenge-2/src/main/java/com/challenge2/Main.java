package com.challenge2;

import com.challenge2.controller.Controller;
import com.challenge2.model.FoodItem;
import com.challenge2.model.Order;
import com.challenge2.service.TextFileWriter;
import com.challenge2.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        List<FoodItem> menu = createMenu();
        Order order = new Order();
        View view = new View();
        TextFileWriter textFileWriter = new TextFileWriter();
        Controller controller = new Controller(order, view, textFileWriter, menu);

        logger.info("BE2308SYN034");
        controller.start();
    }

    private static List<FoodItem> createMenu() {
        List<FoodItem> menu = new ArrayList<>();
        menu.add(new FoodItem("Nasi Goreng\t", 15000));
        menu.add(new FoodItem("Mie Goreng\t", 13000));
        menu.add(new FoodItem("Nasi + Ayam\t", 18000));
        menu.add(new FoodItem("Es Teh Manis\t", 3000));
        menu.add(new FoodItem("Es Jeruk   \t", 5000));
        return menu;
    }
}
