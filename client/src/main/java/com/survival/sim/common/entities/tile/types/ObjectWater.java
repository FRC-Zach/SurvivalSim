package com.survival.sim.common.entities.tile.types;

import com.survival.sim.common.entities.WorldObject;

public class ObjectWater extends WorldObject {

    public ObjectWater(int x, int y, int plane) {
        super(x, y, plane, false);
        addSprite("imgs/Water.png");
    }

    public ObjectWater() {
    }
}
