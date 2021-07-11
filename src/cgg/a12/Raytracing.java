package cgg.a12;

import cgtools.*;

import static cgtools.Color.*;

public class Raytracing implements Sampler {
    World world;
    Camera camera;
    int depthRec;

    public Raytracing(World world, Camera camera, int depthRec) {
        this.world = world;
        this.camera = camera;
        this.depthRec = depthRec;
    }

    public Color getColor(double x, double y) {
        Ray ray = camera.Strahl(x, y);
        return calculateRadiance(ray, world, depthRec);
    }

    public Color calculateRadiance(Ray ray, World world, int depth) {
        if (depth == 0) {
            return black;
        }
        Hit hit = world.scene.intersect(ray);
        Material properties = hit.getMaterial();
        Ray scatteredRay = properties.scatteredRay(ray, hit);
        if (scatteredRay == null) {
            return properties.emission(hit);
        } else {

            Color emission = properties.emission(hit);
            Color albedo = properties.albedo(hit);

            Color directLight = black;
            for (Light l : world.lights) {
                directLight = add(directLight, l.incomingIntensity(hit, world.scene));
            }

            Color incomingLight = add(directLight, calculateRadiance(scatteredRay, world, depth - 1));
            Color reflectedLight = multiply(incomingLight, albedo);
            Color completeLight = add(emission, reflectedLight);
            return completeLight;
        }
    }
}