package cgg.a11;

import cgtools.*;

public class TextureTransform implements Sampler{
	
	Sampler source;
    Matrix transform;
	
	public TextureTransform(Sampler source, Matrix transform) {
        this.source = source;
        this.transform = transform;
    }

	@Override
	public Color getColor(double u, double v) {
		Point p = Matrix.multiply(transform, Vector.point(u, v, 0));
		Color color = source.getColor(p.x, p.y);
		return color;
	}

}
