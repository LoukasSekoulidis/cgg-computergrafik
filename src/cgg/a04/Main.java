package cgg.a04;

import cgg.*;
import cgtools.Random;

import cgtools.*;
import java.util.ArrayList;
import static cgtools.Vector.*;
import static cgtools.Color.*;

public class Main { 

  public static void main(String[] args) {
    final int width = 480;
    final int height = 270;

    // ArrayList<Shape> shapes = new ArrayList<Shape>();

    // Lochkamera camera = new Lochkamera(width, height, Math.PI/2);
    // Shape background = new Background(divide(color(170, 216, 230) , 255.0));
    // Shape ground = new Plane(point(0.0, -0.5, 0.0), direction(0, 1, 0), divide(color(126, 200, 80), 255.0));
    // Shape globe1 = new Kugel(point(-1.0, -0.25, -2.5), 0.7, divide(color(100, 65, 60), 255.0));
    // Shape globe2 = new Kugel(point(0.0, -0.25, -2.5), 0.5, divide(color(80, 45, 20), 255.0));
    // Shape globe3 = new Kugel(point(1.0, -0.25, -2.5), 0.7, divide(color(60, 25, 40), 255.0));
    
    // shapes.add(background);
    // shapes.add(ground);
    // shapes.add(globe1);
    // shapes.add(globe2);
    // shapes.add(globe3);
    
    // Group scene1 = new Group(shapes);
    // Raytracing raytracing = new Raytracing(scene1, camera);
    
    // Image image = new Image(width, height, 10);
    // image.sample(raytracing);

    ArrayList<Shape> shapes2 = new ArrayList<Shape>();

    Lochkamera camera2= new Lochkamera(width, height, Math.PI/5);
    Shape background2 = new Background(divide(color(3,2,18), 255.0));
    Shape globe11 = new Kugel(point(0, 0, -60.0), 6.0, divide(color(127, 255, 212), 255.0));
    Shape globe12 = new Kugel(point(12, 10, -65.0), 1.0, divide(color(255, 255, 255), 255.0));
    Shape ground12 = new Plane(point( 0, 0, -60.0), direction(0.9, 1, 0.5), divide(color(210, 105, 30), 255.0), 10.0);
    for(int i = 0; i < 150; i++){
      double xTmp1 = Random.random()*640 - 320;
      double yTmp1 = Random.random()*360 - 180;
      double zTmp1 = Random.random()*500 + 500;
      double size1 = Random.random()*1 + 1;
      double r1 = Random.random() + 0.5;
      double g1 = Random.random() + 0.5; 
      double b1 = Random.random();
      Color tmpColor = color(r1, g1, b1);
      Shape globeb1 = new Kugel(point(xTmp1, yTmp1 , -zTmp1), size1, tmpColor);
      shapes2.add(globeb1);
    }
    shapes2.add(background2);
    shapes2.add(globe11);
    shapes2.add(globe12);
    shapes2.add(ground12);

    Group scene12 = new Group(shapes2);
    Raytracing raytracing2 = new Raytracing(scene12, camera2);

    Image image2 = new Image(width, height, 10);
    image2.sample(raytracing2);

    // Write the image to disk.
    final String filename = "doc/a04-scene.png";
    image2.write(filename);
    System.out.println("Wrote image: " + filename);
  }
}

// Test für Kamera , Ray & Hit -- alles ok
    // Lochkamera test = new Lochkamera(10,10, Math.PI/2);
    // Ray testRay = test.Strahl(0, 0);
    // // System.out.println(testRay.x0.toString());
    // // System.out.println(testRay.d.toString());
    
    // Ray testKugelRay = new Ray(point(0, 0, 0), direction(0, 0, -1), 0, Double.POSITIVE_INFINITY);
    // Kugel testKugel = new Kugel(point(0, -1, -2), 1.0, black);
    // Hit hit = testKugel.intersect(testKugelRay);
    // System.out.println(hit.x.toString());
    // System.out.println(hit.n.toString());