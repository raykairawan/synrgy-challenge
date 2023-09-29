package com.challenge2.view;

import com.challenge2.model.FoodItem;
import com.challenge2.model.Order;

import java.util.List;
import java.util.Scanner;
//import java.util.logging.Logger;

public class View {
    private final Scanner scanner;

//    private static final Logger logger = Logger.getLogger(View.class.getName());
    public View() {
        this.scanner = new Scanner(System.in);
    }

    public void displayWelcomeMessage() {
        System.out.println("==========================");
        System.out.println("Selamat datang di BinarFud");
        System.out.println("==========================");
        System.out.println(" ");
    }

    public void displayMenu(List<FoodItem> menu) {
        System.out.println("Silahkan pilih makanan: ");
        for (int i = 0; i < menu.size(); i++) {
            int number = i + 1;
            FoodItem item = menu.get(i);
            System.out.println(number + ". " + item.getName() + " | " + item.getPrice());
        }
        System.out.println("99. Pesan dan Bayar");
        System.out.println("0. Keluar aplikasi");
        System.out.print("=> ");
    }

    public int getUserChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public void displayOrderMenu(FoodItem item) {
        System.out.println("=======================");
        System.out.println("Berapa pesanan anda");
        System.out.println("=======================");
        System.out.println(" ");
        System.out.println(item.getName() + " | " + item.getPrice());
        System.out.println("(input 0 untuk kembali)");
        System.out.print("qty => ");
    }

    public int getQuantity() {
        int qty = scanner.nextInt();
        scanner.nextLine();
        return qty;
    }

    public void displayOrderAddedConfirmation(FoodItem item, int qty) {
        System.out.println("Pesanan " + item.getName() + " (Qty: " + qty + ") telah ditambahkan.\n");
    }

    public void displayOrderCancelled() {
        System.out.println("Pesan dibatalkan.");
    }

    public void displayOrderSummary(Order order) {
        System.out.println("=============================");
        System.out.println("   Konfirmasi & Pembayaran   ");
        System.out.println("=============================");
        System.out.println(" ");

        List<FoodItem> items = order.getItems();
        List<Integer> quantities = order.getQuantities();

        for (int i = 0; i < items.size(); i++) {
            FoodItem item = items.get(i);
            int qty = quantities.get(i);
            System.out.println(item.getName() + "\t " + qty + " | " + item.getPrice());
        }

        System.out.println("----------------------------+");
        System.out.println("Total\t\t\t\t" + " " + order.getTotal() + "\n");
    }

    public int getPaymentChoice() {
        System.out.println("1. Konfirmasi dan Bayar");
        System.out.println("2. Kembali ke menu utama");
        System.out.println("0. Keluar aplikasi");
        System.out.print("=> ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public void displayPaymentConfirmation() {
        System.out.println("Pembayaran berhasil.");
        System.out.println("=========================================");
        System.out.println("Simpan struk ini sebagai bukti pembayaran");
        System.out.println("=========================================\n");
    }

    public void displayInvalidChoiceMessage() {
        System.out.println("Pilihan tidak valid.");
        System.out.println("=========================================");
        System.out.println("(Y) untuk Lanjut");
        System.out.println("(N) untuk keluar");
        String pilihan = scanner.next();
        if (!pilihan.equals("Y")) {
            System.exit(1);
        }
    }

    public void closeScanner() {
        scanner.close();
    }
}
