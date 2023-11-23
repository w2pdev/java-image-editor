package de.winzermuseum.java.photoshop.gui;

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


