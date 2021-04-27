package cgg.a03;

import cgtools.*;

public class Lochkamera {
    Double phi; 
    int width;
    int height;
    Point ursprung;

    public Lochkamera(Double phi, int width, int height, Point ursprung){
        this.phi = phi;
        this.width = width;
        this.height = height;
        this.ursprung = ursprung;
    }

    public Ray Strahl(double xA, double yA){
        double x = xA - width/2;
        double y = height/2 - yA;
        double z = -(width/2)/Math.tan(phi/2);
        Direction d = Vector.direction(x, y, z);
        return new Ray(ursprung, d, 1,1);
    }
}
