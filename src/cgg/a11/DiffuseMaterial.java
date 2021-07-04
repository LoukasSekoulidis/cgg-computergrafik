package cgg.a11;

import cgtools.*;
import static cgtools.Vector.*;
import static cgtools.Random.*;

public class DiffuseMaterial implements Material {
    public Sampler texture;

    public DiffuseMaterial(Sampler texture) {
        this.texture = texture;
    }

    public Ray scatteredRay(Ray incomingRay, Hit hitPoint) {
        Direction sampling = direction(random() * 2 - 1, random() * 2 - 1, random() * 2 - 1);
        Direction scatteredDir = normalize(add(hitPoint.n, sampling));
        Ray scatteredRay = new Ray(hitPoint.x, scatteredDir, 1 * Math.pow(10, -4), incomingRay.tMax);
        return scatteredRay;
    }

    public boolean isAbsorbed() {
        return false;
    }

    public Color albedo(Hit hitPoint) {
        return texture.getColor(hitPoint.u, hitPoint.v);
    }

    public Color emission(Hit hitPoint) {
        return Color.black;
    }

}