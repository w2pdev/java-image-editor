package de.winzermuseum.java.photoshop.trans;

import de.winzermuseum.java.photoshop.utils.ColourModelRGB;

/**
 * Faltung des Bildes mit einer Filtermatrix
 */
public class Convolution implements Transformer {
  private final double[][] filter;
  private final double scaleFactor;

  public Convolution(double[][] filter, double scaleFactor) {
    this.filter = filter;
    this.scaleFactor = scaleFactor;
  }

  public int[][] apply(int[][] input) {
    int numRows = input.length;
    int numCols = input[0].length;
    int filterNumRows = this.filter.length;
    int filterNumCols = this.filter[0].length;
    int rowOffset = filterNumRows / 2;
    int colOffset = filterNumCols / 2;
    int maxRowIndex = numRows - (filterNumRows - rowOffset);
    int maxColIndex = numCols - (filterNumCols - colOffset);
    int[][] output = new int[numRows][numCols];

    for(int i = rowOffset; i <= maxRowIndex; ++i) {
      for(int j = colOffset; j <= maxColIndex; ++j) {
        double red = 0.0;
        double green = 0.0;
        double blue = 0.0;

        int k;
        int l;
        int rgb;
        for(k = 0; k < filterNumRows; ++k) {
          for(l = 0; l < filterNumCols; ++l) {
            rgb = input[i + k - rowOffset][j + l - colOffset];
            red += this.filter[k][l] * (double)ColourModelRGB.getRed(rgb);
            green += this.filter[k][l] * (double)ColourModelRGB.getGreen(rgb);
            blue += this.filter[k][l] * (double)ColourModelRGB.getBlue(rgb);
          }
        }

        red *= this.scaleFactor;
        green *= this.scaleFactor;
        blue *= this.scaleFactor;
        k = Math.min(Math.max((int)Math.round(red), 0), 255);
        l = Math.min(Math.max((int)Math.round(green), 0), 255);
        rgb = Math.min(Math.max((int)Math.round(blue), 0), 255);
        output[i][j] = ColourModelRGB.getRGB(k, l, rgb);
      }
    }

    return output;
  }
}


