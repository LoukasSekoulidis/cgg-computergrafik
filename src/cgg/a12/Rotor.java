package cgg.a12;

import cgtools.Direction;
import cgtools.Matrix;

public class Rotor implements Animator {
    Direction axis;
    double angularVelocity;
    double angle;
    Animatable anim;
  
    public Rotor(Animatable group, Direction axis, double angularVelocity, double angle) {
      this.anim = group;
      this.axis = axis;
      this.angularVelocity = angularVelocity;
      this.angle = angle;
    }
  
    public void update(double time) {
      anim.setTransformation(
        Matrix.rotation(axis, angle + time * angularVelocity));
    }
  }