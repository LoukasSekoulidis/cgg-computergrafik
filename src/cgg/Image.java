package cgg;
// for push with tag, forgot tag a01 while commit
import cgtools.*;

public class Image {
  protected int width;
  protected int height;
  protected double[] data;

  public Image(int width, int height) {
    this.width = width;
    this.height = height;
    this.data = new double[width * height * 3];
  }

  public void setPixel(int x, int y, Color color) {
    int index = (3 * (y * width + x));
    data[index] = color.r;
    data[index +1] = color.g;
    data[index +2] = color.b;
  }

  public void write(String filename) {
    ImageWriter.write(filename, data, width, height);
  }

  public void sample(Sampler s) {
    for (int x = 0; x != width; x++) {
      for (int y = 0; y != height; y++) {
        setPixel(x, y, gammaKorrektur(s.getColor(x, y)));
      }
    }
  }

  public Color gammaKorrektur(Color c){
    double r = Math.pow(c.r, 1/2.2);
    double g = Math.pow(c.g, 1/2.2);
    double b = Math.pow(c.b, 1/2.2);
    Color tmp = new Color(r, g, b);
    return tmp;
  }
}
