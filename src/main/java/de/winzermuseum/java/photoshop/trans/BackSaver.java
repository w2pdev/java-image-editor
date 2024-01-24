package de.winzermuseum.java.photoshop.trans;

import de.winzermuseum.java.photoshop.utils.ImageConverter;

import java.awt.image.BufferedImage;

public class BackSaver
{
  static  BufferedImage bufferedImage;
  public static int[][] getImage()
  {
    int[][] output = new int[0][0];
    output = ImageConverter.toArrayRGB(bufferedImage);
    System.out.println("Hi");
    return output;

  }
  




}

