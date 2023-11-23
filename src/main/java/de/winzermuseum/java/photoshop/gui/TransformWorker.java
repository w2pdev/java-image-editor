package de.winzermuseum.java.photoshop.gui;

import de.winzermuseum.java.photoshop.utils.ImageConverter;
import de.winzermuseum.java.photoshop.trans.Transformer;

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


