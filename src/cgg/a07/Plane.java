package cgg.a07;

import cgtools.*;

import static cgtools.Vector.*;

public class Plane implements Shape{
    Point anker;
    Direction normVector;
    Double radius;
    Material material;

    public Plane(Point anker, Direction normVector, Material material){
        this.anker = anker;
        this.normVector = normalize(normVector);
        this.material = material;
    }

    public Plane(Point anker, Direction normVector, Double radius, Material material){
        this.anker = anker;
        this.normVector = normVector;
        this.radius = radius;
        this.material = material;
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
        return new Hit(t, r.pointAt(t), normalize(normVector), material);
    }
}
