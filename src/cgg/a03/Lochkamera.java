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
        double normieren = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
        if(x != 0){
            x /= normieren;
        }
        if(y != 0){
            y /= normieren;
        }
        if(z != 0){
            z /= normieren;
        }
        Direction d = Vector.direction(x, y, z);
        return new Ray(ursprung, d, 0, 0);
    }
}
