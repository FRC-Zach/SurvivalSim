package com.survival.sim.common.entities;

/*
  This class was created by Andre on 11/15/2017
 */

public class Entity extends WorldObject{

    private int health;

    public Entity(int x, int y, int plane, boolean walkable, int health){
        super(x, y, plane, walkable);
        this.health = health;

    }

    public Entity setHealth(int health){
        this.health = health;
        return this;
    }


}

