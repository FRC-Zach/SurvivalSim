package com.survival.sim.common.entities;

import com.survival.sim.common.entities.interfaces.Locatable;

import java.io.Serializable;

/**
 * Created by Zach on 10/16/2017.
 */
public class Tile implements Locatable, Serializable {

    private int x;
    private int y;
    private int plane;

    public Tile(int x, int y, int plane) {
        this.x = x;
        this.y = y;
        this.plane = plane;
    }

    public Tile() {

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

    /**
     *
     * @param x x
     * @param y y
     * @return a new @{@link Tile} transformed from the current cords.
     */
    public Tile transform(int x, int y){
        return new Tile(getX() + x, getY() + y, getPlane());
    }

    @Override
    public String toString() {
        return "Tile{" +
                "x=" + x +
                ", y=" + y +
                ", plane=" + plane +
                '}';
    }

    public Tile getLocation() {
        return this;
    }
}
