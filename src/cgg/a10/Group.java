package cgg.a10;

import java.util.ArrayList;
import cgtools.Matrix;

public class Group implements Shape {
    Transformation transformation;
    ArrayList<Shape> shapes;

    public Group(Matrix transforMatrix) {
        transformation = new Transformation(transforMatrix);
        shapes = new ArrayList<Shape>();
    }

    public Group() {
        transformation = new Transformation(Matrix.identity);
        shapes = new ArrayList<Shape>();
    }

    public Group(Shape... shapez) {
        transformation = new Transformation(Matrix.identity);
        shapes = new ArrayList<Shape>();
        for (Shape s : shapez) {
            shapes.add(s);
        }
    }

    public Hit intersect(Ray r) {
        Ray ray = transformation.transformRay(r);
        double comp = Double.POSITIVE_INFINITY;
        Hit hitRes = null;
        for (Shape s : shapes) {
            Hit hitComp = s.intersect(ray);
            if (hitComp != null) {
                if (hitComp.t <= comp) {
                    comp = hitComp.t;
                    hitRes = hitComp;
                }
            }
        }
        return transformation.transformHit(hitRes);
    }

    public void add(Shape shape) {
        shapes.add(shape);
    }

    public BoundingBox bounds(){
        return null;
    }
    // @Override
    // public BoundingBox bounds() {
    //     BoundingBox boundingBox = BoundingBox.everything;
    //     double minX = 0;
    //     double minY = 0;
    //     double minZ = 0;
    //     BoundingBox compareBox = BoundingBox.everything;
    //     for (Shape s : shapes) {
    //         s.bounds().min;
    //     }
    //     return null;
    // }
}
