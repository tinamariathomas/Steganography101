package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String message = "hello";
        String coverFilePath = "/Users/tinamt/Desktop/819679cf77816357ef7c056c606891d1.jpg";
        String outputFilePath = "/Users/tinamt/Desktop/output3.jpg";
        String dataToHide = Converter.convertUTFStringToBinary(message);
        Image image = new Image(coverFilePath);
        int k = 0;
        try {
            for (int i = 0; i < image.getLength(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    image.setLSBPixelAt(i, j, dataToHide.charAt(k));
                    k = k + 1;
                }
            }
        } catch (StringIndexOutOfBoundsException e) {
        } finally {

            StringBuffer output = new StringBuffer();
            image.writeAsImageToFile(outputFilePath);
        }

        k = 0;
        StringBuilder output = new StringBuilder();
        try {
            for (int i = 0; i < image.getLength(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    output.append(image.getLSBPixelAt(i, j));
                    k = k + 1;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        } finally {
            System.out.println(Converter.convertBinarytoString(output.toString()));
        }
    }
}
