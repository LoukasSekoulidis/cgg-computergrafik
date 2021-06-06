package cgg.a07;

import cgg.*;

import cgtools.*;
import static cgtools.Vector.*;

import javax.print.attribute.standard.MediaSize.NA;

import static cgtools.Color.*;
import static cgtools.Matrix.*;

public class Person { 
    Point point;

    public Person(Point point){
        this.point = point;
    }

    public Group personGroup(){
        Group all = new Group();
        Kugel rightFuss = new Kugel(point(point.x + 0.2, point.y, point.z), 0.15, new DiffuseMaterial(color(0.3, 0.15, 0.0)));
        Group cylinder = new Group();
        Mantel stamm = new Mantel(point(point.x + 0.2, point.y + 0.1, point.z), new DiffuseMaterial(color(0.05, 0.3, 0.0)), 0.15, 0.7);
        Plane a = stamm.getDeckel();
        Plane b = stamm.getBoden();
        cylinder.add(rightFuss);
        cylinder.add(stamm);
        cylinder.add(a);
        cylinder.add(b);

        Group leftLeg = new Group();
        Kugel leftFuss = new Kugel(point(point.x - 0.2, point.y, point.z), 0.15, new DiffuseMaterial(color(0.3, 0.15, 0.0)));
        Mantel leftStamm = new Mantel(point(point.x - 0.2, point.y + 0.1, point.z), new DiffuseMaterial(color(0.05, 0.3, 0.0)), 0.15, 0.7);
        Plane aLeft = leftStamm.getDeckel();
        Plane bLeft = leftStamm.getBoden();
        leftLeg.add(leftFuss);
        leftLeg.add(leftStamm);
        leftLeg.add(aLeft);
        leftLeg.add(bLeft);

        Kugel body1 = new Kugel(point(point.x, point.y + 1.1, point.z), 0.6, new DiffuseMaterial(color(0.05, 0.3, 0.0)));
        Kugel body2 = new Kugel(point(point.x, point.y + 1.2, point.z), 0.6, new DiffuseMaterial(black));
        Kugel body3 = new Kugel(point(point.x, point.y + 1.4, point.z), 0.6, new DiffuseMaterial(white));
        Kugel body3Hemd = new Kugel(point(point.x, point.y + 1.6, point.z), 0.6, new DiffuseMaterial(white));
        Kugel body4 = new Kugel(point(point.x, point.y + 1.8, point.z), 0.55, new DiffuseMaterial(color(0.98,0.71,0.65)));
        Kugel body5 = new Kugel(point(point.x, point.y + 2.0, point.z), 0.55, new DiffuseMaterial(color(0.98,0.71,0.65)));
        Kugel body6 = new Kugel(point(point.x, point.y + 2.2, point.z), 0.55, new DiffuseMaterial(color(0.98,0.71,0.65)));

        Kugel bodyKinnLeft = new Kugel(point(point.x-0.06, point.y + 1.95, point.z + 0.5), 0.11, new DiffuseMaterial(color(0.98,0.71,0.65)));
        Kugel bodyKinnRight = new Kugel(point(point.x+0.06, point.y + 1.95, point.z + 0.5), 0.11, new DiffuseMaterial(color(0.98,0.71,0.65)));

        Kugel Nase = new Kugel(point(point.x, point.y + 2.2, point.z + 0.5), 0.1, new DiffuseMaterial(color(0.98,0.71,0.65)));

        Kugel rightEye = new Kugel(point(point.x+0.15, point.y + 2.4, point.z + 0.5), 0.11, new DiffuseMaterial(white));
        Kugel leftEye = new Kugel(point(point.x-0.15, point.y + 2.4, point.z + 0.5), 0.11, new DiffuseMaterial(white));

        Kugel rightEyePupil = new Kugel(point(point.x+0.15, point.y + 2.4, point.z + 0.62), 0.02, new DiffuseMaterial(black));
        Kugel leftEyePupil = new Kugel(point(point.x-0.15, point.y + 2.4, point.z + 0.62), 0.02, new DiffuseMaterial(black));

        Kugel hair = new Kugel(point(point.x, point.y + 2.5, point.z ), 0.35, new DiffuseMaterial(color(0.52,0.20,0.09)));

        all.add(hair);
        all.add(rightEyePupil);
        all.add(leftEyePupil);
        all.add(rightEye);
        all.add(leftEye);
        all.add(body3Hemd);
        all.add(body6);
        all.add(Nase);
        all.add(bodyKinnLeft);
        all.add(bodyKinnRight);
        all.add(body1);
        all.add(body2);
        all.add(body3);
        all.add(body4);
        all.add(body5);
        all.add(cylinder);
        all.add(leftLeg);
        return all;
    }


}