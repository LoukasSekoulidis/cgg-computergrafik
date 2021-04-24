package cgg.a01;

import cgtools.*;
// for push with tag, forgot tag a01 while push 
// Represents the contents of an image. Provides the same color for all pixels.
public class Circle implements Sampler {
    Color color;
    int width;
    int height;
  
    public Circle(Color color, int width, int height) {
      this.width = width;
      this.height = height;
      this.color = color;
    }
  
    // Returns the color for the given position.
    public Color getColor(double x, double y) {
      if (testRadius(x,y)){ 
        return color;
      }
      return Color.black;
    }

    public boolean testRadius(double x, double y) {
      double x2 = width / 2;
      double y2 = height / 2;
      double size = y2 / 2;
      double pythagorasX = Math.pow(x2 - x, 2);
      double pythagorasY = Math.pow(y2 -y, 2);
      double hypothenuseSize = Math.pow(size, 2);
      if (pythagorasX + pythagorasY < hypothenuseSize){ 
        return true;
      }
      return false;
    }
}