package com.survival.sim.common.entities;

/**
 * Created by Zach on 10/16/2017.
 */
public class World {

    private WorldTile[][][] tiles = new WorldTile[1][400][400];

    public World() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                for (int k = 0; k < tiles[i][j].length; k++) {
                    tiles[i][j][k] = new WorldTile(j , k, i);
                }
            }
        }
    }

    public WorldTile getTile(int x, int y, int plane){

        if (x >= 0 && y >= 0 && plane >= 0 && x < getTiles()[0].length && plane < getTiles().length && y < getTiles()[0][0].length) {
            return getTiles()[plane][x][y];
        } else {
            return null;
        }
    }

    public WorldTile[][][] getTiles() {
        return tiles;
    }
}
