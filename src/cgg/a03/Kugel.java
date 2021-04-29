package cgg.a03;

import cgtools.*;

public class Kugel { 
    Point cPos;
    Color color;
    Double radius;

    public Kugel(Point cPos, Double radius, Color color){
        this.cPos = cPos;
        this.radius = radius;
        this.color = color;
    }

    public Hit intersect(Ray r){
        Direction tmpX0 = Vector.subtract(r.x0, cPos);
        double a = Vector.dotProduct(r.d, r.d);
        double b = 2* (Vector.dotProduct(tmpX0, r.d));
        double c = Vector.dotProduct(tmpX0, tmpX0) - Math.pow(radius, 2);
        double d = Math.pow(b, 2) - 4*a*c;
        if(d < 0){
            return null;
        } else {
            double t = (-b - Math.sqrt(d)) / 2 * a;
        if(r.isValid(t)){
            Direction n = Vector.subtract(r.pointAt(t), cPos);
            Hit hit = new Hit(t, r.pointAt(t), Vector.normalize(n) , color);
            return hit;
        }
        return null;
       }
    }
}

