package de.winzermuseum.java.photoshop.trans;

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
    for(int i=0; i<numCols; i++)
    {
      for(int j=0; j<numRows; j++)
      {
        Gray = input [j][i];
        Gray = Gray | 8355711;
        output [j][i]= Gray;
      }
    }

    return input;
  }
}


