package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Image image = new Image("/Users/tinamt/Desktop/819679cf77816357ef7c056c606891d1.jpg");
        System.out.println(image.getLength());
        System.out.println(image.getWidth());

        
    }
}
