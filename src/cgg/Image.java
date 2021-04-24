package cgg;
// for push with tag, forgot tag a01 while commit
import cgtools.*;
import java.util.ArrayList;

public class Image {
  protected int width;
  protected int height;
  protected double[] data;
  protected ArrayList<Color> colorMedian; 
  protected int sampleCount;

  public Image(int width, int height, int sampleCount) {
    this.sampleCount = sampleCount;
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
    for (int x = 0; x != width; x++){
      for (int y = 0; y != height; y++){
        colorMedian = new ArrayList<Color>();
        for(int xi = 0; xi <= sampleCount; xi++){
          for(int yi = 0; yi <= sampleCount; yi++){
            double rx = cgtools.Random.random();
            double ry = cgtools.Random.random();
            double xs = x + (xi + rx)/sampleCount;
            double ys = y + (yi + ry)/sampleCount;
            colorMedian.add(s.getColor(xs, ys));
          }
        }
        double r = 0;
        double g = 0;
        double b = 0;
        int count = 0;
        for(Color clr : colorMedian){
          count++;
          r += clr.r;
          g += clr.g;
          b += clr.b;
        }
        Color mix = new Color(r/count, g/count, b/count);
        setPixel(x, y, gammaKorrektur(mix));
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
