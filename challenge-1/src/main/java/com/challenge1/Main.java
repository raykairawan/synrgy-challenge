package com.challenge1;

import com.challenge1.model.FoodItem;
import com.challenge1.model.Order;
import com.challenge1.service.TextFileWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<FoodItem> menu = createMenu();
        Order order = new Order();

        System.out.println("BE2308SYN034 - Bambang Irawan");
        boolean isRunning = true;

        while (isRunning) {
            displayMenu(menu);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    orderMenu(order, menu.get(choice - 1), scanner);
                    break;
                case 99:
                    orderConfirmation(order);
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }

        scanner.close();
    }

    private static List<FoodItem> createMenu() {
        List<FoodItem> menu = new ArrayList<>();
        menu.add(new FoodItem("Nasi Goreng", 15000));
        menu.add(new FoodItem("Mie Goreng", 13000));
        menu.add(new FoodItem("Nasi + Ayam", 18000));
        menu.add(new FoodItem("Es Teh Manis", 3000));
        menu.add(new FoodItem("Es Jeruk", 5000));
        return menu;
    }

    private static void displayMenu(List<FoodItem> menu) {
        System.out.println("==========================");
        System.out.println("Selamat datang di BinarFud");
        System.out.println("==========================");
        System.out.println(" ");

        for (int i = 0; i < menu.size(); i++) {
            int number = i + 1;
            FoodItem item = menu.get(i);
            System.out.println(number + ". " + item.getName() + " | " + item.getPrice());
        }

        System.out.println("99. Pesan dan Bayar");
        System.out.println("0. Keluar aplikasi");
        System.out.print("=> ");
    }

    private static void orderMenu(Order order, FoodItem item, Scanner scanner) {
        System.out.println("===================");
        System.out.println("Berapa pesanan anda");
        System.out.println("===================");
        System.out.println(" ");

        System.out.println(item.getName() + " | " + item.getPrice());
        System.out.println("(input 0 untuk kembali)");

        System.out.print("qty => ");
        int qty = scanner.nextInt();

        if (qty > 0) {
            order.addItem(item, qty);
            System.out.println("Pesanan " + item.getName() + " (Qty: " + qty + ") telah ditambahkan.");
        } else {
            System.out.println("Pesan dibatalkan.");
        }
    }

    private static void orderConfirmation(Order order) {
        int totalQty = 0;
        double totalPrice = 0.0;

        for (int i = 0; i < order.getItems().size(); i++) {
            totalQty += order.getQuantities().get(i);
            totalPrice += (order.getQuantities().get(i) * order.getItems().get(i).getPrice());
        }

        System.out.println("=======================");
        System.out.println("Konfirmasi & Pembayaran");
        System.out.println("=======================");
        System.out.println(" ");

        for (int i = 0; i < order.getItems().size(); i++) {
            FoodItem item = order.getItems().get(i);
            int qty = order.getQuantities().get(i);
            System.out.println(item.getName() + " " + qty + " " + item.getPrice());
        }

        System.out.println("----------------------+");
        System.out.println("Total" + " " + totalQty + " " + totalPrice);
        System.out.println(" ");
        System.out.println("1. Konfirmasi dan Bayar");
        System.out.println("2. Kembali ke menu utama");
        System.out.println("0. Keluar aplikasi");
        System.out.print("=> ");

        Scanner scanner = new Scanner(System.in);
        int selectedMenu = scanner.nextInt();
        TextFileWriter textFileWriter = new TextFileWriter();

        switch (selectedMenu) {
            case 1:
                textFileWriter.writeReceipt(order, "invoice.txt");
                break;
            case 2:
                break;
            case 0:
                System.exit(1);
                break;
            default:
                break;
        }
    }

}
