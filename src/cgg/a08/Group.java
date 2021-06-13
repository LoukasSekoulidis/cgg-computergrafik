package cgg.a08;

import java.util.ArrayList;
import cgtools.Matrix;

public class Group implements Shape{
    Transformation transformation;
    ArrayList<Shape> shapes;

    public Group(Matrix transforMatrix){  
        transformation = new Transformation(transforMatrix); 
        shapes = new ArrayList<Shape>();
    }
    
    public Hit intersect(Ray r) {
        Ray ray = transformation.transformRay(r);
        double comp = Double.POSITIVE_INFINITY;
        Hit hitRes = null;
        for(Shape s : shapes){
            Hit hitComp = s.intersect(ray);
            if(hitComp != null){
                if(hitComp.t <= comp){
                    comp = hitComp.t;
                    hitRes = hitComp;
                }
            }
        }
        return transformation.transformHit(hitRes);
    }

    public void add(Shape shape){
        shapes.add(shape);
    }
}
