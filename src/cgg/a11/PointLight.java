package cgg.a11;

import cgtools.Color;
import cgtools.Direction;
import cgtools.Point;
import static cgtools.Vector.*;
import static cgtools.Color.*;

public class PointLight implements Light{
    Point source;
    double intensityDouble;
    Color light;

    public PointLight(Point source, Color light){
        this.source = source;
        this.light = light;
    }

    public PointLight(Point source, double intensityDouble){
        this.source = source;
        this.light = new Color(intensityDouble, intensityDouble, intensityDouble);
    }

    public PointLight(Point source, double intensityR, double intensityG, double intensityB){
        this.source = source;
        this.light = new Color(intensityR, intensityG, intensityB);
    }

    @Override
    public Color incomingIntensity(Hit hit, Shape scene) {
        Direction directionToLight = subtract(source, hit.x);
        Double distance = length(directionToLight);
        directionToLight = normalize(directionToLight);
        Ray shadowRay = new Ray(hit.x, directionToLight, 0.0001, distance);

        if(shadowRay.isValid(scene.intersect(shadowRay).t)){
            return Color.black;
        }

        Color intensity = divide(light, distance);
        return multiply(intensity, dotProduct(directionToLight, hit.n));
    }


}
