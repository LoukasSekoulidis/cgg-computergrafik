package cgg.a05;

import cgg.*;
import java.util.ArrayList;
import static cgtools.Vector.*;
import static cgtools.Color.*;

public class Main { 

  public static void main(String[] args) {
    final int width = 1280*2;
    final int height = 720*2;

    ArrayList<Shape> shapes = new ArrayList<Shape>();

    Lochkamera camera = new Lochkamera(width, height, Math.PI/3);
    Shape background  = new Background(new BackgroundMaterial(white));
    Shape ground = new Plane(point( 0, -0.5, 0), direction(0, 1, 0), new DiffuseMaterial(color(0.8, 0.8, 0.8)));
    
    Shape globeLotte = new Kugel(point(-2, 1.5, -7), 0.5, new DiffuseMaterial(color(0.5, 0.8, 0.8)));
    Shape planeLotte = new Plane(point(-2, 1.5, -7), direction(1, 3, 1), 0.75 ,new DiffuseMaterial(color(0.5, 0.1, 0.1)));
    Shape planeLotte1 = new Plane(point(-2, 1.5, -7), direction(3, 1, 1), 0.75 ,new DiffuseMaterial(color(0.5, 0.1, 0.1)));
    
    shapes.add(globeLotte);
    shapes.add(planeLotte);
    shapes.add(planeLotte1);

    Shape globe = new Kugel(point(-1.5, 0, -5), 0.5, new DiffuseMaterial(color(0.6, 0.6, 0.9)));
    Shape plane = new Plane(point(-1.5, 0, -5), direction(1, 4, 1), 0.75 ,new DiffuseMaterial(color(0.0, 0.1, 0.0)));
    
    Shape globe1 = new Kugel(point(0.5, 0.5, -9), 1, new DiffuseMaterial(color(0.2, 0.8, 1)));
    Shape globe2 = new Kugel(point(0.75, 0, -8), 0.5, new DiffuseMaterial(color(0.5, 0.5, 1)));
    Shape globe3 = new Kugel(point(0.25, -0.25, -7.5), 0.25, new DiffuseMaterial(color(0.8, 0.8, 0.2)));
    
    Shape planeZ = new Plane(point(2, -0.2, -6), direction(0, 1, 0), 1.25 , new DiffuseMaterial(color(0.4, 1, 0.4)));
    Shape planeA = new Plane(point(2, 0.1, -6), direction(0, 1, 0), 1.0 , new DiffuseMaterial(color(0.4, 1, 0.4)));
    Shape planeB = new Plane(point(2, 0.4, -6), direction(0, 1, 0), 0.75, new DiffuseMaterial(color(0.4, 1, 0.4)));
    Shape planeC = new Plane(point(2, 0.7, -6), direction(0, 1, 0), 0.5, new DiffuseMaterial(color(0.4, 1, 0.4)));
    Shape planeD = new Plane(point(2, 1, -6), direction(0, 1, 0), 0.25, new DiffuseMaterial(color(0.4, 1, 0.4)));
    Shape globeTop = new Kugel(point(2, 1.3, -6), 0.05, new DiffuseMaterial(color(0.4, 1, 0.4)));

    Shape globeFront = new Kugel(point(-0.30, -0.25, -3), 0.25, new DiffuseMaterial(color(1, 0.5, 0.25)));

    shapes.add(background);
    shapes.add(globe);
    shapes.add(plane);
    shapes.add(planeA);
    shapes.add(planeB);
    shapes.add(planeC);
    shapes.add(planeD);
    shapes.add(globeTop);
    shapes.add(planeZ);
    shapes.add(globe1);
    shapes.add(globe2);
    shapes.add(globe3);
    shapes.add(ground);
    shapes.add(globeFront);

    Group scene = new Group(shapes);
    Raytracing raytracing = new Raytracing(scene, camera, 4);

    Image image2 = new Image(width, height, 10);
    image2.sample(raytracing);

    // Write the image to disk.
    final String filename = "doc/a05-diffuse-spheres.png";
    image2.write(filename);
    System.out.println("Wrote image: " + filename);
  }
}