package cgg.a02;
import cgtools.*;

public class Disc {
    double midX;
    double midY;
    double radius;
    Color color;

    public Disc(double midX, double midY, double radius, Color color){
        this.midX = midX;
        this.midY = midY;
        this.radius = radius;
        this.color = color;
    }

    public boolean isPointInDisc(double x, double y){
        if(pythagoras(x,y)){
            return true;
        }
        return false;
    }

    public boolean pythagoras(double x, double y){
        double pythX = Math.pow(midX - x, 2);
        double pythY = Math.pow(midY - y, 2);
        double hypothenuse = Math.pow(radius, 2);
        if(pythX + pythY <= hypothenuse){
            return true;
        }
        return false;
    }

    public double getRadius(){
        return radius;
    }
}
