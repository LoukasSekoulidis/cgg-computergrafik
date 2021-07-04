package cgg.a11;

import java.util.ArrayList;

public class World {
    public final ArrayList<Light> lights;
    public final Group scene;

    public World(ArrayList<Light> lights, Group scene){
        this.lights = lights;
        this.scene = scene;
    }

    public World(Group scene, Light... lightz) {
        this.scene = scene;
        lights = new ArrayList<Light>();
        for (Light l : lightz) {
            lights.add(l);
        }
    }
}

