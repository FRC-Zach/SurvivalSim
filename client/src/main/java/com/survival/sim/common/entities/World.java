package com.survival.sim.common.entities;

import com.survival.sim.common.entities.interfaces.Locatable;
import com.survival.sim.common.entities.tile.types.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zach on 10/16/2017.
 */
public class World {


    private WorldTile[][][] tiles = new WorldTile[1][400][400];
    private List<Locatable> entities = new ArrayList<>();

    public World() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                for (int k = 0; k < tiles[i][j].length; k++) {
                    // i = plane, j = x, k = y
                    tiles[i][j][k] = new TileGrass(j, k, i);
                }
            }
        }
        tiles[0][7][7] = new TileWater(7, 7, 0);
    }

    public WorldTile getTile(int x, int y, int plane){

        if (x >= 0 && y >= 0 && plane >= 0 && x < getTiles()[0].length && plane < getTiles().length && y < getTiles()[0][0].length) {
            return getTiles()[plane][x][y];
        } else {
            return null;
        }
    }

    public void setEntities(List<Locatable> entities){
        this.entities = entities;
    }

    public WorldTile[][][] getTiles() {
        return tiles;
    }

    public List<Locatable> getEntities() {
        return entities;
    }
}
