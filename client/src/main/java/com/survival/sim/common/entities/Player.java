package com.survival.sim.common.entities;

import com.survival.sim.client.game.LocalData;
import com.survival.sim.client.game.Screen;
import com.survival.sim.client.gui.SpriteCache;
import com.survival.sim.client.util.Projection;
import com.survival.sim.common.entities.interfaces.Locatable;
import com.survival.sim.common.entities.interfaces.Renderable;

import java.awt.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Zach on 10/16/2017.
 */
public class Player implements Locatable, Renderable, Serializable {

    private String uid = UUID.randomUUID().toString();
    private String name;
    private AnimationSequence animationSequence = new AnimationSequence();

    private Tile location;

    private int thirst, hunger;

    private int speed;

    public Player(String name) {
        this.name = name;
        this.speed = 1;
        this.thirst = 100;
        this.hunger = 100;
        this.location = new Tile(5, 5, 0);
        animationSequence.addSpritePath("imgs/Player.png");
    }

    public Player() {
    }

    public Tile getLocation() {
        return location;
    }

    public String getUid() {
        return uid;
    }

    public boolean movePlayer(int x, int y){
        if (LocalData.getWorld().getTile(getLocation().getX() + x, getLocation().getY() + y, getLocation().getPlane()).getWalkable()){
            setLocation(getLocation().transform(x, y));
            return true;
        }
        return false;
    }

    @Override
    public void render(Graphics2D graphics) throws IOException {
        Point point = Projection.worldToScreen(this);
        graphics.drawImage(SpriteCache.load(animationSequence.getNextSprite()), point.x, point.y, Screen.getTileSize(), Screen.getTileSize(), null);
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
