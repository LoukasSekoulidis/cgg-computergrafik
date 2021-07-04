package cgg.a11;

import cgtools.*;
import static cgtools.Vector.*;

public class Plane implements Shape {
    Point anker;
    Direction normVector;
    Double radius = Double.POSITIVE_INFINITY;
    Material material;

    public Plane(Point anker, Material material, boolean downwards) {
        this.anker = anker;
        this.normVector = normalize(direction(0, 1, 0));
        this.material = material;
        if(downwards){
            normVector = multiply(normVector, -1);
        }
    }

    public Plane(Point anker, Double radius, Material material, boolean downwards) {
        this.anker = anker;
        this.radius = radius;
        this.normVector = normalize(direction(0, 1, 0));
        this.material = material;
        if(downwards){
            normVector = multiply(normVector, -1);
        }
    }

    public Plane(Point anker, Direction normVector, Double radius, Material material){
        this.anker = anker;
        this.normVector = normVector;
        this.radius = radius;
        this.material = material;
    }

    public Plane(Point anker, Direction normVector,  Material material){
        this.anker = anker;
        this.normVector = normVector;
        this.material = material;
    }

    public Hit intersect(Ray r) {
        double quot = dotProduct(normVector, r.d);
        if (quot == 0) {
            return null;
        }
        double t = dotProduct(subtract(anker, r.x0), normVector) / quot;
        if (!r.isValid(t)) {
            return null;
        }
        Point pos = r.pointAt(t);
        if (radius != Double.POSITIVE_INFINITY) {
            if (length(subtract(pos, anker)) > radius) {
                return null;
            }
        }
        return new Hit(t, pos, normalize(normVector), material, pos.z / radius + 0.5, pos.x / radius + 0.5);
    }
}
