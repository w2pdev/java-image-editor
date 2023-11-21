package zone.informatik.java.graphics.trans;


/**
 * Rotation in mathematisch negativer Richtung um 90 Grad
 */
public class RotationRight implements Transformer
{
  /**
   * {@inheritDoc}
   */
  @Override
  public int[][] apply(final int[][] input)
  {
    // bezogen auf das transformierte Bild
    final int numRows = input[0].length;
    final int numCols = input.length;

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