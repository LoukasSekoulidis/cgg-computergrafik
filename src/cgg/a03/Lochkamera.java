package cgg.a03;

import cgtools.*;
import static cgtools.Vector.*;

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
        Direction d = direction(x, y, z);
        d = normalize(d);
        return new Ray(ursprung, d, 0, 9999999);
    }
}
