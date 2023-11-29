package de.winzermuseum.java.photoshop.trans;

import static de.winzermuseum.java.photoshop.utils.ColourModelRGB.*;
import static java.lang.Math.round;


/**
 * Konvertierung eines Farbbildes in ein Graustufenbild
 * durch Mittelwertbildung
 */
public class GrayConverterAverage implements Transformer
{
  /**
   * {@inheritDoc}
   */
  @Override
  public int[][] apply(final int[][] input)
  {
    final int numRows = input.length;
    final int numCols = input[0].length;

    final int[][] output = new int[numRows][numCols];

    int Gray=0;
    for(int i=0; i<numRows; i++)
    {
      for(int j=0; j<numCols; j++)
      {
        int rgb_input = input[i][j];
        int red = getRed(rgb_input);
        int green = getGreen(rgb_input);
        int blue = getBlue(rgb_input);

        int rgb_output_1 = 0;
        rgb_output_1 = (red + green + blue)/3;
        int rgb_output;
        rgb_output = getRGB(rgb_output_1, rgb_output_1, rgb_output_1);

        output[i][j]=rgb_output;

      }
    }

    return output;
  }
}


