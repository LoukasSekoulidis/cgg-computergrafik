package cgg.a03;

import cgg.*;
import cgtools.Vector;
public class Main {

  public static void main(String[] args) {
    final int width = 480;
    final int height = 270;
    Lochkamera test = new Lochkamera(Math.PI/2, 10, 10, Vector.point(0, 0, 0));
    Ray testRay = test.Strahl(0, 0);
    System.out.println(testRay.x0);
    System.out.println(testRay.d);

    // This class instance defines the contents of the image.
    // ColoredDiscs content = new ColoredDiscs(white, 75, width, height);
    Image image = new Image(width, height, 10);
    // image.sample(content);

    // Write the image to disk.
    // final String filename1 = "doc/a02-discs.png";
    final String filename = "doc/a02-discs-supersampling.png";
    image.write(filename);
    System.out.println("Wrote image: " + filename);
  }
}
