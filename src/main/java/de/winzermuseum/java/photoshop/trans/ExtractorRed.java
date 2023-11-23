package de.winzermuseum.java.photoshop.trans;


/**
 * Extraktion des roten Farbkanals
 */
public class ExtractorRed implements Transformer
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


