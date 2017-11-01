package com.survival.sim.client.game;

import java.awt.*;

public class Screen {

    private static Dimension dimension;
    private static int tileSize = 64;

    public static void setDimension(Dimension dimension) {
        Screen.dimension = dimension;
    }

    public static Dimension getDimension() {
        return dimension;
    }

    public static int getTileSize() {
        return tileSize;
    }
}