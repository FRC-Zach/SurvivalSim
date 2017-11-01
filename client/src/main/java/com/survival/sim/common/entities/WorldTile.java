package com.survival.sim.common.entities;

import com.survival.sim.client.game.Screen;
import com.survival.sim.client.util.Projection;
import com.survival.sim.common.entities.interfaces.Locateable;
import com.survival.sim.common.entities.interfaces.Renderable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Zach on 10/16/2017.
 */
public class WorldTile extends Tile implements Renderable {

    private Color color = new Color(ThreadLocalRandom.current().nextInt(0, 255), ThreadLocalRandom.current().nextInt(0, 255), ThreadLocalRandom.current().nextInt(0, 255));
    private List<Locateable> entities = new ArrayList<>();

    public WorldTile(int x, int y, int plane) {
        super(x, y, plane);
    }

    public List<Locateable> getEntities() {
        return entities;
    }

    @Override
    public void render(Graphics2D graphics) {
        Point point = Projection.worldToScreen(this);
        graphics.setColor(color);
        graphics.fillRect(point.x, point.y, Screen.getTileSize(), Screen.getTileSize());
    }
}
