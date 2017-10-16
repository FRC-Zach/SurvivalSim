package com.survival.sim.common.entities;

import com.survival.sim.common.entities.interfaces.Locateable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zach on 10/16/2017.
 */
public class WorldTile extends Tile {

    private List<Locateable> entities = new ArrayList<Locateable>();

    public WorldTile(int x, int y, int plane) {
        super(x, y, plane);
    }

    public List<Locateable> getEntities() {
        return entities;
    }
}
