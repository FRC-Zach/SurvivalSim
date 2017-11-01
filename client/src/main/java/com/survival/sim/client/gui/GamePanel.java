package com.survival.sim.client.gui;

import com.survival.sim.client.game.GameData;
import com.survival.sim.client.game.LocalPlayer;
import com.survival.sim.common.entities.WorldTile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GamePanel extends JPanel {

    private static final Logger logger = LoggerFactory.getLogger(GamePanel.class);

    public GamePanel() {

    }

    @Override
    public void paint(Graphics g) {
        try{
            WorldTile[][] worldTiles = GameData.getWorld().getTiles()[LocalPlayer.getLocalPlayer().getLocation().getPlane()];
            for (WorldTile[] worldTile : worldTiles) {
                for (WorldTile tile : worldTile) {
                    tile.render((Graphics2D) g);
                }
            }

            LocalPlayer.getLocalPlayer().render((Graphics2D) g);
        } catch (IOException e) {
            logger.error("Error during rendering scene.", e);
        }
    }
}
