package com.survival.sim.client.util;

import com.survival.sim.client.game.Camera;
import com.survival.sim.client.game.Screen;
import com.survival.sim.common.entities.Tile;
import com.survival.sim.common.entities.interfaces.Locatable;

import java.awt.*;

public class Projection {

    /***
     *
     * @param locateable locateable from world
     * @return Point on screen from player perspective.
     */
    public static Point worldToScreen(Locatable locateable){
        Tile cameraOffset = Camera.getCameraOffset();
        Tile location = locateable.getLocation();

        int xDif = location.getX() - cameraOffset.getX();
        int yDif = location.getY() - cameraOffset.getY();

        return new Point(xDif * Screen.getTileSize(), yDif * Screen.getTileSize());
    }

    public static Tile screenToWorld(Point point){
        return null;
    }
}
