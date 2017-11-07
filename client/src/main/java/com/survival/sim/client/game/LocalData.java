package com.survival.sim.client.game;

import com.survival.sim.common.entities.World;

public class LocalData {

    private static World world = new World();

    public static World getWorld() {
        return world;
    }
}
