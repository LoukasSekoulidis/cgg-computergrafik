package cgg.a03;

import cgtools.*;

public class Hit {
    Double t;
    Point x;
    Direction n;
    Color c;

    public Hit(Double t, Point x, Direction n, Color c){
        this.t = t;
        this.x = x;
        this.n = n;
        this.c = c;
    }
}
