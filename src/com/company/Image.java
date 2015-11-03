package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class Image {

    private int pixelMatrix[][];
    private int height, width;
    BufferedImage image;

    Image(String filePath) throws IOException {

        File file = new File(filePath);
        image = ImageIO.read(file);
        Raster image_raster = image.getData();

        int[] pixel = new int[1];
        int[] buffer = new int[1];

        pixelMatrix = new int[image_raster.getWidth()][image_raster.getHeight()];

        for (int i = 0; i < image_raster.getWidth(); i++)
            for (int j = 0; j < image_raster.getHeight(); j++) {
                pixel = image_raster.getPixel(i, j, buffer);
                pixelMatrix[i][j] = pixel[0];
            }
        height = pixelMatrix.length;
        width = pixelMatrix[0].length;
    }

    public int getHeight() {
        return height;
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

    public void setLSBPixelAt(int x, int y, char newPixelValue) {
        if (newPixelValue == '0' || newPixelValue == '1') {
            pixelMatrix[x][y] = Binary.setLSBValue(pixelMatrix[x][y], newPixelValue);
        }
    }

    public char getLSBPixelAt(int x, int y) {
        return Binary.getLSBValue(pixelMatrix[x][y]);
    }

    public void writeAsImageToFile(String filePath) throws IOException {

        int pixelMatrixFlattened[] = new int[getHeight() * getWidth()];

        int k = 0;

        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                pixelMatrixFlattened[k++] = pixelMatrix[j][i];
            }
        }

        BufferedImage pixelImage = new BufferedImage(height, width, BufferedImage.TYPE_BYTE_GRAY);

        WritableRaster raster = (WritableRaster) pixelImage.getData();
        raster.setPixels(0, 0, height, width, pixelMatrixFlattened);
        pixelImage.setData(raster);

        ImageIO.write(pixelImage, "png", new File(filePath));
    }
}
