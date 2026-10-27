package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BedtimeStories {
    static void main(String[] args) {
        try {
            FileReader fr = new FileReader("goldilocks.txt");
            BufferedReader br = new BufferedReader(fr);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
