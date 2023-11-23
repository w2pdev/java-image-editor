package de.winzermuseum.java.photoshop.trans;


/**
 * Rotation in mathematisch negativer Richtung um 90 Grad
 */
public class RotationRight implements Transformer
{
  /**
   * {@inheritDoc}
   */
  @Override
  public int[][] apply(final int[][] input)
  {
    // bezogen auf das transformierte Bild
    final int numRows = input[0].length;
    final int numCols = input.length;

    final int[][] output = new int[numRows][numCols];

    for (int i = 0; i < numCols; i++){
      for (int j = 0; j < numRows; j++){
        output[j][numCols - (i + 1)] = input [i] [j];
      }
    }

    return output;
  }
}


