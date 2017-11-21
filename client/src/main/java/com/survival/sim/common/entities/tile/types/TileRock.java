package com.survival.sim.common.entities.tile.types;

import com.survival.sim.common.entities.WorldObject;

public class TileRock extends WorldObject {

    public TileRock(int x, int y, int plane) {
        super(x, y, plane, false);
        addSprite("imgs/Rock.png");
    }

    public TileRock() {

    }
}














