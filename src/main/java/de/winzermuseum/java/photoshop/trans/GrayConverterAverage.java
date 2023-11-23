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

    // TODO

    return output;
  }
}


