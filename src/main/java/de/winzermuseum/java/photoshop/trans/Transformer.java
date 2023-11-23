package de.winzermuseum.java.photoshop.trans;

import java.util.function.UnaryOperator;


/**
 * Schnittstelle für Pixeloperationen
 */
public interface Transformer extends UnaryOperator<int[][]>
{
  /**
   * Transformiert eine Pixelgrafik.
   *
   * @param input 2D Array mit den originalen Pixelwerten
   * @return 2D Array mit den transformierten Pixelwerten
   */
  int[][] apply(final int[][] input);
}


