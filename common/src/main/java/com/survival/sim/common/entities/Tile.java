package com.survival.sim.common.entities;

/**
 * Created by Zach on 10/16/2017.
 */
public class Tile {

    private int x;
    private int y;
    private int plane;

    public Tile(int x, int y, int plane) {
        this.x = x;
        this.y = y;
        this.plane = plane;
    }

    public int getX() {
        return x;
    }

    public Tile setX(int x) {
        this.x = x;
        return this;
    }

    public int getY() {
        return y;
    }

    public Tile setY(int y) {
        this.y = y;
        return this;
    }

    public int getPlane() {
        return plane;
    }

    public Tile setPlane(int plane) {
        this.plane = plane;
        return this;
    }
}
