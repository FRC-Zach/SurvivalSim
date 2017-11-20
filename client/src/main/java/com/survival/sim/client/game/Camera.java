package com.survival.sim.client.game;

import com.survival.sim.common.entities.Tile;
import com.survival.sim.common.entities.interfaces.Locatable;

import java.awt.*;

public class Camera {

    private static Tile cameraOffset = null;

    public static Tile getCameraOffset() {
        return cameraOffset;
    }

    public static void setCameraOffset(Tile cameraOffset) {
        Camera.cameraOffset = cameraOffset;
    }

    public static Tile getCameraLocation(){
        return cameraOffset;
    }

    /**
     * Centers the tile on the location.
     * @param locateable
     */
    public static void centerOn(Locatable locateable) {
        if (locateable == null) return;

        Dimension dimension = Screen.getDimension();

        int xOff = dimension.width / 2 / Screen.getTileSize();
        int yOff = dimension.height / 2 / Screen.getTileSize();

        cameraOffset = locateable.getLocation().transform(-xOff, -yOff);
    }
}
