package com.survival.sim.client.game;

import com.survival.sim.common.entities.Player;

public class LocalPlayer {

    private static Player localPlayer = new Player("Test");

    public static Player getLocalPlayer() {
        return localPlayer;
    }
}
