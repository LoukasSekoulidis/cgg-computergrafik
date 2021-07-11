package cgg.a12;

import java.util.ArrayList;
import cgtools.Matrix;

public class Group implements Shape, Animatable {
    Transformation transformation;
    Matrix transMatrix;
    ArrayList<Shape> shapes;

    public Group(Matrix transforMatrix) {
        this.transMatrix = transforMatrix;
        transformation = new Transformation(transforMatrix);
        shapes = new ArrayList<Shape>();
    }

    public Group() {
        this.transMatrix = Matrix.identity;
        transformation = new Transformation(Matrix.identity);
        shapes = new ArrayList<Shape>();
    }

    public Group(Shape... shapez) {
        this.transMatrix = Matrix.identity;
        transformation = new Transformation(Matrix.identity);
        shapes = new ArrayList<Shape>();
        for (Shape s : shapez) {
            shapes.add(s);
        }
    }

    public Group(Matrix transforMatrix ,Shape... shapez) {
        this.transMatrix = transforMatrix;
        transformation = new Transformation(transforMatrix);
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

    @Override
    public void setTransformation(Matrix m) {
        transformation = new Transformation(m);
    }
}
