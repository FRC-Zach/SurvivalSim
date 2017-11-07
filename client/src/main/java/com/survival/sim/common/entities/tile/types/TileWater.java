package com.survival.sim.common.entities.tile.types;

import com.survival.sim.common.entities.WorldTile;

import java.io.Serializable;

public class TileWater extends WorldTile implements Serializable {

    public TileWater(int x, int y, int plane) {
        super(x, y, plane, false);
        super.addSprite("imgs/Water.png");
    }

    public TileWater() {
    }
}
