package cgg.a09;

import cgg.*;
import cgtools.Point;
import static cgtools.Vector.*;
import java.util.concurrent.ExecutionException;
import static cgtools.Color.*;
import static cgtools.Matrix.*;

public class Main {
  static Material rekKug = new DiffuseMaterial(color(1, 1, 0));

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    long startTime = System.nanoTime();
    final int width = 1000;
    final int height = 1000;
    Group scene = new Group();
    Camera camera = new Camera(width, height, Math.PI / 3, identity);
    Background back = new Background(new Emissive(white));
    scene.add(back);

    // scene.add(makeSpheres(point(0, 0, -10), 2));

    for (int i = 0; i < 10; i++) {
      scene.add(new Kugel(point(0 , 0, -5), 1, rekKug));
    }

    // Plane plane = new Plane(point(0, -1, -4), 1.0, new DiffuseMaterial(blue), false);
    // scene.add(plane);

    Raytracing raytracing = new Raytracing(scene, camera, 4);

    Image image = new Image(width, height, 10);
    image.sample(raytracing);

    // Write the image to disk.
    final String filename = "doc/a09-benchmark-scene.png";
    image.write(filename);
    System.out.println("Wrote image: " + filename);
    long endTime = System.nanoTime();
    long totalTime = endTime - startTime;
    System.out.println((double) totalTime / 1000000000);
  }

  // static Shape makeSpheres(Point position, int exponent) {
  //   if (exponent <= 0) {
  //     return new Kugel(position, 1, rekKug);
  //   } else {
  //     var offset = Math.pow(2.0, exponent) / 2;
  //     return new Group(makeSpheres(add(position, direction(-offset, 0, -offset)), exponent - 1),
  //         makeSpheres(add(position, direction(-offset, 0, +offset)), exponent - 1),
  //         makeSpheres(add(position, direction(+offset, 0, -offset)), exponent - 1),
  //         makeSpheres(add(position, direction(+offset, 0, +offset)), exponent - 1));
  //   }
  // }
}