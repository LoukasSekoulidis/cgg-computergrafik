package cgg.a04;

import static cgtools.Vector.*;
import cgtools.*;

public class Background implements Shape{
    Color color;

    public Background(Color color){
        this.color = color;
    }
    
    public Hit intersect(Ray r){
        double fillNum = Double.POSITIVE_INFINITY;
        Point fillPoi = r.pointAt(Double.POSITIVE_INFINITY);
        Direction fillDir = negate(r.d);
        return new Hit(fillNum, fillPoi, normalize(fillDir), color);
    }
}
