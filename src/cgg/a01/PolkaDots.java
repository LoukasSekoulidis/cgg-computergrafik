package cgg.a01;
import cgtools.*;

// Represents the contents of an image. Provides the same color for all pixels.
public class PolkaDots implements Sampler {
    Color color;
    int width;
    int height;
    int countColumn;
    int countRow;
  
    public PolkaDots(Color color, int width, int height, int countColumn, int countRow) {
        this.width = width;
        this.height = height;
        this.color = color;
        this.countColumn = countColumn;
        this.countRow = countRow;
    }
  
    // Returns the color for the given position.
    public Color getColor(double x, double y) {
        double[] closestCoord = closestCenter(x,y);
        if (closestCoord[0] == 999 || closestCoord[1] == 999){
            return Color.black;
        }
        double midX = closestCoord[0];
        double midY = closestCoord[1];
        if(testRadius(x, y, midX ,midY)){
            return color;
        }
        return Color.black;
    }

    public double[] closestCenter(double x, double y){
        double[] closestCoord = new double[2];
        double rowDiff =  (double) height/((double) countRow+1) ;
        double columnDiff = (double) width/((double) countColumn+1);
        double closestRow = 1;
        double closestColumn = 1;
        if(y/rowDiff < 0.5 || x/columnDiff < 0.5){
            closestCoord[0] = 999;
            closestCoord[1] = 999;
            return closestCoord;
        }
        if(Math.round(y/rowDiff)*rowDiff != height){
            closestRow = Math.round(y/rowDiff) * rowDiff;
        }
        if(Math.round(x/columnDiff)*columnDiff != width){
            closestColumn = Math.round(x/columnDiff)* columnDiff; 
        }
        closestCoord[0] = closestColumn;
        closestCoord[1] = closestRow;
        return closestCoord;
    }

    public boolean testRadius(double x, double y, double midX , double midY) {
        double x2 = midX;
        double y2 = midY;
        double size = 10;
        double pythagorasX = Math.pow(x2 - x, 2);
        double pythagorasY = Math.pow(y2 -y, 2);
        double hypothenuseSize = Math.pow(size, 2);
        if (pythagorasX + pythagorasY < hypothenuseSize){ 
          return true;
        }
        return false;
      }
}