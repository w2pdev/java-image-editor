package zone.informatik.java.graphics.trans;

import static java.lang.Math.*;
import static zone.informatik.java.graphics.utils.ColourModelRGB.getRed;
import static zone.informatik.java.graphics.utils.ColourModelRGB.getGreen;
import static zone.informatik.java.graphics.utils.ColourModelRGB.getBlue;
import static zone.informatik.java.graphics.utils.ColourModelRGB.getRGB;


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