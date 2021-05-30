package cgg.a06;

import cgtools.*;

public class Hit {
    public final Double t;
    public final Point x;
    public final Direction n;
    public final Material material;

    public Hit(Double t, Point x, Direction n, Material material){
        this.t = t;
        this.x = x;
        this.n = n;
        this.material = material;
    }   

    public Direction getN(){
        return n;
    }

    public Material getMaterial(){
        return material;
    }
}
