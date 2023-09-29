package com.challenge1.view;

import com.challenge1.model.FoodItem;
import com.challenge1.model.Order;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class View {
    private final Scanner scanner;
    private static final Logger logger = Logger.getLogger(View.class.getName());

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public void displayWelcomeMessage() {
        logger.info("==========================");
        logger.info("Selamat datang di BinarFud");
        logger.info("==========================");
        logger.info(" ");
    }

    public void displayMenu(List<FoodItem> menu) {
        logger.info("Silahkan pilih makanan: ");
        for (int i = 0; i < menu.size(); i++) {
            int number = i + 1;
            FoodItem item = menu.get(i);
            logger.info(number + ". " + item.getName() + " | " + item.getPrice());
        }
        logger.info("99. Pesan dan Bayar");
        logger.info("0. Keluar aplikasi");
        logger.info("=> ");
    }

    public int getUserChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public void displayOrderMenu(FoodItem item) {
        logger.info("=======================");
        logger.info("Berapa pesanan anda");
        logger.info("=======================");
        logger.info(" ");
        logger.info(item.getName() + " | " + item.getPrice());
        logger.info("(input 0 untuk kembali)");
        logger.info("qty => ");
    }

    public int getQuantity() {
        int qty = scanner.nextInt();
        scanner.nextLine();
        return qty;
    }

    public void displayOrderAddedConfirmation(FoodItem item, int qty) {
        logger.info("Pesanan " + item.getName() + " (Qty: " + qty + ") telah ditambahkan.\n");
    }

    public void displayOrderCancelled() {
        logger.info("Pesan dibatalkan.");
    }

    public void displayOrderSummary(Order order) {
        logger.info("=============================");
        logger.info("   Konfirmasi & Pembayaran   ");
        logger.info("=============================");
        logger.info(" ");

        List<FoodItem> items = order.getItems();
        List<Integer> quantities = order.getQuantities();

        for (int i = 0; i < items.size(); i++) {
            FoodItem item = items.get(i);
            int qty = quantities.get(i);
            logger.info(item.getName() + "\t " + qty + " | " + item.getPrice());
        }

        logger.info("----------------------------+");
        logger.info("Total\t\t\t\t" + " " + order.getTotal() + "\n");
    }

    public int getPaymentChoice() {
        logger.info("1. Konfirmasi dan Bayar");
        logger.info("2. Kembali ke menu utama");
        logger.info("0. Keluar aplikasi");
        logger.info("=> ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public void displayPaymentConfirmation() {
        logger.info("Pembayaran berhasil.");
        logger.info("=========================================");
        logger.info("Simpan struk ini sebagai bukti pembayaran");
        logger.info("=========================================\n");
    }

    public void displayInvalidChoiceMessage() {
        logger.info("Pilihan tidak valid.");
        logger.info("=========================================");
        logger.info("(Y) untuk Lanjut");
        logger.info("(N) untuk keluar");
        String pilihan = scanner.next();
        if (!pilihan.equals("Y")) {
            System.exit(1);
        }
    }

    public void closeScanner() {
        scanner.close();
    }
}
