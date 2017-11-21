package com.survival.sim.common.entities;

public class TreeEntity extends Entity{

    public TreeEntity(int x, int y, int plane, boolean walkable, int health) {
        super(x, y, plane, walkable, health);
        addSprite("imgs/Tree.png");
    }
}
