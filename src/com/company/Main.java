package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Image image = new Image("/Users/tinamt/Desktop/puppy1.jpg");
        System.out.println(image.getLength());
        System.out.println(image.getWidth());

        for (int i = 0; i < image.getLength(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                image.setPixelAt(i, j, image.getPixelAt(i, j));
            }
        }
        image.writeAsImageToFile("/Users/tinamt/Desktop/output4.jpg");
    }
}
