package zone.informatik.java.graphics;

import zone.informatik.java.graphics.gui.ImageEditorGUI;

import java.awt.*;
import java.util.ResourceBundle;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


/** Hauptprogramm
 */
public class ImageEditor implements Runnable
{
  private static final ResourceBundle resources
      = ResourceBundle.getBundle("image-editor");


  /** {@inheritDoc}
   */
  @Override
  public void run()
  {
    new ImageEditorGUI(resources);
  }


  /** Startet das Bildbearbeitungsprogramm.
   *
   * @param args nicht verwendet
   */
  public static void main(final String[] args)
  {
    setLookAndFeel();
    SwingUtilities.invokeLater(new ImageEditor());
  }


  /**
   * Installiert ein Dark Theme auf Basis von Nimbus.
   */
  private static void setLookAndFeel()
  {
    try
    {
      UIManager.setLookAndFeel(new NimbusLookAndFeel());

      UIManager.put("control", new Color(48, 48, 48));
      UIManager.put("info", new Color(48, 48, 48));
      UIManager.put("nimbusBase", new Color(18, 30, 49));
      UIManager.put("nimbusAlertYellow", new Color(248, 187, 0));
      UIManager.put("nimbusDisabledText", new Color(128, 128, 128));
      UIManager.put("nimbusFocus", new Color(115,164,209));
      UIManager.put("nimbusGreen", new Color(176,179,50));
      UIManager.put("nimbusInfoBlue", new Color(66, 139, 221));
      UIManager.put("nimbusLightBackground", new Color(18, 30, 49));
      UIManager.put("nimbusOrange", new Color(191,98,4));
      UIManager.put("nimbusRed", new Color(169,46,34));
      UIManager.put("nimbusSelectedText", new Color(255, 255, 255));
      UIManager.put("nimbusSelectionBackground", new Color(104, 93, 156));
      UIManager.put("text", new Color(230, 230, 230));
    }
    catch (UnsupportedLookAndFeelException e)
    {
      System.err.println(resources.getString("error.theme"));
    }
  }
}


/*

This file is part of the zone.informatik.java.graphics package.

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