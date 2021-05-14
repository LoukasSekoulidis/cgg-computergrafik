package cgg.a04;

import cgtools.*;
import static cgtools.Vector.*;
import static cgtools.Color.*;

public class Raytracing implements Sampler{
    Group group;
    Lochkamera camera;

    public Raytracing(Group group, Lochkamera camera){
        this.group = group;
        this.camera = camera;
    }

    public Color getColor(double x, double y) {
        Ray ray = camera.Strahl(x, y);
        Hit hit = group.intersect(ray);
        return lightSurface(hit.getN(), hit.getC());
    }

    static Color lightSurface(Direction normal, Color color){
        Direction lightDir = normalize(direction(1, 1, 0.5));
        Color ambient = multiply(0.1, color);
        Color diffuse = multiply(0.9 * Math.max(0, dotProduct(lightDir, normal)), color);
        return add(ambient, diffuse);
    }
}


