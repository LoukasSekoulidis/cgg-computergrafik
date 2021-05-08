package cgg.a03;

import cgg.*;
import cgtools.*;
import java.util.ArrayList;
import static cgtools.Vector.*;

public class Main { 

  public static void main(String[] args) {
    final int width = 720;
    final int height = 480;
    
    ArrayList<Kugel> kugelList = new ArrayList<>();

    Point pos = point(-145, -50, -700);
    int y = 70;
    int x = 100;
    Double radius = 75.0;
    Color clr = new Color(1.0, 0.3, 0.08);
    Color clrSub = new Color(1.0/40, 0.3/40, 0.08/40);

    for(int i = 0; i < 40; i++){
      Direction diff = direction(x, y, -350);
      kugelList.add(new Kugel(pos, radius, clr));
      clr = Color.subtract(clr, clrSub);
      pos = add(diff, pos);
      y -= 3.5;
      y -= 3.5;
      System.out.println(clr.toString());
   }

    Lochkamera finalCam = new Lochkamera(width, height, Math.PI/5);
    Raytracing finalRT = new Raytracing(kugelList, finalCam);

    Image image = new Image(width, height, 10);
    image.sample(finalRT);

    // Write the image to disk.
    // final String filename1 = "doc/a02-discs.png";
    final String filename = "doc/a03-three-spheres.png";
    image.write(filename);
    System.out.println("Wrote image: " + filename);
  }
}