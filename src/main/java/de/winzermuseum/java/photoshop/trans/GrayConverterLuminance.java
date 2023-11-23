package de.winzermuseum.java.photoshop.trans;


/**
 * Konvertierung eines Farbbildes in ein Graustufenbild
 * mit Gammakorrektur
 */
public class GrayConverterLuminance implements Transformer
{
  private static final double GAMMA = 2.2;
  private static final double GAMMA_INV = 1.0 / GAMMA;
  private static final double WEIGHT_RED   = 0.2126;
  private static final double WEIGHT_GREEN = 0.7152;
  private static final double WEIGHT_BLUE  = 0.0722;


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


