package com.survival.sim.client.game;

import com.survival.sim.common.entities.World;

public class LocalData {

    private static World world;

    public static World getWorld() {
        return world;
    }

    public static void setWorld(World world) {
        LocalData.world = world;
    }
}
