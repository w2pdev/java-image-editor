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
    int Green=0;
    for(int i=0; i<numCols; i++)
    {
      for(int j=0; j<numRows; j++)
      {
        Green = input [j][i];
        Green = Green & 65280 ;
        output [j][i]= Green;
      }
    }

    return output;
  }
}


