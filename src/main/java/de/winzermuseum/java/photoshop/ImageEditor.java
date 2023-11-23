package de.winzermuseum.java.photoshop;

import de.winzermuseum.java.photoshop.gui.ImageEditorGUI;

import java.awt.*;
import java.util.ResourceBundle;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


/** Hauptprogramm
 */
public class ImageEditor implements Runnable
{
  public static String [] inputargs = new String[3];
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
   * param args verwendet
   */
  public static void main(final String[] var0)


  {
    setLookAndFeel();
    SwingUtilities.invokeLater(new ImageEditor());
    for (int i = 0 ; i < var0.length; i++ ){
      inputargs[i] = var0[i];
      System.out.println(inputargs[i]);
    }
    ImageEditor myClass = new ImageEditor();
    inputargs = ImageEditor.inputargs;
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
