package cgg.a04;

import cgtools.*;
import cgg.Hit;
import cgg.Ray;
import static cgtools.Vector.*;

public class Plane implements Shape{
    Point anker;
    Direction normVector;
    Double radius;
    Color color;

    public Plane(Point anker, Direction normVector, Double radius, Color color){
        this.anker = anker;
        this.normVector = normVector;
        this.radius = radius;
        this.color = color;
    }
    
    public Hit intersect(Ray r) {
        double quot = dotProduct(r.getD(), normVector);
        if(quot != 0){
            double t = dotProduct(subtract(anker, r.getX0()), normVector) /quot;
            double valid = length(subtract(r.pointAt(t), anker));
            if(r.isValid(t) && valid <= radius){
                return new Hit(t, r.pointAt(t), normVector, color);
            }
        }
        return null;
    }
}
