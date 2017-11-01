package com.survival.sim.client.game;

import com.survival.sim.common.entities.Player;
import com.survival.sim.common.entities.Tile;

public class LocalPlayer {

    private static Player localPlayer;

    public static Player getLocalPlayer() {
        return localPlayer;
    }
}
