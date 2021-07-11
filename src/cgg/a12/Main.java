package cgg.a12;

import cgg.*;
import cgtools.Matrix;

import static cgtools.Vector.*;
import java.util.concurrent.ExecutionException;

import static cgtools.Color.*;
import static cgtools.Matrix.*;

public class Main {

  public static void main(String[] args) throws InterruptedException, ExecutionException { 
    int time = 30;
    long startTime = System.nanoTime();
    final int width = 1280;
    final int height = 720;
    Camera camera = new Camera(width, height, Math.PI / 3, multiply(translation(direction(0, 4, 6)), rotation(xAxis, -30)));
    
    ConstantColor greenCC = new ConstantColor(color(0.3, 0.9, 0.3));
    DiffuseMaterial greenDM = new DiffuseMaterial(greenCC);
    
    ConstantColor blackCC = new ConstantColor(black);
    Emissive blackEM = new Emissive(blackCC);
    DiffuseMaterial blackDM = new DiffuseMaterial(blackCC);
    

    ConstantColor whiteCC = new ConstantColor(white);
    DiffuseMaterial whiteDM = new DiffuseMaterial(whiteCC);
    
    Background background = new Background(blackEM);
    Sphere sphere = new Sphere(point(0, 0, 0), 1, greenDM);
    
    Plane plane = new Plane(point(0, 0, 0), direction(0, 1, 0), whiteDM);
    Group sphereGroup = new Group(translation(direction(0, 0, 0)), background, sphere);

    Group planeGroup = new Group(translation(direction(0, -0.5, 0)), plane, background);

    Mover mover = new Mover(sphereGroup, 0, 30, direction(-5.3, 2, 0), direction(5.3, -1, 0));

    // Rotor rotor = new Rotor(camera, yAxis, 180, 0);

    Light point = new PointLight(point(0, 4, 3), 7,7,7);
    Group scene = new Group(sphereGroup, background, planeGroup);

    Raytracing raytracing = new Raytracing(new World(scene, point), camera, 4);

    Image image = new Image(width, height, 10);
    
    for(int i = 0; i < time+1 ; i++){
      mover.update(i);
      image.sample(raytracing);
      final String filename = "doc/anim/img-" + i + ".png";
      image.write(filename);
      System.out.println("Wrote image: " + filename);

    }
    
    
    

    // Write the image to disk.
    long endTime = System.nanoTime();
    long totalTime = endTime - startTime;
    System.out.println((double) totalTime / 1000000000);
  }
}