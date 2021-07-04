package cgg.a11;

import cgtools.*;

public interface Material {

    public boolean isAbsorbed();

    public Ray scatteredRay(Ray incomingRay, Hit hitPoint);

    public Color albedo(Hit hitPoint);

    public Color emission(Hit hitPoint);
}