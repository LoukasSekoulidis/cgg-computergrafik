package cgg.a08;

import cgg.*;
import cgg.a06.BackgroundMaterial;
import cgtools.*;
import static cgtools.Vector.*;

import static cgtools.Color.*;
import static cgtools.Matrix.*;

public class Main { // Ballonfiguren als Ansicht!

  public static void main(String[] args) {  //Immer background hinzufügen ? wie besser implementieren um Nullpointer zu verhindern?
    final int width = 1280;
    final int height = 720; 

    Group scene = new Group(identity);
    Camera camera = new Camera(width, height, Math.PI/3, multiply(translation(-19,22.5,19), rotation(0,1,0,-45), rotation(1,0,0, -45)));
    Background background = new Background(new DiffuseMaterial(black));
    scene.add(background);

    Group cylinder = new Group(identity);
    Mantel stamm = new Mantel(point(0, -1, 0), new PolishedMaterial(color(0.69, 0.39, 0), true, 0.), 20, 0.5);
    Plane aStamm = stamm.getDeckel();
    Plane bStamm = stamm.getBoden();
    cylinder.add(stamm);
    cylinder.add(aStamm);
    cylinder.add(bStamm);
    cylinder.add(background);
    scene.add(cylinder);

    Group cylinderA = new Group(identity);
    Mantel stammA = new Mantel(point(0, -17.2, 0), new DiffuseMaterial(color(0.69, 0.39, 0)), 6, 15.5);
    Plane aA = stammA.getDeckel();
    Plane bA = stammA.getBoden();
    cylinderA.add(background);
    cylinderA.add(stammA);
    cylinderA.add(aA);
    cylinderA.add(bA);
    scene.add(cylinderA);
    
    
    
    
    Material a = new Emissive(color(0.92,0.5,1.00));
    Material b = new Emissive(color(0.50,0.92,1.00));
    Material c = new Emissive(color(0.50,0.50,1.00));
    Material d = new Emissive(color(0.50,0.32,0.50));
    Material e = new Emissive(color(0.80,0.92,0.50));
    Material f = new Emissive(color(0.10,0.92,0.50));
    Material g = new Emissive(color(0.60,0.12,0.20));
    Material[] matArr = {a, b, c, d, e, f, g};
    Matrix mA = multiply(translation(3, 0, -6),rotation(0, 1, 0, 35));
    Matrix mB = multiply(translation(-7, 0, -1), rotation(0, 1, 0, 75));
    Matrix mC = multiply(translation(0, 0, -1), rotation(1, 0, 0, 90));
    Matrix mD = translation(7, 0, 7);
    Matrix mE = multiply(translation(-5, 0, -5), rotation(1, 0, 0, -10));
    Matrix mF = multiply(translation(7, 4.5, 2), rotation(1, 0, 0, 180));
    Matrix mG = multiply(translation(-6, 0, 9), rotation(0, 1, 0, 120));
    Matrix[] rixArr = {mA, mB, mC, mD, mE, mF, mG};
    int count = 0;
    for(Material m :matArr){
      Group body = new Group(identity);
      Mantel mantel = new Mantel(point(0, 0, 0), m, 0.5, 2.0);
      Kugel kugelA = mantel.getKugelBoden();
      Kugel kugelB = mantel.getKugelDeckel();
      body.add(background);
      body.add(mantel);
      body.add(kugelA);
      body.add(kugelB);
      body.add(background);

      Group dog = new Group(rixArr[count]);
      count++;
      Matrix leftFronLegMat = multiply(translation(-1.8,0,1), rotation(0,0,1, -20), rotation(1,0,0, -20));
      Group leftFronLeg = new Group(leftFronLegMat);
      Matrix rightFronLegMat = multiply(translation(-1.8,0,-1), rotation(0,0,1, -20), rotation(1,0,0, 20));
      Group rightFronLeg = new Group(rightFronLegMat);
      Matrix leftBackLegMat = multiply(translation(1.8,0,1), rotation(0,0,1, 20), rotation(1,0,0, -20));
      Group leftBackLeg = new Group(leftBackLegMat);
      Matrix rightBackLegMat = multiply(translation(1.8,0,-1), rotation(0,0,1, 20), rotation(1,0,0, 20));
      Group rightBackLeg = new Group(rightBackLegMat);
      Matrix mainBodyMat = multiply(translation(0.8,2,0), rotation(0,0,1, 90), scaling(1, 0.8, 1));
      Group mainBody = new Group(mainBodyMat);
      Matrix tailMat = multiply(translation(1.3,2,0), rotation(0,0,1, -40), scaling(1, 0.7, 1));
      Group tail = new Group(tailMat);
      Matrix neckMat = multiply(translation(-1,1.8,0), rotation(0,0,1, 25), scaling(0.8, 0.7, 0.8));
      Group neck = new Group(neckMat);
      Matrix noseMat = multiply(translation(-1.7,3.0,0), rotation(0,0,1, 85), scaling(1, 0.8, 1));
      Group nose = new Group(noseMat);
      Matrix leftEarMat = multiply(translation(-1.5,3.0,0.25), rotation(1,0,0, 15), rotation(0,0,1, -5),scaling(1, 0.7, 1));
      Group leftEar = new Group(leftEarMat);
      Matrix rightEarMat = multiply(translation(-1.5,3.0,-0.25), rotation(1,0,0, -15), rotation(0,0,1, -5),scaling(1, 0.7, 1));
      Group rightEar = new Group(rightEarMat);
      leftEar.add(body);
      leftEar.add(background);
      dog.add(leftEar);
      rightEar.add(body);
      rightEar.add(background);
      dog.add(rightEar);
      nose.add(body);
      nose.add(background);
      dog.add(nose);
      neck.add(body);
      neck.add(background);
      dog.add(neck);
      tail.add(body);
      tail.add(background);
      dog.add(tail);
      mainBody.add(body);
      mainBody.add(background);
      dog.add(mainBody);
      leftBackLeg.add(body);
      leftBackLeg.add(background);
      dog.add(leftBackLeg);
      rightBackLeg.add(body);
      rightBackLeg.add(background);
      dog.add(rightBackLeg);
      leftFronLeg.add(body);
      leftFronLeg.add(background);
      dog.add(leftFronLeg);
      rightFronLeg.add(body);
      rightFronLeg.add(background);
      dog.add(rightFronLeg);
  
      scene.add(dog);
    }

    Raytracing raytracing = new Raytracing(scene, camera, 4);
    
    Image image2 = new Image(width, height, 10);
    image2.sample(raytracing);
    
    // Write the image to disk.
    final String filename = "doc/a08-2.png";
    image2.write(filename);
    System.out.println("Wrote image: " + filename);
  }
}



