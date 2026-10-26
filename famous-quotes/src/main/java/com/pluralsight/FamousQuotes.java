package com.pluralsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FamousQuotes {
    public static void main(String[] args) {

        String[] quotes = {
                "The only way to do great work is to love what you do.",
                "Success is not final, failure is not fatal.",
                "Believe you can and you're halfway there.",
                "Do what you can, with what you have, where you are.",
                "It always seems impossible until it's done.",
                "Be yourself; everyone else is already taken.",
                "Dream big and dare to fail.",
                "The future depends on what you do today.",
                "Mistakes are proof that you are trying.",
                "Never give up on something you really want."
        };

        Scanner scanner = new Scanner(System.in);
       boolean valid= true;
        System.out.print("Select a quote number (1-10): ");
        while (valid){
        try  {
            int choice = scanner.nextInt();
            System.out.println("Quote #" + choice + ":");
            System.out.println(quotes[choice - 1]);


        } catch (InputMismatchException e){
            System.out.println("Invalid Entry. Please enter a number between 1 and 10.");
            scanner.next();
        }
        }

        scanner.close();
    }
}