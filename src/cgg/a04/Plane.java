package cgg.a04;

import cgtools.*;
import cgg.Hit;
import cgg.Ray;
import static cgtools.Vector.*;

public class Plane implements Shape{
    Point anker;
    Direction normVector;
    Color color;
    Double radius;

    public Plane(Point anker, Direction normVector, Color color){
        this.anker = anker;
        this.normVector = normalize(normVector);
        this.color = color;
    }

    public Plane(Point anker, Direction normVector, Color color, Double radius){
        this.anker = anker;
        this.normVector = normVector;
        this.color = color;
        this.radius = radius;
    }
    
    public Hit intersect(Ray r) {
        double quot = dotProduct(normVector, r.d);
        if(quot == 0){
            return null;
        }
        double t = dotProduct(subtract(anker, r.x0), normVector) / quot;
        if(!r.isValid(t)){
            return null;
        }
        if(radius != null){
            if(length(subtract(r.pointAt(t), anker)) > radius){
                return null;
            }
        }
        return new Hit(t, r.pointAt(t), normalize(normVector), color);
    }
}
