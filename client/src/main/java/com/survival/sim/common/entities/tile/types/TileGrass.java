package com.survival.sim.common.entities.tile.types;

import com.survival.sim.common.entities.WorldObject;

public class TileGrass extends WorldObject {

    public TileGrass(int x, int y, int plane){
        super(x, y, plane, true);
        addSprite("imgs/Grass.png");
    }

    public TileGrass() {
    }
}
