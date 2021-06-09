package cgg.a08;

import cgtools.Color;

public class Emissive implements Material{
    protected Color emission;

    public Emissive(Color emission){
        this.emission = emission;
    }

    public Ray scatteredRay(Ray incomingRay, Hit hitPoint) {
       return null;
    }

    public boolean isAbsorbed() {
        return false;
    }

    public Color albedo(Ray incomingRay, Hit hitPoint) {
        return Color.black;
    }

    public Color emission(Ray incomingRay, Hit hitPoint) {
        return emission;
    }
}
