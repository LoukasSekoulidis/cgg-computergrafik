package cgg.a06;

import cgtools.*;
import static cgtools.Vector.*;

public class Ray {
    public final Point x0;
    public final Direction d;
    public final double tMin;
    public final double tMax;

    public Ray(Point x0, Direction d, double tMin, double tMax){
        this.x0 = x0;
        this.d = d;
        this.tMin = tMin;
        this.tMax = tMax;
    }

    public Point pointAt(double t){
        Point calc = add(multiply(d, t), x0); 
        return calc;
    }

    public boolean isValid(double t){
        if(t <= tMax && t >= tMin){
            return true;
        }
        return false;
    }

    public Direction getD(){
        return d;
    }

    public Point getX0(){
        return x0;
    }
}
