package cgg.a12;

import cgtools.*;
import static cgtools.Vector.*;
import cgtools.Color;
import static cgtools.Random.*;

public class PolishedMaterial implements Material {
    public Sampler albedo;
    boolean isMatt;
    double mattness;

    public PolishedMaterial(Sampler albedo, boolean isMatt, double mattness) {
        this.albedo = albedo;
        this.isMatt = isMatt;
        this.mattness = mattness;
    }

    @Override
    public boolean isAbsorbed() {
        return false;
    }

    @Override
    public Ray scatteredRay(Ray incomingRay, Hit hitPoint) {
        Direction reflectedDir = (subtract(incomingRay.d,
                multiply(hitPoint.n, dotProduct(incomingRay.d, hitPoint.n) * 2)));
        if (isMatt) {
            double subtractor = mattness / 2;
            reflectedDir = add(reflectedDir, direction(random() * mattness - subtractor,
                    random() * mattness - subtractor, random() * mattness - subtractor));
        }
        Ray reflectedRay = new Ray(hitPoint.x, reflectedDir, Math.pow(10, -4), incomingRay.tMax);
        return reflectedRay;
    }

    @Override
    public Color albedo(Hit hitPoint) {
        return albedo.getColor(hitPoint.u, hitPoint.v);
    }

    @Override
    public Color emission(Hit hitPoint) {
        return Color.black;
    }

}
