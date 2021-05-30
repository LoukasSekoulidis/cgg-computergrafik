package cgg.a06;

import static cgtools.Vector.*;
import cgtools.Color;
import cgtools.*;

public class TransmissiveMaterial implements Material{
    Color albedo;
    double n1;
    double opticalIndex;


    public TransmissiveMaterial(Color albedo, double opticalIndex){
        this.albedo = albedo;
        this.opticalIndex = opticalIndex;
    }

    @Override
    public boolean isAbsorbed() {
        return false;
    }

    @Override
    public Ray scatteredRay(Ray incomingRay, Hit hitPoint) {
        double n1 = 1.0;
        double n2 = opticalIndex;
        Direction n = hitPoint.n;
        Ray scattered = null;

        if(dotProduct(incomingRay.d , hitPoint.n) > 0){
            n1 = opticalIndex;
            n2 = 1.0;
            n = multiply(-1.0, hitPoint.n);
        }
        if(refractBoolean(incomingRay.d, n, n1, n2)){
            if(Random.random() > schlick(incomingRay.d, n ,n1, n2)){
                scattered = new Ray(hitPoint.x, refract(incomingRay.d, n, n1, n2), Math.pow(10, -4), incomingRay.tMax);
            } else {
                scattered = new Ray(hitPoint.x, reflect(incomingRay.d, n), Math.pow(10, -4), incomingRay.tMax);
            }
        } else {
            scattered = new Ray(hitPoint.x, reflect(incomingRay.d, n), Math.pow(10, -4), incomingRay.tMax);
        }
        return scattered;
    }

    @Override
    public Color albedo(Ray incomingRay, Hit hitPoint) {
        return albedo;
    }

    @Override
    public Color emission(Ray incomingRay, Hit hitPoint) {
        return Color.black;
    }
    
    public boolean refractBoolean(Direction d, Direction n, double n1, double n2){
        double r = n1/n2;
        double c = dotProduct(multiply(n, -1), d);
        if(1 - r*r * (1 - c*c) < 0){
            return false;
        }
        return true;
    }

    public Direction refract(Direction d, Direction n, double n1, double n2){
        double r = n1/n2;
        double c = dotProduct(multiply(n, -1), d);
        double sqaured = Math.sqrt(1 - r * r * (1 - c * c));
        Direction refractDir= add(multiply(d, r), multiply(n ,( r * c - sqaured)));
        return refractDir;
    }

    public Direction reflect(Direction d, Direction n ){
        return subtract(d, multiply(n, dotProduct(d, n) * 2));
    }

    public double schlick(Direction d, Direction n, double n1, double n2){
        double r0 = Math.pow(((n1-n2)/(n1+n2)),2);
        double firstBracket = 1 - r0;
        double secondBracket = Math.pow(1 + dotProduct(n, d), 5);
        return r0 + firstBracket * secondBracket;
    }
}
