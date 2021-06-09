package cgg.a08;

import cgg.*;

import cgtools.*;
import static cgtools.Vector.*;

import static cgtools.Color.*;
import static cgtools.Matrix.*;

public class Main { 

  public static void main(String[] args) {
    final int width = 1280;
    final int height = 720;

    Group scene = new Group();

    Matrix tran = translation(0,9,0);
    Matrix rot = rotation(direction(1, 0, 0), -30);
    Matrix fina = multiply(tran, rot);
    
    Camera camera = new Camera(width, height, Math.PI/3, fina);
    Background background = new Background(new Emissive(white));
    scene.add(background);

    Group cylinder = new Group();
    Mantel stamm = new Mantel(point(0, -1.5, -20), new DiffuseMaterial(color(0.69, 0.39, 0)), 10, 0.5);
    Plane a = stamm.getDeckel();
    Plane b = stamm.getBoden();
    cylinder.add(stamm);
    cylinder.add(a);
    cylinder.add(b);
    scene.add(cylinder);

    Group cylinderA = new Group();
    Mantel stammA = new Mantel(point(0, -17.2, -20), new DiffuseMaterial(color(0.69, 0.39, 0)), 6, 15.5);
    Plane aA = stammA.getDeckel();
    Plane bA = stammA.getBoden();
    cylinderA.add(stammA);
    cylinderA.add(aA);
    cylinderA.add(bA);
    scene.add(cylinderA);

    Person person = new Person(point(0, -1, -18));
    Person person1 = new Person(point(3, -1, -20));
    Person person2= new Person(point(6, -1, -22));
    Person person3 = new Person(point(9, -1, -19));
    Person person4 = new Person(point(1, -1, -16));
    Person person5 = new Person(point(-3, -1, -24));
    Person person6 = new Person(point(-8, -1, -17));
    Person person7 = new Person(point(-5, -1, -21));
    Person person8 = new Person(point(-9, -1, -20));
    Person person10 = new Person(point(5, -1, -26));
    Person person11 = new Person(point(-4, -1, -12));
    scene.add(person.personGroup());
    scene.add(person1.personGroup());
    scene.add(person2.personGroup());
    scene.add(person3.personGroup());
    scene.add(person4.personGroup());
    scene.add(person5.personGroup());
    scene.add(person6.personGroup());
    scene.add(person7.personGroup());
    scene.add(person8.personGroup());
  
    scene.add(person10.personGroup());
    scene.add(person11.personGroup());
    
    System.out.println(scene.shapes.size());
    
    Raytracing raytracing = new Raytracing(scene, camera, 4);
    
    Image image2 = new Image(width, height, 10);
    image2.sample(raytracing);
    
    // Write the image to disk.
    final String filename = "doc/a07-2.png";
    image2.write(filename);
    System.out.println("Wrote image: " + filename);
  }
}









// Group cylinder = new Group();
// Mantel stamm = new Mantel(point(1, -0.5, -6), new DiffuseMaterial(color(0.69, 0.39, 0)), 0.1, 1.5);
// Plane a = stamm.getDeckel();
// Plane b = stamm.getBoden();
// cylinder.add(stamm);
// cylinder.add(a);
// cylinder.add(b);
// scene.add(cylinder);

// Shape planeZ = new Plane(point(1, -0.2, -6), direction(0, 1, 0), 1.25 , new Emissive(color(0, 0.2, 0.07)));
// Shape planeA = new Plane(point(1, 0.1, -6), direction(0, 1, 0), 1.0 , new Emissive(color(0, 0.2, 0.07)));
// Shape planeB = new Plane(point(1, 0.4, -6), direction(0, 1, 0), 0.75, new Emissive(color(0, 0.2, 0.07)));
// Shape planeC = new Plane(point(1, 0.7, -6), direction(0, 1, 0), 0.5, new Emissive(color(0, 0.2, 0.07)));
// Shape planeD = new Plane(point(1, 1, -6), direction(0, 1, 0), 0.25, new Emissive(color(0, 0.2, 0.07)));
// Shape globeTop = new Kugel(point(1, 1.3, -6), 0.05, new Emissive(color(0, 0.2, 0.07)));
// scene.add(planeZ);
// scene.add(planeA);
// scene.add(planeB);
// scene.add(planeC);
// scene.add(planeD);
// scene.add(globeTop);


// Group cylinder2 = new Group();
// Mantel stamm2 = new Mantel(point(-2, -0.5, -6), new Emissive(color(1.00,0.80,0.80)), 0.1, 1.5);
// Plane a2 = stamm.getDeckel();
// Plane b2 = stamm.getBoden();
// cylinder.add(stamm2);
// cylinder.add(a2);
// cylinder.add(b2);
// scene.add(cylinder2);

