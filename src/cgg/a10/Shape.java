package cgg.a10;

public interface Shape {
    public Hit intersect(Ray r);
    public BoundingBox bounds();
}
