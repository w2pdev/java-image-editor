package de.winzermuseum.java.photoshop.trans;

import static de.winzermuseum.java.photoshop.utils.ColourModelRGB.*;

import static java.lang.Math.pow;


/**
 * ez geklaut
 */
public class GrayConverterLuminance implements Transformer
{
  private static final double GAMMA = 2.2;
  private static final double GAMMA_INV = 1.0 / GAMMA;
  private static final double WEIGHT_RED   = 0.2126;
  private static final double WEIGHT_GREEN = 0.7152;
  private static final double WEIGHT_BLUE  = 0.0722;


  /**
   * {@inheritDoc}
   */
  @Override
  public int[][] apply(final int[][] input)
  {
    final int numRows = input.length;
    final int numCols = input[0].length;

    final int[][] output = new int[numRows][numCols];

    for (int i = 0; i < numRows; i++)
    {
      for (int j = 0; j < numCols; j++)
      {
        // originaler RGB-Wert
        final int rgb = input[i][j];

        // Normalisierung und Gammakorrektur des R-, G- und B-Wertes
        final double red   = pow(getRed(rgb)   / 255.0, GAMMA);
        final double green = pow(getGreen(rgb) / 255.0, GAMMA);
        final double blue  = pow(getBlue(rgb)  / 255.0, GAMMA);

        // Berechnung der Luminanz
        final double luminance =
            WEIGHT_RED * red + WEIGHT_GREEN * green + WEIGHT_BLUE  * blue;

        // Gammakorrektur und Skalierung auf 8 Bit Farbtiefe
        final int gray = (int) (255.0 * pow(luminance, GAMMA_INV));
        final int grayRGB = getRGB(gray, gray, gray);

        // Grauwert in RGB-Darstellung
        output[i][j] = grayRGB;
      }
    }

    return output;
  }
}
