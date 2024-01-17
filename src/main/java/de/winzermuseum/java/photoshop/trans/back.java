package de.winzermuseum.java.photoshop.trans;
import java.util.Random;
import java.util.random.*;


public class back implements Transformer
{
  /**
   * {@inheritDoc}
   */
  @Override
  public int[][] apply(final int[][] input)
  {
    final int numRows = input.length;
    final int numCols = input[0].length;
    Random rand = new Random();
    int upperbound = 16777214;




    final int[][] output = new int[numRows][numCols];
    for(int i=0; i<numCols; i++)
    {
      for(int j=0; j<numRows; j++)
      {


        int int_random = rand.nextInt(upperbound);
        output [j][i]= int_random ;
      }
    }

    return output;
  }
}
