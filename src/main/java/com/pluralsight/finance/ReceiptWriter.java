package com.pluralsight.finance;

import com.pluralsight.model.IOrderable;
import com.pluralsight.finance.Order;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {



    public static void saveReceipt(Order order){
        String filename = "src/main/receipts/" + generateTimestamp() + ".txt";

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            writer.write("--- Receipt ---");
            writer.newLine();

            for (IOrderable item : order.getItems()){
                writer.write(item.getStringDetails());
                writer.newLine();
            }

            writer.write("Total: $" + String.format("%.2f", order.getTotalPrice()));
            System.out.println("Receipt saved successfully in: " + filename);

        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }


   

    }


    private static String generateTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        return LocalDateTime.now().format(formatter);
    }



}
