package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SearchInventory {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        //Initiating Array List
        ArrayList<Product> inventory = getInventory();

        //Sorting The List
        inventory.sort(Comparator.comparing(Product::getName));

        //Menu
        UI(inventory);

    }
    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();
        try {
            FileReader fileReader = new FileReader("inventory.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;
            while((input = bufReader.readLine()) != null) {
                int id = Integer.parseInt(input.split("\\|")[0]);
                String name =input.split("\\|")[1];
                double price=Double.parseDouble(input.split("\\|")[2]);
                Product p = new Product(id, name, price);
                inventory.add(p);}
            bufReader.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        return inventory;
    }

    public static void UI(ArrayList<Product> inventory){
        boolean running=true;
        while(running){
            System.out.println("What do you want to do?");
            System.out.println("1- List all products");
            System.out.println("2- Search product by id");
            System.out.println("3- Find all products within a price range");
            System.out.println("4- Add a new product");
            System.out.println("5- Save inventory to file");
            System.out.println("6- Quit the application");
            int choice= input.nextInt();
        switch(choice){
            case 1:ListAllProducts(inventory);
                break;
            case 2:
                System.out.println("Enter product id: ");
                int id = input.nextInt();
                SearchProductById(id, inventory);
                break;
            case 3:
                System.out.print("Enter Minimum Price for a product: ");
                double MinPrice = input.nextDouble();
                System.out.print("Enter Maximum Price for a product: ");
                double MaxPrice = input.nextDouble();
                PriceSearch(MinPrice,MaxPrice, inventory);
                break;
            case 4:
                System.out.println("Enter product Id: ");
                int pId = input.nextInt();
                input.nextLine();
                System.out.print("Enter product Name ");
                String pName = input.nextLine();
                System.out.print("Enter product Price ");
                double pPrice = input.nextDouble();
                AddProduct(pId,pName,pPrice,inventory);
                break;
            case 5:
                SaveInventory(inventory);
                break;
            case 6:
                running=false;
                break;
        }
        }
    }

    public static void ListAllProducts(ArrayList<Product> inventory) {
        System.out.println("***  We carry the following inventory  ** ");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.println(p.toString());
        }
        System.out.println("_______________________________");
    }

    public static void SearchProductById(int id, ArrayList<Product> inventory) {
        for (Product p : inventory) {
            if (p.getId() == id) {
                System.out.println(p);
                return;
            }
        }
        System.out.println("Product not found");
    }

    public static void PriceSearch(double min,double max, ArrayList<Product> inventory) {
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            if (p.getPrice() >= min && p.getPrice() <= max) {
                System.out.println(p.toString());
            }
        }
    }

    public static void AddProduct(int id,String name,double price, ArrayList<Product> inventory) {
        Product p = new Product(id, name, price);
        inventory.add(p);
        inventory.sort(Comparator.comparing(Product::getName));
    }

    public static void SaveInventory(ArrayList<Product> inventory) {
        try {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String fileName = "inventory_" + timestamp + ".csv";
            PrintWriter pw = new PrintWriter(new FileWriter(fileName));
            for (Product p : inventory) {
                pw.println(
                        p.getId() + "|" + p.getName() + "|" + p.getPrice()
                );
            }
            pw.close();
            System.out.println("Saved to " + fileName);

        } catch (IOException e) {
            System.out.println("Error saving inventory.");
        }
    }

}
