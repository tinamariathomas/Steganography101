package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

public class Image {

    int pixelMatrix[][];
    private int length, width;

    Image(String filePath) throws IOException {

        File file = new File(filePath);// file object to get the file, the second argument is the name of the image file
        BufferedImage image = ImageIO.read(file);
        Raster image_raster = image.getData();

        //get pixel by pixel
        int[] pixel = new int[1];
        int[] buffer = new int[1];

        // declaring the size of arrays
        pixelMatrix = new int[image_raster.getWidth()][image_raster.getHeight()];

        //get the image in the array
        for (int i = 0; i < image_raster.getWidth(); i++)
            for (int j = 0; j < image_raster.getHeight(); j++) {
                pixel = image_raster.getPixel(i, j, buffer);
                pixelMatrix[i][j] = pixel[0];
            }
        length = pixelMatrix.length;
        width = pixelMatrix[0].length;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
}
