package zone.informatik.java.graphics.gui;

import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Panel zur Anzeige eines Bildes.
 */
public class ImagePanel extends JPanel implements ImageProxy
{
  private BufferedImage image = null;
  private final JLabel imageLabel = new JLabel();


  /**
   * Erzeugt ein Panel zur Anzeige eines Bildes.
   */
  public ImagePanel()
  {
    setLayout(new GridBagLayout());
    add(imageLabel);
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public BufferedImage getImage()
  {
    return image;
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public void setImage(final BufferedImage image)
  {
    this.image = image;
    imageLabel.setIcon(new ImageIcon(image));
  }

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