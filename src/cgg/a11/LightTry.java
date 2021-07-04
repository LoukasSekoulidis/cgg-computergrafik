package cgg.a11;

import cgtools.Color;
import cgtools.Direction;
import cgtools.Point;

public interface LightTry {
    public Color radiance(Point hit);
    public Direction direction(Point hit);
    public boolean isVisible(Point hit, Shape scene);
}
