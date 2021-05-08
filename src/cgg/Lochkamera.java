package cgg;

import cgtools.*;
import static cgtools.Vector.*;

public class Lochkamera {
    Double phi; 
    int width;
    int height;

    public Lochkamera(int width, int height, Double phi){
        this.width = width;
        this.height = height;
        this.phi = phi;
    }

    public Ray Strahl(double xA, double yA){
        double x = xA - width/2;
        double y = height/2 - yA;
        double z = -(width/2)/Math.tan(phi/2);
        Direction d = direction(x, y, z);
        d = normalize(d);
        return new Ray(point(0, 0, 0), d, 0.0, Double.POSITIVE_INFINITY);
    }
}
