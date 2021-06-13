package cgg.a08;

import cgtools.*;
import static cgtools.Vector.*;

public class Mantel implements Shape{
    Point cylinderPos;
    Direction cylinderDirection;
    Material material;
    double radius;
    double height;
    Plane deckel;
    Plane boden;

    public Mantel(Point cylinderPos, Material material ,double radius, double height){
        this.cylinderPos = cylinderPos;
        this.cylinderDirection = direction(0, 1, 0);
        this.material = material;
        this.radius = radius;
        this.height = height;
        boden = new Plane(cylinderPos, normalize(multiply(cylinderDirection, -1)), radius, material);
        deckel = new Plane(add(cylinderPos, multiply(cylinderDirection, height)), normalize(cylinderDirection), radius, material);
    }

    public Hit intersect(Ray r){
        Double minY = cylinderPos.y;
        Double maxY = cylinderPos.y + height;

        Direction tmp = subtract(r.getX0(), cylinderPos);
        Point camXZ = point(tmp.x, 0, tmp.z);
        Direction dXZ = direction(r.d.x, 0, r.d.z);

        double a = dotProduct(dXZ, dXZ);
        double b = 2* (dotProduct(camXZ, dXZ));
        double c = dotProduct(camXZ, camXZ) - Math.pow(radius, 2);
        double d = Math.pow(b, 2) - 4*a*c;

        if(d < 0){
            return null;
        } else {
            double t1 = (-b - Math.sqrt(d)) / (2 * a);
            double t2 = (-b + Math.sqrt(d)) / (2 * a);

            if (r.isValid(t1) ){
                Double tPointY = r.pointAt(t1).y;
                if(tPointY > maxY || tPointY < minY){
                    return null;
                }
                Point nSource = point(cylinderPos.x, cylinderPos.y + r.pointAt(t1).y, cylinderPos.z);
                Direction n = subtract(r.pointAt(t1), nSource);
                Hit hit = new Hit(t1, r.pointAt(t1), normalize(n) , material);
                return hit;

            } else if (r.isValid(t2) ){
                Double tPointY = r.pointAt(t1).y;
                if(tPointY > maxY || tPointY < minY){
                    return null;
                }
                Point nSource = point(cylinderPos.x, cylinderPos.y + r.pointAt(t2).y, cylinderPos.z);
                Direction n = subtract(r.pointAt(t2), nSource);
                Hit hit = new Hit(t2, r.pointAt(t2), normalize(n) , material);
                return hit;
            } else {
                return null;
            }
        }
    }

    public Plane getDeckel(){
        return deckel;
    }

    public Plane getBoden(){
        return boden;
    }

    public Kugel getKugelDeckel(){
        return new Kugel(add(cylinderPos, multiply(cylinderDirection, height)), radius , material);
    }
    
    public Kugel getKugelBoden(){
        return new Kugel(cylinderPos, radius , material);
    }
}