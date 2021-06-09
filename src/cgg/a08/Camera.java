package cgg.a08;

import cgtools.*;
import static cgtools.Vector.*;
import static cgtools.Matrix.*;

public class Camera {
    Double phi; 
    int width;
    int height;
    Matrix transMatrix;

    public Camera(int width, int height, Double phi, Matrix transMatrix){
        this.width = width;
        this.height = height;
        this.phi = phi;
        this.transMatrix = transMatrix;
    }

    public Ray Strahl(double xA, double yA){
        double x = xA - width/2;
        double y = height/2 - yA;
        double z = -(width/2)/Math.tan(phi/2);
        Point transfPosition = multiply(transMatrix, point(0, 0, 0));
        Direction d = direction(x, y, z);
        Direction transfDirection = multiply(transMatrix, d);
        return new Ray(transfPosition, normalize(transfDirection), 0.0, Double.POSITIVE_INFINITY);
    }
}
