package de.winzermuseum.java.photoshop.utils;

import java.awt.image.BufferedImage;


/**
 * Konverter für Pixeldaten
 */
public class ImageConverter
{
  /**
   * Konvertiert ein Bild vom Typ BufferedImage mit RGB-Daten
   * in ein 2D Array.
   *
   * @param image RGB-Bild
   * @return 2D Array mit RGB-Pixeldaten
   */
  public static int[][] toArrayRGB(final BufferedImage image)
  {
    final int numRows = image.getHeight();
    final int numCols = image.getWidth();

    final int[][] pixels = new int[numRows][numCols];

    for (int i = 0; i < numRows; i++)
    {
      for (int j = 0; j < numCols; j++)
      {
        pixels[i][j] = image.getRGB(j, i);
      }
    }

    return pixels;
  }


  /**
   * Konvertiert ein 2D Array mit RGB-Werten in ein Bild vom Typ
   * BufferedImage
   *
   * @param pixels 2D Array mit RGB-Werten
   * @return RGB-Bild
   */
  public static BufferedImage toBufferedImage(final int[][] pixels)
  {
    final int numRows = pixels.length;
    final int numCols = pixels[0].length;

    final BufferedImage image = new BufferedImage(
        numCols, numRows, BufferedImage.TYPE_INT_RGB);

    for (int i = 0; i < numRows; i++)
    {
      for (int j = 0; j < numCols; j++)
      {
        image.setRGB(j, i, pixels[i][j]);
      }
    }

    return image;
  }
}


