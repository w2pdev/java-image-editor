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
  public int[][] apply(final int[][] input )
  {
    final int numRows = input.length;
    final int numCols = input[0].length;

    final int[][] output = new int[numRows][numCols];


    int Red=0;
    for(int i=0; i<numCols; i++)
    {
      for(int j=0; j<numRows; j++)
      {
        Red = input [j][i];
        Red = Red & 16711680 ;
        output [j][i]= Red;
      }
    }



    return output;
  }
}


