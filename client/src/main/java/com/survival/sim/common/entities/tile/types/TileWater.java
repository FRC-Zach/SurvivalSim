package com.survival.sim.common.entities.tile.types;

import com.survival.sim.common.entities.WorldObject;

public class TileWater extends WorldObject {

    public TileWater(int x, int y, int plane) {
        super(x, y, plane, false);
        super.addSprite("imgs/Water.png");
    }

    public TileWater() {

    }
}
