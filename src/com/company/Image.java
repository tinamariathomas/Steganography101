package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class Image {

    int pixelMatrix[][];
    private int length, width;
    BufferedImage image;

    Image(String filePath) throws IOException {

        File file = new File(filePath);// file object to get the file, the second argument is the name of the image file
        image = ImageIO.read(file);
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

    public int getPixelAt(int x, int y) {
        return pixelMatrix[x][y];
    }

    public void setPixelAt(int x, int y, int newPixelValue) {
        pixelMatrix[x][y] = newPixelValue;
    }

    public void writeAsImageToFile(String filePath) throws IOException {

        int pixelMatrixFlattened[] = new int[getLength() * getWidth()];

        int k = 0;

        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getLength(); j++) {
                pixelMatrixFlattened[k++] = pixelMatrix[j][i];
            }
        }

        BufferedImage pixelImage = new BufferedImage(length, width, BufferedImage.TYPE_BYTE_GRAY);

        WritableRaster raster = (WritableRaster) image.getData();
        raster.setPixels(0, 0, length, width, pixelMatrixFlattened);
        pixelImage.setData(raster);

        ImageIO.write(pixelImage, "jpg", new File(filePath));
    }
}