// Shape kugelA = new Kugel(point(-2.1, 0.4, -5.9), 0.25, new PolishedMaterial(color(0.60,0.80,1.00), false, 0));
// Shape kugelB = new Kugel(point(-1.9, 0.45, -5.1), 0.22, new PolishedMaterial(color(0.60,0.80,1.00), false, 0));
// Shape kugelC = new Kugel(point(-2.03, 0.48, -6), 0.28, new PolishedMaterial(color(0.60,0.80,1.00), false, 0));
// Shape kugelD = new Kugel(point(-2.0, 0.6, -5.9), 0.31, new PolishedMaterial(color(0.60,0.80,1.00), false, 0));
// Shape kugelE = new Kugel(point(-1.8, 0.68, -6.2), 0.28, new PolishedMaterial(color(0.60,0.80,1.00), false, 0));
// Shape kugelF = new Kugel(point(-2.07, 0.78, -5.9), 0.3, new PolishedMaterial(color(0.60,0.80,1.00), false, 0));
// scene.add(kugelA);
// scene.add(kugelB);
// scene.add(kugelC);
// scene.add(kugelD);
// scene.add(kugelE);
// scene.add(kugelF);

// Shape globeLotte = new Kugel(point(-1, 1.5, -7), 0.5, new DiffuseMaterial(color(0.5, 0.8, 0.8)));
// Shape planeLotte = new Plane(point(-1, 1.5, -7), direction(1, 3, 1), 0.75 ,new Emissive(color(0.5, 0.1, 0.1)));
// Shape planeLotte1 = new Plane(point(-1, 1.5, -7), direction(3, 1, 1), 0.75 ,new Emissive(color(0.5, 0.1, 0.1)));

// scene.add(globeLotte);
// scene.add(planeLotte);
// scene.add(planeLotte1);

// Group cylinder3 = new Group();
// Mantel stamm3 = new Mantel(point(-0.5, -0.5, -3), new DiffuseMaterial(color(1.00,0.47,0.20)), 0.1, 0.4);
// Plane a3 = stamm.getDeckel();
// Plane b3 = stamm.getBoden();
// cylinder.add(stamm3);
// cylinder.add(a3);
// cylinder.add(b3);
// scene.add(cylinder3);

// Group cylinder4 = new Group();
// Mantel stamm4 = new Mantel(point(-0.65, -0.5, -3.5), new DiffuseMaterial(color(1.00,0.47,0.20)), 0.1, 0.6);
// Plane a4 = stamm.getDeckel();
// Plane b4 = stamm.getBoden();
// cylinder.add(stamm4);
// cylinder.add(a4);
// cylinder.add(b4);
// scene.add(cylinder4);

// Group cylinder5 = new Group();
// Mantel stamm5 = new Mantel(point(-0.2, -0.5, -2), new DiffuseMaterial(color(1.00,0.47,0.20)), 0.1, 0.45);
// Plane a5 = stamm.getDeckel();
// Plane b5 = stamm.getBoden();
// cylinder.add(stamm5);
// cylinder.add(a5);
// cylinder.add(b5);
// scene.add(cylinder5);

// Group cylinder6 = new Group();
// Mantel stamm6 = new Mantel(point(-0.45, -0.5, -2.5), new DiffuseMaterial(color(1.00,0.47,0.20)), 0.1, 0.25);
// Plane a6 = stamm.getDeckel();
// Plane b6 = stamm.getBoden();
// cylinder.add(stamm6);
// cylinder.add(a6);
// cylinder.add(b6);
// scene.add(cylinder6);

// Group cylinder7 = new Group();
// Mantel stamm7 = new Mantel(point(-0.7, -0.5, -4), new DiffuseMaterial(color(1.00,0.47,0.20)), 0.1, 0.3);
// Plane a7 = stamm.getDeckel();
// Plane b7 = stamm.getBoden();
// cylinder.add(stamm7);
// cylinder.add(a7);
// cylinder.add(b7);
// scene.add(cylinder7);

// Group cylinder8 = new Group();
// Mantel stamm8 = new Mantel(point(-0.3, -0.5, -5), new DiffuseMaterial(color(1.00,0.47,0.20)), 0.1, 0.55);
// Plane a8 = stamm.getDeckel();
// Plane b8 = stamm.getBoden();
// cylinder.add(stamm8);
// cylinder.add(a8);
// cylinder.add(b8); 
// scene.add(cylinder8);


// double sizeVar = 1;
// double heightVar = 0.1;
// for(int i = 0; i < 10; i++){
//   Group cylinderT = new Group();
//   Mantel stammT = new Mantel(point(2, -0.5, -4), new DiffuseMaterial(color(1.00,0.47,0.20)), sizeVar, heightVar);
//   Plane aT = stamm.getDeckel();
//   Plane bT = stamm.getBoden();
//   cylinder.add(stammT);
//   cylinder.add(aT);
//   cylinder.add(bT); 
//   scene.add(cylinderT);
//   heightVar += 0.1;
//   sizeVar -= 0.1;
// }