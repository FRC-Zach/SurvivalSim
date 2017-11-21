package com.survival.sim.common.entities;


public class BerryBushEntity extends Entity {

    public BerryBushEntity(int x, int y, int plane, boolean walkable, int health) {
        super(x, y, plane, walkable, health);
        addSprite("imgs/BerryBush.png");
    }
}
