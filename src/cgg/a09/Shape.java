package cgg.a09;

public interface Shape {
    public Hit intersect(Ray r);
    public BoundingBox bounds();
}
