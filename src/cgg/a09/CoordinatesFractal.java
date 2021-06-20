// package cgg.a08;

// import cgtools.Point;
// import cgtools.Random;

// import static cgtools.Vector.*;

// public class CoordinatesFractal {
//     int depth;
//     double startRadius;
//     Point startPos;
//     Group fractal;

//     public CoordinatesFractal(){
//         fractal = new Group();
//     }
    
//     public double shapes(int depth, Kugel startKugel){
//         if (depth == 0){; return 0;}
//         depth = depth -1;
//         fractal.add(startKugel);
//         double x = startKugel.cPos.x;
//         double y = startKugel.cPos.y;
//         double z = startKugel.cPos.z;
//         double radius = startKugel.radius;
//         Material material = null;
//         Material alternative = new PolishedMaterial(color(0.5, 0.5, 1), false, 0);
        
//         double testO = (int) (Random.random() * 100);
//         System.out.println(testO);
//         if(testO % 5 == 0){
//             material = alternative;
//         } else {
//             material = startKugel.material;
//         }
//         Point o = point(x + radius, y, z);
//         shapes(depth, new Kugel(o, radius, material));

//         double testU = (int) (Random.random() * 100);
//         if(testU % 5 == 0){
//             material = alternative;
//         } else {
//             material = startKugel.material;
//         }
//         Point u = point(x - radius, y, z);
//         shapes(depth, new Kugel(u, radius, material));

//         double testH = (int) (Random.random() * 100);
//         if(testH % 5 == 0){
//             material = alternative;
//         } else {
//             material = startKugel.material;
//         }
//         Point h = point(x, y, z - radius);
//         shapes(depth, new Kugel(h, radius, material));

//         double testV = (int) (Random.random() * 100);
//         if(testV % 5 == 0){
//             material = alternative;
//         } else {
//             material = startKugel.material;
//         }
//         Point v = point(x, y, z + radius);
//         shapes(depth, new Kugel(v, radius, material));

//         double testR = (int) (Random.random() * 100);
//         if(testR % 5 == 0){
//             material = alternative;
//         } else {
//             material = startKugel.material;
//         }
//         Point r = point(x, y + radius, z);
//         shapes(depth, new Kugel(r, radius, material));

//         double testL = (int) (Random.random() * 100);
//         if(testL % 5 == 0){
//             material = alternative;
//         } else {
//             material = startKugel.material;
//         }
//         Point l = point(x, y - radius, z);
//         shapes(depth, new Kugel(l, radius, material));

//         return 0;
//     }
// }
