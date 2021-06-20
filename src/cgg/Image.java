package cgg;

import cgtools.*;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import static cgtools.Color.*;

public class Image {
  protected int width;
  protected int height;
  protected double[] data;
  protected ArrayList<Color> colorMedian;
  protected int sampleCount;
  int x;
  int y;
  Future<Color> pixel;

  public Image(int width, int height, int sampleCount) {
    this.sampleCount = sampleCount;
    this.width = width;
    this.height = height;
    this.data = new double[width * height * 3];
  }

  public void setPixel(int x, int y, Color color) {
    int index = (3 * (y * width + x));
    data[index] = Math.pow(color.r, 1 / 2.2);
    data[index + 1] = Math.pow(color.g, 1 / 2.2);
    data[index + 2] = Math.pow(color.b, 1 / 2.2);
  }

  public void write(String filename) {
    ImageWriter.write(filename, data, width, height);
  }

  public void sample(Sampler s) {
    ArrayList<Future<Color>> pixels = new ArrayList<Future<Color>>();
    ExecutorService pool = Executors.newFixedThreadPool(5);

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        final int x2 = x;
        final int y2 = y;

        Callable<Color> calculateOnePixel = () -> superSample(s, x2, y2, sampleCount);

        Future<Color> pixel = pool.submit(calculateOnePixel);
        pixels.add(pixel);
      }
    }
    for (int x = 0, counter = 0; x < width; x++) {
      for (int y = 0; y < height; y++, counter++) {

        Color averageColor = new Color(0, 0, 0);
        try {
          averageColor = pixels.get(counter).get();
        } catch (Exception e) {
          e.printStackTrace();
        }

        setPixel(x, y, averageColor);
      }
    }
    pool.shutdown();
  }

  public Color superSample(Sampler s, int x, int y, int samplingRate) {
    Color avgCol = new Color(0, 0, 0);

    for (int xi = 0; xi <= samplingRate; xi++) {
      for (int yi = 0; yi <= samplingRate; yi++) {

        double rx = cgtools.Random.random();
        double ry = cgtools.Random.random();
        double xs = x + (xi + rx) / sampleCount;
        double ys = y + (yi + ry) / sampleCount;

        Color current = s.getColor(xs, ys);
        avgCol = add(avgCol, current);
      }
    }
    int numbOfSamp = samplingRate * samplingRate;
    avgCol = divide(avgCol, numbOfSamp);
    return avgCol;
  }
}
