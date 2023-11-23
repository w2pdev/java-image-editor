package de.winzermuseum.java.photoshop.trans;


/**
 * Rotation in mathematisch positiver Richtung um 90 Grad
 */
public class RotationLeft implements Transformer
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
        output[numRows - (j+1)][i] = input [i] [j];
      }
    }


    return output;
  }
}


