package com.survival.sim.common.entities;


public class MushroomEntity extends Entity {

    public MushroomEntity(int x, int y, int plane, boolean walkable, int health) {
        super(x, y, plane, walkable, health);
        addSprite("imgs/Mushroom.png");
    }
}
