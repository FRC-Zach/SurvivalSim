package com.survival.sim.client.util;

import com.survival.sim.client.game.Camera;
import com.survival.sim.common.entities.Tile;
import com.survival.sim.common.entities.interfaces.Locateable;

import java.awt.*;

public class Projection {

    public static Point worldToScreen(Locateable locateable){
        Tile cameraOffset = Camera.getCameraOffset();
        Tile location = locateable.getLocation();

        int xDif = location.getX() - cameraOffset.getX();
        int yDif = location.getY() - cameraOffset.getY();

        return new Point(xDif * 64, yDif * 64);
    }

    public static Tile screenToWorld(Point point){
        return null;
    }
}
