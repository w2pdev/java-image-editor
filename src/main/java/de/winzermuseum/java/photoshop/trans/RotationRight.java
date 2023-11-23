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

    // TODO

    return output;
  }
}


