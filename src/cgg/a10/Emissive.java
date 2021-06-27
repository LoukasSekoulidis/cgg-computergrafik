package cgg.a10;

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

    public Color albedo(Ray incomingRay, Hit hitPoint) {
        return Color.black;
    }

    public Color emission(Ray incomingRay, Hit hitPoint) {
        return texture.getColor(hitPoint.u, hitPoint.v);
    }
}
