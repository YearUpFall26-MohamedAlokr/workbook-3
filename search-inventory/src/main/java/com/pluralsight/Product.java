package com.pluralsight;

public class Product {
   private int id;
   private String name;
   private double Price;

   public Product(int id, String name, double price) {
       this.id = id;
       this.name = name;
       this.Price = price;
   }
   public int getId() {
       return id;
   }
   public void setId(int id) {
       this.id = id;
   }
   public  String getName() {
       return name;
   }
   public void setName(String name) {
       this.name = name;
   }
   public double getPrice() {
       return Price;
   }
   public void setPrice(double price) {
       this.Price = price;
   }

    @Override
    public String toString() {
        return id + "|" + name + "|" + Price;
    }
}
