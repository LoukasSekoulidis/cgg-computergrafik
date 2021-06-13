package cgg.a06;

import cgg.*;

import java.util.ArrayList;
import static cgtools.Vector.*;
import static cgtools.Color.*;

public class Main { 

  public static void main(String[] args) {
    final int width = 1280*3;
    final int height = 720*3;

    ArrayList<Shape> shapes = new ArrayList<Shape>();

    Lochkamera camera = new Lochkamera(width, height, Math.PI/3);

    Shape background  = new Background(new DiffuseMaterial(white));
    shapes.add(background);

    Shape midGlobe = new Kugel(point(0, 0, -4), 1, new DiffuseMaterial(color(1, 1, 1))); 
    Shape midGlobeCoat = new Kugel(point(-0, -0, -4), 1.2, new TransmissiveMaterial(color(1, 1, 1), 1.5));   
    shapes.add(midGlobe);
    shapes.add(midGlobeCoat);

    Shape ballLeft = new Kugel(point(-2.5, 0, -4), 1, new BackgroundMaterial(color(1, 0.45, 0.25))); 
    Shape ballLeftCoat = new Kugel(point(-2.5, 0, -4), 1.2, new TransmissiveMaterial(color(1, 1, 1), 1.5)); 
    Shape ballRight = new Kugel(point(2.5, 0, -4), 1, new BackgroundMaterial(color(0.25, 0.45, 1))); 
    Shape ballRightCoat = new Kugel(point(2.5, 0, -4), 1.2, new TransmissiveMaterial(color(1, 1, 1), 1.5)); 
    shapes.add(ballLeft);
    shapes.add(ballRight);
    shapes.add(ballLeftCoat);
    shapes.add(ballRightCoat);

    Shape floor = new Plane(point(0, -1.5, 0), direction(0, 1, 0), new DiffuseMaterial(color(0, 1, 1)));
    Shape ceiling = new Plane(point(0, 1.5, 0), direction(0, -1, 0), new DiffuseMaterial(color(1, 1, 0)));
    shapes.add(floor);
    shapes.add(ceiling);

    Shape glassBallLeft = new Kugel(point(-0.5, -0, -1), 0.5, new TransmissiveMaterial(white, 1.5));
    Shape glassBallRight = new Kugel(point(0.5, -0, -1), 0.5, new TransmissiveMaterial(white, 1.5));
    // shapes.add(glassBallLeft);
    // shapes.add(glassBallRight);

    Group scene = new Group(shapes);
    Raytracing raytracing = new Raytracing(scene, camera, 6);

    Image image2 = new Image(width, height, 10);
    image2.sample(raytracing);

    // Write the image to disk.
    final String filename = "doc/lotte2.png";
    image2.write(filename);
    System.out.println("Wrote image: " + filename);
  }
}