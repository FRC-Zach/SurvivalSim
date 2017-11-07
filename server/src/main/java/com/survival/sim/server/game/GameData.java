package com.survival.sim.server.game;

import com.survival.sim.common.entities.World;

public class GameData {

    private static World world = new World();

    public static World getWorld() {
        return world;
    }
}
