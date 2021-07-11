package cgg.a12;

import cgtools.*;

public class PolkaDots implements Sampler {

	public final Sampler a;
	public final Sampler b;
	public final double r;

	public PolkaDots(Sampler a, Sampler b, double d) {
		this.a = a;
		this.b = b;
		this.r = (d - Math.floor(d)) / 2;
	}

	@Override
	public Color getColor(double u, double v) {
		u = (u % 1) - 0.5;
		v = (v % 1) - 0.5;
		if (Math.sqrt(u * u + v * v) < r)
			return a.getColor(u, v);
		else
			return b.getColor(u, v);
	}
}
