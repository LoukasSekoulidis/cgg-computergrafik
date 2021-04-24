package cgg.a02;

import static cgtools.Color.*;

import cgg.*;
public class Main {

  public static void main(String[] args) {
    final int width = 480;
    final int height = 270;

    // This class instance defines the contents of the image.
    ColoredDiscs content = new ColoredDiscs(white, 75, width, height);
    Image image = new Image(width, height, 10);
    image.sample(content);

    // Write the image to disk.
    // final String filename1 = "doc/a02-discs.png";
    final String filename = "doc/a02-discs-supersampling.png";
    image.write(filename);
    System.out.println("Wrote image: " + filename);
  }
}
