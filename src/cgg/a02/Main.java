package cgg.a02;

import static cgtools.Color.*;

import cgg.*;
// for push with tag, forgot tag a01 while commit
public class Main {

  public static void main(String[] args) {
    final int width = 480;
    final int height = 270;

    // This class instance defines the contents of the image.
    ColoredDiscs content1 = new ColoredDiscs(white, 75, width, height);
    // PolkaDots content2 = new PolkaDots(green, width, height, 15, 10);

    // Creates an image and iterates over all pixel positions inside the image.
    Image image1 = new Image(width, height);
    // Image image2 = new Image(width, height);
    for (int x = 0; x != width; x++) {
      for (int y = 0; y != height; y++) {
        // Sets the color for one particular pixel.
        image1.setPixel(x, y, content1.getColor(x, y));
        // image2.setPixel(x, y, content2.getColor(x, y));
      }
    }

    // Write the image to disk.
    final String filename = "doc/a02-discs.png";
    // final String filename2 = "doc/a01-disc.png";
    image1.write(filename);
    // image2.write(filename2); 
    System.out.println("Wrote image: " + filename);
    // System.out.println("Wrote image: " + filename2);
  }
}
