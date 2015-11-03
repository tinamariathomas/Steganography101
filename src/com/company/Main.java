package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String message = "Hey there How are you doing Is this cool or what???";
        String coverFilePath = "/Users/tinamt/Desktop/output1.png";
        String outputFilePath = "/Users/tinamt/Desktop/output2.png";

        Stego.embed(message,coverFilePath,outputFilePath);
        System.out.println("DATA EXTRACTION : ");
        System.out.println(Stego.extract(outputFilePath));

    }

}
