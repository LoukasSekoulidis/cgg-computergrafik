package cgg.a11;

import cgtools.Color;
import cgtools.Sampler;

public class Emissive implements Material {
    public Sampler texture;

    public Emissive(Sampler texture) {
        this.texture = texture;
    }

    public Ray scatteredRay(Ray incomingRay, Hit hitPoint) {
        return null;
    }

    public boolean isAbsorbed() {
        return false;
    }

    public Color albedo(Hit hitPoint) {
        return Color.black;
    }

    public Color emission(Hit hitPoint) {
        return texture.getColor(hitPoint.u, hitPoint.v);
    }
}
