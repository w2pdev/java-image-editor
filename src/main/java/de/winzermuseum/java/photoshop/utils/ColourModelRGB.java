package de.winzermuseum.java.photoshop.utils;


/**
 * RGB-Farbmodell mit 24 Bit Farbtiefe.
 * Rot-, Grün- und Blauanteil sind als natürliche Zahlen im Bereich
 * von 0 bis 255 codiert.
 * RGB-Farbwerte sind als natürliche Zahlen vom Typ int codiert,
 * wobei der Rot-, Grün- sowie Blauanteil im dritten, zweiten
 * beziehungsweise ersten Byte von rechts gespeichert sind.
 */
public class ColourModelRGB
{
  /**
   * Bestimmt den Rot-Anteil aus einem RGB-Wert.
   *
   * @param rgb RGB-Wert
   * @return Rot-Anteil
   */
  public static int getRed(final int rgb)
  {
    return (rgb >> 16) & 0xFF;
  }


  /**
   * Bestimmt den Grün-Anteil aus einem RGB-Wert.
   *
   * @param rgb RGB-Wert
   * @return Grün-Anteil
   */
  public static int getGreen(final int rgb)
  {
    return (rgb >> 8) & 0xFF;
  }


  /**
   * Bestimmt den Blau-Anteil aus einem RGB-Wert.
   *
   * @param rgb RGB-Wert
   * @return Blau-Anteil
   */
  public static int getBlue(final int rgb)
  {
    return rgb & 0xFF;
  }


  /**
   * Bestimmt ein RGB-Wert aus dem Rot-, Grün- und Blau-Anteil.
   *
   * @param red Rot-Anteil
   * @param green Grün-Anteil
   * @param blue Blau-Anteil
   * @return RGB-Wert
   */
  public static int getRGB(final int red, final int green, final int blue)
  {
    assert red   >= 0 && red   <= 0xFF;
    assert green >= 0 && green <= 0xFF;
    assert blue  >= 0 && blue  <= 0xFF;

    return (red << 16) | (green << 8) | blue;
  }
}


/*

This file is part of the zone.informatik.java.graphics.utils package.

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