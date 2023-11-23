package de.winzermuseum.java.photoshop.trans;


/**
 * Faltung des Bildes mit einer Filtermatrix
 */
public class Convolution implements Transformer
{
  private final double[][] filter;


  /**
   * Erzeugt eine Instanz, die ein Bild mit einer Filtermatrix
   * falten kann.
   *
   * @param filter Filtermatrix
   */
  public Convolution(final double[][] filter)
  {
    this.filter = filter;
  }


  /**
   * Skaliert die Filterkoeffizienten so, dass deren Summe 1 ist.
   */
  private void normalize()
  {
    final int numRows = filter.length;
    final int numCols = filter[0].length;

    double sum = 0.0;

    for (int i = 0; i < numRows; i++)
    {
      for (int j = 0; j < numCols; j++)
      {
        sum += filter[i][j];
      }
    }

    for (int i = 0; i < numRows; i++)
    {
      for (int j = 0; j < numCols; j++)
      {
        filter[i][j] /= sum;
      }
    }
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public int[][] apply(final int[][] input)
  {
    normalize();

    final int numRows = input.length;
    final int numCols = input[0].length;

    final int[][] output = new int[numRows][numCols];

    // TODO

    return output;
  }
}


