package cgg.a03;

import cgtools.*;

public class Ray {
    Point x0;
    Direction d;
    double tMin;
    double tMax;

    public Ray(Point x0, Direction d, double tMin, double tMax){
        this.x0 = x0;
        this.d = d;
        this.tMin = tMin;
        this.tMax = tMax;
    }

    public Point pointAt(double t){
        Point calc = Vector.add(Vector.multiply(d, t), x0); 
        return calc;
    }

    public boolean isValid(double t){
        if(t <= tMax && t >= tMin){
            return true;
        }
        return false;
    }

}
