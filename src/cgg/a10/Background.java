package cgg.a10;

import static cgtools.Vector.*;
import cgtools.*;

public class Background implements Shape {
    Material material;

    public Background(Material material) {
        this.material = material;
    }

    public Hit intersect(Ray r) {
        double fillNum = Double.POSITIVE_INFINITY;
        Point fillPoi = r.pointAt(Double.POSITIVE_INFINITY);
        Direction fillDir = negate(r.d);
        double u = (Math.PI + Math.atan2(r.d.x, r.d.z)) / (2 * Math.PI);
        double v = (Math.acos(r.d.y)) / Math.PI;
        return new Hit(fillNum, fillPoi, normalize(fillDir), material, u, v);
    }

    @Override
    public BoundingBox bounds() {
        Point max = point(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        Point min = point(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        BoundingBox boundingBox = new BoundingBox(min, max);
        return boundingBox;
    }
}
