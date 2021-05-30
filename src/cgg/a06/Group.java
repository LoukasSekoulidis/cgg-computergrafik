package cgg.a06;

import java.util.ArrayList;

public class Group implements Shape{
    ArrayList<Shape> shapes;

    public Group(ArrayList<Shape> shapes){   
        this.shapes = shapes;
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
}
