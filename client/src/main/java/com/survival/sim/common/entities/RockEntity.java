package com.survival.sim.common.entities;


public class RockEntity extends Entity {

    public RockEntity(int x, int y, int plane, boolean walkable, int health) {
        super(x, y, plane, walkable, health);
        addSprite("imgs/Rock2.png");
    }
}
