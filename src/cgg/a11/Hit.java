package cgg.a11;

import cgtools.*;

public class Hit {
    public final Double t;
    public final Point x;
    public final Direction n;
    public final Material material;
    public Point uv;
    public double u;
    public double v;

    public Hit(Double t, Point x, Direction n, Material material, double u, double v) {
        this.t = t;
        this.x = x;
        this.n = n;
        this.material = material;
        this.u = u;
        this.v = v;
    }

    public Direction getN() {
        return n;
    }

    public Material getMaterial() {
        return material;
    }
}
