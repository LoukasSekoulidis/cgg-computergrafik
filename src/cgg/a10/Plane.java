package cgg.a10;

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

    @Override
    public BoundingBox bounds() {
        BoundingBox boundingBox = null;
        if(radius != null){
            Point min = point(anker.x - radius, anker.y - 0.01, anker.z + radius);
            Point max = point(anker.x + radius, anker.y + 0.01, anker.z - radius);
            boundingBox = new BoundingBox(min, max);
        } else {
            Point min = point(anker.x - Double.MAX_VALUE, anker.y - 0.01, anker.z + Double.MAX_VALUE);
            Point max = point(anker.x + Double.MAX_VALUE, anker.y + 0.01, anker.z - Double.MAX_VALUE);
            boundingBox = new BoundingBox(min, max);
        }
        return boundingBox;
    }
}
