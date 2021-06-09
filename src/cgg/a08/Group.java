package cgg.a08;

import java.util.ArrayList;

public class Group implements Shape{
    ArrayList<Shape> shapes;

    public Group(){   
        shapes = new ArrayList<Shape>();
    }
    
    public Hit intersect(Ray r) {
        double comp = Double.POSITIVE_INFINITY;
        Hit hitRes = null;
        for(Shape s : shapes){
            Hit hitComp = s.intersect(r);
            if(hitComp != null){
                if(hitComp.t <= comp){
                    comp = hitComp.t;
                    hitRes = hitComp;
                }
            }
        }
        return hitRes;
    }

    public void add(Shape shape){
        shapes.add(shape);
    }
}
