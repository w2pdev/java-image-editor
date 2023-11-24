package de.winzermuseum.java.photoshop.trans;


/**
 * Extraktion des blauen Farbkanals
 */
public class ExtractorBlue implements Transformer
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
    int Blue=0;
    for(int i=0; i<numCols; i++)
    {
      for(int j=0; j<numRows; j++)
      {
        Blue = input [j][i];
        Blue = Blue & 255 ;
        output [j][i]= Blue;
      }
    }

    return output;
  }
}


