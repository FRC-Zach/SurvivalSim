package com.survival.sim.common.entities;

/**
 * Created by Zach on 10/16/2017.
 */
public class World {

    private WorldTile[][][] tiles = new WorldTile[400][400][1];

    public World() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                for (int k = 0; k < tiles[i][j].length; k++) {
                    tiles[i][j][k] = new WorldTile(i, j , k);
                }
            }
        }
    }

    public WorldTile getTile(int x, int y, int plane){
        return getTiles()[x][y][plane];
    }

    public WorldTile[][][] getTiles() {
        return tiles;
    }
}
