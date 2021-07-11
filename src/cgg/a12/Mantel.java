package cgg.a12;

import cgtools.*;
import static cgtools.Vector.*;

public class Mantel implements Shape {
    Point cylinderPos;
    Direction cylinderDirection;
    Material material;
    double radius;
    double height;
    Plane deckel;
    Plane boden;

    public Mantel(Point cylinderPos, Material material, double radius, double height) {
        this.cylinderPos = cylinderPos;
        this.cylinderDirection = direction(0, 1, 0);
        this.material = material;
        this.radius = radius;
        this.height = height;
        boden = new Plane(cylinderPos, radius, material, true);
        deckel = new Plane(add(cylinderPos, multiply(cylinderDirection, height)), radius, material, false);
    }

    public Hit intersect(Ray r) {
        Double minY = cylinderPos.y;
        Double maxY = cylinderPos.y + height;

        Direction tmp = subtract(r.getX0(), cylinderPos);
        Point camXZ = point(tmp.x, 0, tmp.z);
        Direction dXZ = direction(r.d.x, 0, r.d.z);

        double a = dotProduct(dXZ, dXZ);
        double b = 2 * (dotProduct(camXZ, dXZ));
        double c = dotProduct(camXZ, camXZ) - Math.pow(radius, 2);
        double d = Math.pow(b, 2) - 4 * a * c;

        if (d < 0) {
            return null;
        } else {
            double t1 = (-b - Math.sqrt(d)) / (2 * a);
            double t2 = (-b + Math.sqrt(d)) / (2 * a);

            if (r.isValid(t1)) {
                Double tPointY = r.pointAt(t1).y;
                if (tPointY > maxY || tPointY < minY) {
                    return null;
                }
                return hitAt(r, t1);
            } else if (r.isValid(t2)) {
                Double tPointY = r.pointAt(t1).y;
                if (tPointY > maxY || tPointY < minY) {
                    return null;
                }
                return hitAt(r, t2);
            } else {
                return null;
            }
        }
    }

    private Hit hitAt(Ray ray, double t) {

        Point x = ray.pointAt(t);

        if (x.y < cylinderPos.y || x.y > (cylinderPos.y + height)) {
            return null;
        }
        Direction n = Vector.divide(Vector.subtract(x, cylinderPos), radius);

        n = Vector.normalize(Vector.direction(n.x, 0, n.z));

        double inclination = Math.acos(n.y);
        double azimuth = Math.PI + Math.atan2(n.x, n.z);
        double u = azimuth / (2 * Math.PI);
        double v = inclination / Math.PI;

        return new Hit(t, x, n, material, u, v);
    }

    public Plane getDeckel() {
        return deckel;
    }

    public Plane getBoden() {
        return boden;
    }

    public Sphere getKugelDeckel() {
        return new Sphere(add(cylinderPos, multiply(cylinderDirection, height)), radius, material);
    }

    public Sphere getKugelBoden() {
        return new Sphere(cylinderPos, radius, material);
    }
}