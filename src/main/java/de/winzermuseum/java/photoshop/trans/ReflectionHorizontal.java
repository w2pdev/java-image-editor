package de.winzermuseum.java.photoshop.trans;


/**
 * Spiegelung des Bildes in horizontaler Richtung
 */
public class ReflectionHorizontal implements Transformer
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

    for (int i = 0; i < numRows; i++){
      for (int j = 0; j < numCols; j++){
        output[i][numCols - (j +1)] = input [i] [j];

      }
    }

    return output;
  }
}


