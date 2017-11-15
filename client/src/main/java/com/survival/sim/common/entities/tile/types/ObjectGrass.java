package com.survival.sim.common.entities.tile.types;

import com.survival.sim.common.entities.WorldObject;

public class ObjectGrass extends WorldObject {

    public ObjectGrass(int x, int y, int plane){
        super(x, y, plane, true);
        super.addSprite("imgs/Grass.png");
    }

    public ObjectGrass() {
    }
}
