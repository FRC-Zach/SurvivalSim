package com.survival.sim.common.entities;

import com.survival.sim.client.game.Screen;
import com.survival.sim.client.gui.SpriteCache;
import com.survival.sim.client.util.Projection;
import com.survival.sim.common.entities.interfaces.Locatable;
import com.survival.sim.common.entities.interfaces.Renderable;

import java.awt.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Zach on 10/16/2017.
 */
public class WorldObject extends Tile implements Renderable {

    private AnimationSequence animationSequence = new AnimationSequence();
    private boolean walkable;

    public WorldObject(int x, int y, int plane, boolean walkable) {
        super(x, y, plane);
        this.walkable = walkable;
    }

    public WorldObject() {
    }

    public boolean getWalkable(){
        return walkable;
    }

    public void addSprite(String path){
        animationSequence.addSpritePath(path);
    }

    @Override
    public void render(Graphics2D graphics) throws IOException {
        Point point = Projection.worldToScreen(this);
        graphics.drawImage(SpriteCache.load(animationSequence.getNextSprite()), point.x, point.y, Screen.getTileSize(), Screen.getTileSize(), null);
    }
}
