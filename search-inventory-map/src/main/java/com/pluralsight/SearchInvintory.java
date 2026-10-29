package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class SearchInvintory {
    static HashMap<String, Product> inventory = new HashMap<>();

    public static void main(String[] args) {
        loadInventory();
        Scanner input = new Scanner(System.in);

        boolean searchAgain = true;

        while (searchAgain) {
            System.out.print("Enter Product ID: ");
            String productId = input.nextLine();

            Product product = inventory.get(productId);

            if (product != null) {
                System.out.println(product);
            } else {
                System.out.println("Product not found.");
            }

            System.out.print("Do you want to search again? (yes/no): ");
            String answer = input.nextLine();

            if (!answer.equalsIgnoreCase("yes")) {
                searchAgain = false;
            }
        }

        System.out.println("Goodbye!");
    }

    public static void loadInventory() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("inventory.csv"));

            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                String id = parts[0];
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);

                Product product = new Product(id, name, price);

                inventory.put(id, product);
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error loading inventory.");
        }
    }

}
