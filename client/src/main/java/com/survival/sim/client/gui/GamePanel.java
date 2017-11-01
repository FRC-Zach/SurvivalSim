package com.survival.sim.client.gui;

import com.survival.sim.client.game.Camera;
import com.survival.sim.client.game.GameData;
import com.survival.sim.client.game.LocalPlayer;
import com.survival.sim.common.entities.WorldTile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {


    public GamePanel() {

    }

    @Override
    public void paint(Graphics g) {
        WorldTile[][] worldTiles = GameData.getWorld().getTiles()[LocalPlayer.getLocalPlayer().getLocation().getPlane()];
        for (WorldTile[] worldTile : worldTiles) {
            for (WorldTile tile : worldTile) {
                tile.render((Graphics2D) g);
            }
        }
    }
}
