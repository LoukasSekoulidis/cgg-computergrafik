package cgg.a02;

import cgtools.*;
import java.util.ArrayList;
import java.util.Collections;

// Represents the contents of an image. Provides different colors for specified areas of pixels.
public class ColoredDiscs implements Sampler {
    Color color;
    int width;
    int height;
    int countDisc;
    ArrayList<Disc> discsList;

    public ColoredDiscs(Color color, int countDisc, int width, int height){
        this.width = width;
        this.height = height;
        this.color = color;
        this.countDisc = countDisc;
        createRandomDiscs();
    }
    
    // Returns the color for the given position.
    public Color getColor(double x, double y){
        for(Disc c: discsList){
            if(c.isPointInDisc(x, y)){
                return c.color;
            }
        }
        return color;
    }

    public void createRandomDiscs(){
        DiscComparator dComparator = new DiscComparator();
        discsList = new ArrayList<Disc>(countDisc);
        for(int i=0; i != countDisc+1; i++){
            double xPos = Math.random()*width;
            double yPos = Math.random()*height;
            double dRadius = Math.random()*(height/2.5)+10;
            double r = Math.random();
            double g = Math.random();
            // double b = Math.random();
            Color tmpColor = new Color(r, g, 1);
            Disc tmpDisc = new Disc(xPos, yPos, dRadius, tmpColor);
            discsList.add(tmpDisc);
        }
        Collections.sort(discsList, dComparator);
    }
}
