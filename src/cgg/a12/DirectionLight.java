package cgg.a12;

import cgtools.Color;
import cgtools.Direction;
import static cgtools.Vector.*;
import static cgtools.Color.*;

public class DirectionLight implements Light{
    Direction toSource;
    Double intensityDouble;
    Color color;

    public DirectionLight(Direction toSource, Color color){
        this.toSource = normalize(toSource);
        this.color = color;
    }

    public DirectionLight(Direction toSource, Double intensityDouble){
        this.toSource = normalize(toSource);
        this.color = new Color(intensityDouble, intensityDouble, intensityDouble);
    }
    
    @Override
    public Color incomingIntensity(Hit hit, Shape scene) {
        Ray shadowRay = new Ray(hit.x, toSource, 0.0001, Double.MAX_VALUE);
        if(shadowRay.isValid(scene.intersect(shadowRay).t)){
            return black;
        }
        Color intensity = multiply(dotProduct(toSource, hit.n), color);
        return intensity;
    }
    
}
