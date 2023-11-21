package zone.informatik.java.graphics.gui;

import java.awt.image.BufferedImage;


/**
 * Proxy für ein Bild
 */
public interface ImageProxy
{
  /** Gibt das Bild zurück.
   *
   * @return Bild
   */
  BufferedImage getImage();


  /**
   * Überschreibt das Bild.
   *
   * @param image neues Bild.
   */
  void setImage(final BufferedImage image);
}


/*

This file is part of the zone.informatik.java.graphics.gui package.

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