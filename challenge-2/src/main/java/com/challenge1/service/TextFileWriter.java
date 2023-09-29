package com.challenge1.service;

import com.challenge1.model.FoodItem;
import com.challenge1.model.Order;
import com.challenge1.exception.IOException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.logging.Logger;

public class TextFileWriter {
    private static final Logger logger = Logger.getLogger(TextFileWriter.class.getName());
    public void writeReceipt(Order order, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("========================================\n");
            writer.write("\t\t\t\tBinarFud\n");
            writer.write("========================================\n");
            writer.write("\n");
            writer.write("Terima kasih sudah memesan di BinarFud\n");
            writer.write("\n");
            writer.write("Dibawah ini adalah pesanan anda\n");

            List<FoodItem> items = order.getItems();
            List<Integer> quantities = order.getQuantities();

            for (int i = 0; i < items.size(); i++) {
                writer.write(items.get(i).getName() + "\t " +
                        quantities.get(i) + " | " + items.get(i).getPrice() + "\n"
                );
            }

            writer.write("-------------------------------+\n");
            writer.write("Total\t\t\t\t" + " " + order.getTotal() + "\n");

            writer.write("\n");
            writer.write("Pembayaran : BinarCash\n");
            writer.write("\n");
            writer.write("=========================================\n");
            writer.write("Simpan struk ini sebagai bukti pembayaran\n");
            writer.write("=========================================\n");

            logger.info("Struk telah ditulis ke " + fileName);
        } catch (IOException | java.io.IOException e) {
            throw new IOException("Terjadi kesalahan dalam membaca file", e);
        }
    }
}