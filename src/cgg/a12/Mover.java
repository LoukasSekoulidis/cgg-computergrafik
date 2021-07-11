package cgg.a12;

import static cgtools.Vector.*;
import cgtools.*;

public class Mover implements Animator {
    Animatable anim;
    double t0, t1;
    Direction p0, p1;
  
    public Mover(Animatable anim, double t0, double t1, Direction p0, Direction p1) {
      this.anim = anim;
      this.t0 = t0;
      this.t1 = t1;
      this.p0 = p0;
      this.p1 = p1;
    }
  
    public void update(double t) {
      double tn = (t - t0) / (t1 - t0);
      double tc = Math.min(Math.max(tn, 0.0), 1.0);
      Direction p = add(p0, multiply(tc, subtract(p1, p0)));
      anim.setTransformation(Matrix.translation(p));
    }
  }