package zone.informatik.java.graphics.gui;

import zone.informatik.java.graphics.trans.Transformer;
import zone.informatik.java.graphics.utils.ImageConverter;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import java.awt.image.BufferedImage;
import java.util.ResourceBundle;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;


/**
 * Prozess zur Transformation eines Bildes im Hintergrund
 */
public class TransformWorker extends SwingWorker<BufferedImage, Void>
{
  private final ImageProxy imageProxy;
  private final Transformer transformer;
  private final ResourceBundle resources;


  /**
   * Erzeugt einen Prozess zur Transformation eines Bildes.
   *
   * @param imageProxy Proxy für das zu transformierende Bild
   * @param transformer Implementierung des Algorithmus zur Transformation
   * @param resources Ressourcen-Bundle
   */
  public TransformWorker(final ImageProxy imageProxy,
                         final Transformer transformer,
                         final ResourceBundle resources)
  {
    this.imageProxy = imageProxy;
    this.transformer = transformer;
    this.resources = resources;
  }


  /**
   * Transformiert das Bild im Hintergrund.
   */
  @Override
  protected BufferedImage doInBackground()
  {
    final BufferedImage image = imageProxy.getImage();

    final int[][] input = ImageConverter.toArrayRGB(image);
    final int[][] output = transformer.apply(input);

    return ImageConverter.toBufferedImage(output);
  }


  /**
   * Stellt im Erfolgsfall das Bild in dem entsprechenden Panel dar.
   * Zeigt anderenfalls Informationen über die aufgetretene Ausnahme in
   * einem modalen Dialog an.
   */
  @Override
  protected void done()
  {
    try
    {
      final BufferedImage image = get();
      imageProxy.setImage(image);
    }
    catch (final ExecutionException exception)
    {
      final Throwable rootCause = getRootCause(exception);
      final StackTraceElement[] stackTrace = rootCause.getStackTrace();

      final StringBuilder messageBuilder = new StringBuilder();
      messageBuilder.append(rootCause.getMessage());

      if (stackTrace.length > 0)
      {
        final StackTraceElement topElem = stackTrace[0];

        messageBuilder.append("\n").append(topElem.getFileName());
        messageBuilder.append(", line ").append(topElem.getLineNumber());
      }

      JOptionPane.showMessageDialog(
          null,
          messageBuilder.toString(),
          resources.getString("error.title"),
          JOptionPane.ERROR_MESSAGE);
    }
    catch (final InterruptedException | CancellationException ignored)
    {
    }
  }


  /**
   * Ermittelt den Ursprung einer Ausnahme.
   *
   * @param throwable zu untersuchende Ausnahme
   * @return Ausnahme, welche den Ursprung darstellt
   */
  private static Throwable getRootCause(Throwable throwable)
  {
    while (throwable.getCause() != null)
    {
      throwable = throwable.getCause();
    }

    return throwable;
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