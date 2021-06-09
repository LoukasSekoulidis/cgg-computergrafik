package cgg.a08;

import cgtools.*;
import static cgtools.Vector.*;
import static cgtools.Random.*;

public class DiffuseMaterial implements Material{
    protected Color albedo;

    public DiffuseMaterial(Color albedo){
        this.albedo = albedo;
    }

    public Ray scatteredRay(Ray incomingRay, Hit hitPoint) {
        Direction sampling = direction(random()*2-1, random()*2-1, random()*2-1);
        Direction scatteredDir = normalize(add(hitPoint.n, sampling));
        Ray scatteredRay = new Ray(hitPoint.x, scatteredDir, 1*Math.pow(10, -4), incomingRay.tMax);
        return scatteredRay;
    }

    public boolean isAbsorbed() {
        return false;
    }

    public Color albedo(Ray incomingRay, Hit hitPoint) {
        return albedo;
    }

    public Color emission(Ray incomingRay, Hit hitPoint) {
        return Color.black;
    }

}