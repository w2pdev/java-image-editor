package de.winzermuseum.java.photoshop.trans;


import java.security.PublicKey;
import java.util.Scanner;

/**
 * Extraktion des grünen Farbkanals
 */
public class ExtractorGreen implements Transformer
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

    return output;
  }
}


