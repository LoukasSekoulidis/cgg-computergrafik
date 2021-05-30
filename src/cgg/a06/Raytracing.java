package cgg.a06;

import cgtools.*;

import static cgtools.Color.*;

public class Raytracing implements Sampler{
    Group scene;
    Lochkamera camera;
    int depthRec;

    public Raytracing(Group scene, Lochkamera camera, int depthRec){
        this.scene = scene;
        this.camera = camera;
        this.depthRec = depthRec;
    }

    public Color getColor(double x, double y) {
        Ray ray = camera.Strahl(x, y);
        return calculateRadiance(ray, scene, depthRec);
    }

    public Color calculateRadiance(Ray ray, Group scene, int depth){
        if(depth == 0){ return black;}
        Hit hit = scene.intersect(ray);
        Material properties = hit.getMaterial();
        Ray scatteredRay = properties.scatteredRay(ray, hit);
        if(scatteredRay == null){
            return properties.emission(ray, hit);
        } else {
            Color emission = properties.emission(ray, hit);
            Color albedo = properties.albedo(ray, hit);
            Color add = add(emission, albedo);
            return multiply(add, calculateRadiance(scatteredRay, scene, depth-1));
        }
    }
}
