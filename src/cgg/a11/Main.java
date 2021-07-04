package cgg.a11;

import cgg.*;
import cgtools.Matrix;

import static cgtools.Vector.*;
import java.util.concurrent.ExecutionException;
import static cgtools.Color.*;
import static cgtools.Matrix.*;

public class Main {

  public static void main(String[] args) throws InterruptedException, ExecutionException { // Idee : Star Wars
                                                                                           // Szene!!!!! Schiff schießt
                                                                                           // Laser (Emissive) auf
                                                                                           // Planeten (textur) mit
                                                                                           // weltall hintegrund
                                                                                           // (textur) und sonne
                                                                                           // (emmisive textur)
    long startTime = System.nanoTime();
    final int width = 1280;
    final int height = 720;
    Group scene = new Group();
    Group gGroup = new Group(multiply(translation(0, -1.5, 0),rotation(xAxis, 0)));
    Camera camera = new Camera(width, height, Math.PI / 3, multiply(Matrix.rotation(yAxis, -20) ,Matrix.translation(-2, 10, 11), Matrix.rotation(1, 0, 0, -45)));

    ConstantColor grayCC = new ConstantColor(gray);
    DiffuseMaterial grayDM = new DiffuseMaterial(grayCC);
    ConstantColor whiteCC = new ConstantColor(white);
    ConstantColor blackCC = new ConstantColor(black);
    ConstantColor darkGreyCC = new ConstantColor(color(0.9, 0.9, 0.9));
    Emissive whiteE = new Emissive(whiteCC);
    Emissive grayE = new Emissive(darkGreyCC);
    Emissive blackE = new Emissive(blackCC);
    Background background1 = new Background(blackE);

    Sphere sphere1 = new Sphere(point(-4, 0, -0.5), 1.5, grayDM);
    Sphere sphere2 = new Sphere(point(0, 0, -4.5), 1.5, grayDM);
    Sphere sphere3 = new Sphere(point(4, 0, -0.5), 1.5, grayDM);
    Sphere sphere4 = new Sphere(point(0, 0, 3.5), 1.5, grayDM);
    scene.add(sphere1);
    scene.add(sphere2);
    scene.add(sphere3);
    scene.add(sphere4);

    Plane plane1 = new Plane(point(0, 0, 0), direction(0, 1, 0), 1000.0, grayDM);
    gGroup.add(plane1);
    gGroup.add(background1);

    scene.add(gGroup);
    scene.add(background1);

    Light lightR = new DirectionLight(direction(1.8, 2, 1.8), color(0.10,0.85,1.00));
    // Light lightPointB = new PointLight(point(0, 2, 0), 9, 3, 9);

    Raytracing raytracing = new Raytracing(new World(scene, lightR), camera, 4);

    Image image = new Image(width, height, 10);
    image.sample(raytracing);

    // Write the image to disk.
    final String filename = "doc/a11-2.png";
    image.write(filename);
    System.out.println("Wrote image: " + filename);
    long endTime = System.nanoTime();
    long totalTime = endTime - startTime;
    System.out.println((double) totalTime / 1000000000);
  }
}