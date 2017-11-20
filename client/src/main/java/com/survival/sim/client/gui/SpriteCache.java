package com.survival.sim.client.gui;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SpriteCache {

    private static final Map<String, BufferedImage> cache = new HashMap<>();

    /**
     * Loads and caches sprites.
     * @param path
     * @return
     */
    public static BufferedImage load(String path){
        return cache.computeIfAbsent(path, s -> {
            try {
                return ImageIO.read(ClassLoader.getSystemResourceAsStream(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        });
    }


}
