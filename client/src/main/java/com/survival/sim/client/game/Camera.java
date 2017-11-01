package com.survival.sim.client.game;

import com.survival.sim.common.entities.Tile;

public class Camera {

    private static Tile cameraOffset = LocalPlayer.getLocalPlayer().getLocation().transform(-16, -16);

    public static Tile getCameraOffset() {
        return cameraOffset;
    }

    public static void setCameraOffset(Tile cameraOffset) {
        Camera.cameraOffset = cameraOffset;
    }
}
