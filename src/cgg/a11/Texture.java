package cgg.a11;

import cgtools.*;

public class Texture implements Sampler {
	ImageTexture texture;

	public Texture(String filename) {
		texture = new ImageTexture(filename);
	}
	
	@Override
	public Color getColor(double u, double v) {
		if(u > 1 || u < 0){
			u = u - Math.floor(u);
		}
		if(v > 1 || v < 0){
			v = v - Math.floor(v);
		}
		return undoGamma(texture.getColor(u, v));
	}

	private Color undoGamma(Color color) {
		
		double ir = Math.pow(color.r, 2.2);
		double ig = Math.pow(color.g, 2.2);
		double ib = Math.pow(color.b, 2.2);

		return new Color(ir, ig, ib);
	}

}