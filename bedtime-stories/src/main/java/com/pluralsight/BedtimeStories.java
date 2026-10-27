package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BedtimeStories {
    static Scanner sc = new Scanner(System.in);
    static void main(String[] args) {
        System.out.println("BedtimeStories");
        System.out.println("1- goldilocks");
        System.out.println("2- hansel_and_gretel");
        System.out.println("3- mary_had_a_little_lamb");
        System.out.print("Enter the number of the Storie you want to Read:");
        int Chioce= sc.nextInt();
        String filename="";
        switch (Chioce){
            case 1: filename = "goldilocks.txt";
            break;
            case 2: filename = "hansel_and_gretel.txt";
            break;
            case 3: filename = "mary_had_a_little.txt";
            break;
        }
        filereader(filename);
    }
    public static void filereader(String filename){
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(count+ ".    "+line);
                count++;
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
