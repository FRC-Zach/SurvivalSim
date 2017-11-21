package com.survival.sim.common.entities;

import com.survival.sim.common.entities.interfaces.Locatable;
import com.survival.sim.common.entities.tile.types.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Zach on 10/16/2017.
 */
public class World {


    private WorldObject[][][] tiles = new WorldObject[1][200][200];
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

        Random r = new Random();

        for (int i = 0; i < 50; i++){
            int size = r.nextInt(10);
            int xPos = r.nextInt(180 - size);
            int yPos = r.nextInt(180 - size);
            xPos += size;
            yPos += size;
            for (int x = xPos - size; x < xPos + size; x++){
                for (int y = yPos - size; y < yPos + size; y++){
                    if (Math.sqrt(Math.pow(Math.abs(x - xPos), 2) + (Math.pow(Math.abs(y - yPos), 2))) < size) {
                        tiles[0][x][y] = new TileWater(x, y, 0);
                    }
                }
            }
        }

        /* Create trees */
        for (int i = 0; i < 2000; i++){
            int xPos = r.nextInt(200);
            int yPos = r.nextInt(200);
            if (!(tiles[0][xPos][yPos] instanceof TileWater)) {
                entities.add(new TreeEntity(xPos, yPos, 0, false, 100));
            }
        }
        System.out.println("Done creating the world..");
    }

    public List<Locatable> getEntities(int x, int y, int plane){
        List<Locatable> tmp = new ArrayList<>();
        for (Locatable l : entities){
            Tile location = l.getLocation();
            if (location.getX() == x && location.getY() == y && location.getPlane() == plane){
                tmp.add(l);
            }
        }
        return tmp;
    }

    public void DestroyEntity(Entity e){
        entities.remove(e);
        e = null;
    }

    public WorldObject getTile(int x, int y, int plane){

        if (x >= 0 && y >= 0 && plane >= 0 && x < getTiles()[0].length && plane < getTiles().length && y < getTiles()[0][0].length) {
            return getTiles()[plane][x][y];
        } else {
            return null;
        }
    }

    public void setEntities(List<Locatable> entities){
        this.entities = entities;
    }

    public WorldObject[][][] getTiles() {
        return tiles;
    }

    public List<Locatable> getEntities() {
        return entities;
    }
}
