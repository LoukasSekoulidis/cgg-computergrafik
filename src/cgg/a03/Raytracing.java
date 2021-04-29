package cgg.a03;
import cgtools.*;
import java.util.ArrayList;


public class Raytracing implements Sampler{
    ArrayList<Kugel> kugel;
    Lochkamera camera;

    public Raytracing(ArrayList<Kugel> kugel, Lochkamera camera){
        this.kugel = kugel;
        this.camera = camera;

    }

    public Color getColor(double x, double y){
        for(Kugel kugelEl : kugel){
            Ray ray = camera.Strahl(x, y);
            Hit hit = kugelEl.intersect(ray);
            if(hit != null) {
                Color color = shade(hit.n, hit.c);
                return color;
            }
        }
        return Color.black;
    }

    static Color shade(Direction normal, Color color){
        Direction lightDir = Vector.normalize(Vector.direction(1, 1, 0.5));
        Color ambient = Color.multiply(0.1, color);
        Color diffuse = Color.multiply(0.9 * Math.max(0, Vector.dotProduct(lightDir, normal)), color);
        return Color.add(ambient, diffuse);
    }
}
