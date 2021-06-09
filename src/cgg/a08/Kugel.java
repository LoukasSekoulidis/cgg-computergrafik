package cgg.a08;

import cgtools.*;
import static cgtools.Vector.*;

public class Kugel implements Shape{ 
    Point cPos;
    Material material;
    double radius;

    public Kugel(Point cPos, double radius, Material material){
        this.cPos = cPos;
        this.radius = radius;
        this.material = material;
    }

    public Hit intersect(Ray r){
        Direction tmpX0 = subtract(r.getX0(), cPos);
        double a = dotProduct(r.getD(), r.getD());
        double b = 2* (dotProduct(tmpX0, r.getD()));
        double c = dotProduct(tmpX0, tmpX0) - Math.pow(radius, 2);
        double d = Math.pow(b, 2) - 4*a*c;
        if(d < 0){
            return null;
        } else {
            double t1 = (-b - Math.sqrt(d)) / (2 * a);
            double t2 = (-b + Math.sqrt(d)) / (2 * a);
            if (r.isValid(t1) ){
                Direction n = subtract(r.pointAt(t1), cPos);
                Hit hit = new Hit(t1, r.pointAt(t1), normalize(n) , material);
                return hit;
            } else if (r.isValid(t2) ){
                Direction n = subtract(r.pointAt(t2), cPos);
                Hit hit = new Hit(t2, r.pointAt(t2), normalize(n) , material);
                return hit;
            } else {
                return null;
            }
       }
    }
}

