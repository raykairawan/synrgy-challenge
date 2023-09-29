package com.challenge1.service;

import com.challenge1.model.FoodItem;
import com.challenge1.model.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TextFileWriter {
    public void writeReceipt(Order order, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("===============\n");
            writer.write("BinarFud\n");
            writer.write("===============\n");
            writer.write("\n");
            writer.write("Terima kasih sudah memesan di BinarFud\n");
            writer.write("\n");
            writer.write("Dibawah ini adalah pesanan anda\n");

            List<FoodItem> items = order.getItems();
            List<Integer> quantities = order.getQuantities();

            for (int i = 0; i < items.size(); i++) {
                writer.write(items.get(i).getName() + " " + quantities.get(i) + " " + items.get(i).getPrice() + "\n");
            }

            writer.write("----------------------+\n");
            writer.write("Total" + " " + order.getTotal() + "\n");

            writer.write("\n");
            writer.write("Pembayaran : BinarCash\n");
            writer.write("\n");
            writer.write("=========================================\n");
            writer.write("Simpan struk ini sebagai bukti pembayaran\n");
            writer.write("=========================================\n");

            System.out.println("Struk telah ditulis ke " + fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
