package de.winzermuseum.java.photoshop.trans;

public class TransformAlpha implements Transformer
{
  @Override
  public int[][] apply(int[][] input)
  {
    final int numRows = input.length;
    final int numCols = input[0].length;
    final int[][] output = new int[numRows][numCols];
    System.out.println("Hi");
    return output;



  }
}
