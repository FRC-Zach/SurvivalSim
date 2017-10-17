package com.survival.sim.common.entities;

import com.survival.sim.common.entities.interfaces.Locateable;

import java.util.UUID;

/**
 * Created by Zach on 10/16/2017.
 */
public class Player implements Locateable{

    private String uid = UUID.randomUUID().toString();
    private String name;

    private Tile location;

    private int thirst, hunger;

    private int speed;

    public Player(String name) {
        this.name = name;
        this.speed = 1;
        this.thirst = 100;
        this.hunger = 100;
        this.location = new Tile(50, 50, 0);
    }

    public Tile getLocation() {
        return location;
    }

    public String getUid() {
        return uid;
    }

    public Player setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public String getName() {
        return name;
    }

    public Player setName(String name) {
        this.name = name;
        return this;
    }

    public Player setLocation(Tile location) {
        this.location = location;
        return this;
    }

    public int getThirst() {
        return thirst;
    }

    public Player setThirst(int thirst) {
        this.thirst = thirst;
        return this;
    }

    public int getHunger() {
        return hunger;
    }

    public Player setHunger(int hunger) {
        this.hunger = hunger;
        return this;
    }

    public int getSpeed() {
        return speed;
    }

    public Player setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    @Override
    public String toString() {
        return "Player{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", location=" + location +
                ", thirst=" + thirst +
                ", hunger=" + hunger +
                ", speed=" + speed +
                '}';
    }
}
