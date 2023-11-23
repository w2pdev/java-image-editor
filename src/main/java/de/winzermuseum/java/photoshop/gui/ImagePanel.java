package de.winzermuseum.java.photoshop.gui;

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


