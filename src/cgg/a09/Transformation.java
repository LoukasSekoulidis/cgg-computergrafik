package cgg.a09;

import cgtools.*;
import static cgtools.Matrix.*;

public class Transformation {
    Matrix toWorld;
    Matrix fromWorld;
    Matrix toWorldN;

    public Transformation(Matrix transformationMatrix) {
        this.toWorld = transformationMatrix;
        this.fromWorld = invert(transformationMatrix);
        this.toWorldN = transpose(invert(transformationMatrix));
    }

    public Ray transformRay(Ray ray) {
        return new Ray(multiply(fromWorld, ray.x0), multiply(fromWorld, ray.d), ray.tMin, ray.tMax);
    }

    public Hit transformHit(Hit hit) {
        return new Hit(hit.t, multiply(toWorld, hit.x), multiply(toWorldN, hit.n), hit.material);
    }

}