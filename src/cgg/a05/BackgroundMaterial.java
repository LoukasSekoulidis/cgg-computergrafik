package cgg.a05;

import cgtools.Color;

public class BackgroundMaterial implements Material{
    protected Color emission;

    public BackgroundMaterial(Color emission){
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
