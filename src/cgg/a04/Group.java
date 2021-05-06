package cgg.a04;

import cgg.Hit;
import cgg.Ray;
import java.util.ArrayList;

public class Group implements Shape{
    ArrayList<Shape> shapes;

    public Group(ArrayList<Shape> shapes){   
        this.shapes = shapes;
    }
    
    public Hit intersect(Ray r) {
        Shape closestShape = null;
        double comp = Double.POSITIVE_INFINITY;
        for(Shape s : shapes){
            if(s.intersect(r) != null){
                double tmp =  s.intersect(r).t;
                if(tmp <= comp){
                    closestShape = s;
                }
            }
        }
        return closestShape.intersect(r);
    }
}
