package cgg.a09;

import cgtools.*;

import static cgtools.Color.*;

public class Raytracing implements Sampler {
    Group scene;
    Camera camera;
    int depthRec;

    public Raytracing(Group scene, Camera camera, int depthRec) {
        this.scene = scene;
        this.camera = camera;
        this.depthRec = depthRec;
    }

    public Color getColor(double x, double y) {
        Ray ray = camera.Strahl(x, y);
        return calculateRadiance(ray, scene, depthRec);
    }

    public Color calculateRadiance(Ray ray, Group scene, int depth) {
        if (depth == 0) {
            return black;
        }
        Hit hit = scene.intersect(ray);
        Material properties = hit.getMaterial();
        Ray scatteredRay = properties.scatteredRay(ray, hit);
        if (scatteredRay == null) {
            return properties.emission(ray, hit);
        } else {
            Color emission = properties.emission(ray, hit);
            Color albedo = properties.albedo(ray, hit);
            Color add = add(emission, albedo);
            return multiply(add, calculateRadiance(scatteredRay, scene, depth - 1));
        }
    }
}

// package cgg.a09 ;

// import cgtools.*;

// import static cgtools.Color.*;

// import java.util.concurrent.Callable;
// import java.util.concurrent.ExecutorService;
// import java.util.concurrent.Executors;
// import java.util.concurrent.Future;

// public class Raytracing implements Sampler{
// Group scene;
// Camera camera;
// int depthRec;
// ExecutorService pool;

// public Raytracing(Group scene, Camera camera, int depthRec){
// this.scene = scene;
// this.camera = camera;
// this.depthRec = depthRec;
// pool = Executors.newFixedThreadPool(4);
// }

// public Color getColor(double x, double y) {
// Ray ray = camera.Strahl(x, y);
// Callable<Color> calculateOneSample = new Callable<Color>(){
// public Color call() {
// return calculateRadiance(ray, scene, depthRec);
// }
// };
// Future<Color> sample = pool.submit(calculateOneSample);
// try {
// return sample.get();
// } catch (Exception e) {
// e.printStackTrace();
// }
// return null;
// }

// public Color calculateRadiance(Ray ray, Group scene, int depth){
// if(depth == 0){ return black;}
// Hit hit = scene.intersect(ray);
// Material properties = hit.getMaterial();
// Ray scatteredRay = properties.scatteredRay(ray, hit);
// if(scatteredRay == null){
// return properties.emission(ray, hit);
// } else {
// Color emission = properties.emission(ray, hit);
// Color albedo = properties.albedo(ray, hit);
// Color add = add(emission, albedo);
// return multiply(add, calculateRadiance(scatteredRay, scene, depth-1));
// }
// }
// }