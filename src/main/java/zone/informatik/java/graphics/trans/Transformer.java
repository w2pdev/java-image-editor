package zone.informatik.java.graphics.trans;

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