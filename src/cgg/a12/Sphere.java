package cgg.a12;

import cgtools.*;
import static cgtools.Vector.*;

public class Sphere implements Shape {
    Point cPos;
    Material material;
    double radius;

    public Sphere(Point cPos, double radius, Material material) {
        this.cPos = cPos;
        this.radius = radius;
        this.material = material;
    }

    public Hit intersect(Ray r) {
        Direction tmpX0 = subtract(r.getX0(), cPos);
        double a = dotProduct(r.getD(), r.getD());
        double b = 2 * (dotProduct(tmpX0, r.getD()));
        double c = dotProduct(tmpX0, tmpX0) - Math.pow(radius, 2);
        double d = Math.pow(b, 2) - 4 * a * c;
        if (d < 0) {
            return null;
        } else {
            double t1 = (-b - Math.sqrt(d)) / (2 * a);
            double t2 = (-b + Math.sqrt(d)) / (2 * a);
            if (r.isValid(t1)) {
                return hitAt(r, t1);
            } else if (r.isValid(t2)) {
                return hitAt(r, t2);
            } else {
                return null;
            }
        }
    }

    private Hit hitAt(Ray ray, double t) {
		Point x = ray.pointAt(t);
		Direction n = Vector.divide(Vector.subtract(x, cPos), radius);
		double inclination = Math.acos(n.y);
        double azimuth = Math.PI + Math.atan2(n.x, n.z);
        double u = azimuth / (2 * Math.PI);
        double v = inclination / Math.PI;
        return new Hit(t, x, n, material, u, v);
	}
}
