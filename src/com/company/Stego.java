package com.company;

import java.io.IOException;

public class Stego {
    static public void embed(String message,String coverFilePath,String outputFilePath) throws IOException {
        String dataToHide = Converter.textToBinaryString(message);
        Image image = new Image(coverFilePath);
        int k = 0;
        try {
            for (int i = 0; i < image.getHeight(); i++) {
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
    }

    static public String extract(String outputFilePath) throws IOException {
        int k = 0;

        Image image = new Image(outputFilePath);
        StringBuilder output1 = new StringBuilder();

        try {
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    output1.append(image.getLSBPixelAt(i, j));
                    k = k + 1;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        } finally {
            return Converter.binaryStringToText(output1.toString());
        }
    }
}
