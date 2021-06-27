package cgg.a10;

import cgtools.*;

public class Checkerboard implements Sampler {
	public double n;
	public Sampler a;
	public Sampler b;

	public Checkerboard(double n, Sampler a, Sampler b) {
		this.n = n;
		this.a = a;
		this.b = b;
	}

	@Override
	public Color getColor(double u, double v) {
		double ui = (int) ((u % 1) * n);
		double vi = (int) ((v % 1) * n);

		if ((ui + vi) % 2 == 0) {
			return a.getColor(u, v);
		} else {
			return b.getColor(u, v);
		}
	}
}
