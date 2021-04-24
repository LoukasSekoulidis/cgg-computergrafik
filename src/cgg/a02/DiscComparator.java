package cgg.a02;

import java.util.Comparator;

public class DiscComparator implements Comparator<Disc>{

    public int compare(Disc a, Disc b){
        return (int) a.getRadius() - (int) b.getRadius();
    }
}
