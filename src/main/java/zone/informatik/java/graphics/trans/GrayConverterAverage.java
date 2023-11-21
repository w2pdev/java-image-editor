package zone.informatik.java.graphics.trans;

import static zone.informatik.java.graphics.utils.ColourModelRGB.getRed;
import static zone.informatik.java.graphics.utils.ColourModelRGB.getGreen;
import static zone.informatik.java.graphics.utils.ColourModelRGB.getBlue;
import static zone.informatik.java.graphics.utils.ColourModelRGB.getRGB;

import static java.lang.Math.round;


/**
 * Konvertierung eines Farbbildes in ein Graustufenbild
 * durch Mittelwertbildung
 */
public class GrayConverterAverage implements Transformer
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