// double offset = 2.5;
// double radius = 1.5;
// double hOffset = 0;
// double rotation = 5;
// double factor = 1.3;
// Group ges = new Group(translation(0, 0, -45));
// Group gesR = new Group(translation(10, 0, -45));
// Group gesL = new Group(translation(-10, 0, -45));
// double r = 1;
// double g = 0;
// double b = 1;

// for(int i = 0; i < 20; i++){
//   Color color = new Color(r, g, b);
//   Group base = new Group(multiply(translation(0, hOffset, 0),rotation(0, 1, 0, rotation)));
//   base.add(background);

//   Matrix center = translation(0, 0, 0);
//   Group groupCenter = new Group(center);
//   Kugel bottomCenter = new Kugel(point(0, 0, 0), 1, new DiffuseMaterial(color));
//   groupCenter.add(bottomCenter);
//   groupCenter.add(background);

//   Matrix transA = translation(offset, 0, 0);
//   Group groupA = new Group(transA);
//   Kugel bottomA = new Kugel(point(0, 0, 0), 1, new DiffuseMaterial(color));
//   groupA.add(bottomA);
//   groupA.add(background);

//   Matrix transB = translation(offset, 0, -offset);
//   Group groupB = new Group(transB);
//   Kugel bottomB = new Kugel(point(0, 0, 0), 1, new DiffuseMaterial(color));
//   groupB.add(bottomB);
//   groupB.add(background);

//   Matrix transC = translation(0, 0, -offset);
//   Group groupC = new Group(transC);
//   Kugel bottomC = new Kugel(point(0, 0, 0), 1, new DiffuseMaterial(color));
//   groupC.add(bottomC);
//   groupC.add(background);

//   Matrix transD = translation(-offset, 0, -offset);
//   Group groupD = new Group(transD);
//   Kugel bottomD = new Kugel(point(0, 0, 0), 1, new DiffuseMaterial(color));
//   groupD.add(bottomD);
//   groupD.add(background);

//   Matrix transE = translation(-offset, 0, 0);
//   Group groupE = new Group(transE);
//   Kugel bottomE = new Kugel(point(0, 0, 0), 1, new DiffuseMaterial(color));
//   groupE.add(bottomE);
//   groupE.add(background);

//   Matrix transF = translation(-offset, 0, offset);
//   Group groupF = new Group(transF);
//   Kugel bottomF = new Kugel(point(0, 0, 0), 1, new DiffuseMaterial(color));
//   groupF.add(bottomF);
//   groupF.add(background);

//   Matrix transG = translation(0, 0, offset);
//   Group groupG = new Group(transG);
//   Kugel bottomG = new Kugel(point(0, 0, 0), 1, new DiffuseMaterial(color));
//   groupG.add(bottomG);
//   groupG.add(background);

//   Matrix transH = translation(offset, 0, offset);
//   Group groupH = new Group(transH);
//   Kugel bottomH = new Kugel(point(0, 0, 0), 1, new DiffuseMaterial(color));
//   groupH.add(bottomH);
//   groupH.add(background);

//   base.add(groupCenter);
//   base.add(groupA);
//   base.add(groupB);
//   base.add(groupC);
//   base.add(groupD);
//   base.add(groupE);
//   base.add(groupF);
//   base.add(groupG);
//   base.add(groupH);

//   r -= 0.1;
//   ges.add(base);
//   gesR.add(base);
//   gesL.add(base);
//   hOffset += radius*factor;
//   radius *= 0.8;
//   offset *= 0.9;
//   rotation += 5;
//   factor += 0.3;
// }

// scene.add(ges);
// scene.add(gesR);
// scene.add(gesL);