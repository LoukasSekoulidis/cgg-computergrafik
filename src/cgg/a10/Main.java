package cgg.a10;

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
    Camera camera = new Camera(width, height, Math.PI / 3, multiply( Matrix.translation(0, 12, 0), Matrix.rotation(1, 0, 0, -90)));

    Texture backgroundTx = new Texture("./doc/back.jpg");
    TextureTransform backgrTextureTransform = new TextureTransform(backgroundTx, Matrix.scaling(3, 1, 0));
    Emissive backgroundMaterial = new Emissive(backgrTextureTransform);

    Texture sphereTx = new Texture("./doc/leather.jpg");
    DiffuseMaterial sphereMaterial = new DiffuseMaterial(sphereTx);


    Texture sphereTxRusty = new Texture("./doc/rusty.jpg");
    PolishedMaterial polishedMaterial = new PolishedMaterial(sphereTxRusty, true, 0.4);

    Texture groundTx = new Texture("./doc/boden.jpg");
    TextureTransform groundTT = new TextureTransform(groundTx, Matrix.scaling(100, 100, 100));
    DiffuseMaterial groundMaterial = new DiffuseMaterial(groundTT);

    Matrix matrix = Matrix.scaling(20, 10, 0);
    ConstantColor whiteConst = new ConstantColor(white);
    ConstantColor blackConst = new ConstantColor(color(1, 0.6, 0.6));
    PolkaDots polkaDots = new PolkaDots(whiteConst, blackConst, 0.5);
    TextureTransform transform = new TextureTransform(polkaDots, matrix);
    DiffuseMaterial tmp = new DiffuseMaterial(transform);
    TransmissiveMaterial rustyTransmissiveMaterial = new TransmissiveMaterial(transform, 1.5);

    Checkerboard checkerBoard3 = new Checkerboard(18, new ConstantColor(color(0.8, 0.2, 0.2)),
        new ConstantColor(color(0.2, 0.2, 0.8)));
    DiffuseMaterial diffusesMaterial3 = new DiffuseMaterial(checkerBoard3);
    Emissive emissiveMaterial = new Emissive(checkerBoard3);

    Sphere jupitSphere = new Sphere(point(-1.6, -0.5, 0), 1.5, sphereMaterial);
    Sphere testSphere = new Sphere(point(4.9, -0.5, 0), 1.5, diffusesMaterial3);
    Sphere testSphere2 = new Sphere(point(-4.9, -0.5, 0), 1.5, polishedMaterial);
    Sphere dirtyGlasSphere = new Sphere(point(1.6, -0.5, -0), 1.5, tmp);
    Plane plane = new Plane(point(0, -2, -20), direction(0, 1, 0), 1000.0, groundMaterial);
    Background background = new Background(backgroundMaterial);

    scene.add(plane);
    scene.add(dirtyGlasSphere);
    scene.add(jupitSphere);
    scene.add(background);
    scene.add(testSphere);
    scene.add(testSphere2);

    Raytracing raytracing = new Raytracing(scene, camera, 4);

    Image image = new Image(width, height, 10);
    image.sample(raytracing);

    // Write the image to disk.
    final String filename = "doc/a10-2.png";
    image.write(filename);
    System.out.println("Wrote image: " + filename);
    long endTime = System.nanoTime();
    long totalTime = endTime - startTime;
    System.out.println((double) totalTime / 1000000000);
  }
}