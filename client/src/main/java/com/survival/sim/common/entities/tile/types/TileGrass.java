package com.survival.sim.common.entities.tile.types;

import com.survival.sim.common.entities.WorldTile;

import java.io.Serializable;

public class TileGrass extends WorldTile implements Serializable{

    public TileGrass(int x, int y, int plane){
        super(x, y, plane, true);
        super.addSprite("imgs/Grass.png");
    }

    public TileGrass() {
    }
}
