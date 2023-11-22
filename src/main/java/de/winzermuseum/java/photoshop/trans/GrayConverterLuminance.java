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


/*

This file is part of the zone.informatik.java.graphics.trans package.

Copyright (C) 2023 Matthias Ebert

This package is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

The package is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with the package.  If not, see <http://www.gnu.org/licenses/>.

*/