package cgg;

import cgtools.*;

public class Hit {
    public final Double t;
    public final Point x;
    public final Direction n;
    public final Color c;

    public Hit(Double t, Point x, Direction n, Color c){
        this.t = t;
        this.x = x;
        this.n = n;
        this.c = c;
    }   

    public Direction getN(){
        return n;
    }

    public Color getC(){
        return c;
    }
}
