package cgg.a07;

import static cgtools.Vector.*;
import cgtools.*;

public class Background implements Shape{
    Material material;

    public Background(Material material){
        this.material = material;
    }
    
    public Hit intersect(Ray r){
        double fillNum = Double.POSITIVE_INFINITY;
        Point fillPoi = r.pointAt(Double.POSITIVE_INFINITY);
        Direction fillDir = negate(r.d);
        return new Hit(fillNum, fillPoi, normalize(fillDir), material);
    }
}
