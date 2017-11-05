package com.survival.sim.client.input;

import com.survival.sim.client.game.Camera;
import com.survival.sim.client.game.LocalPlayer;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInputHandler extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A){
            movePlayer(-1, 0);
        }
        if (e.getKeyCode() == KeyEvent.VK_W){
            movePlayer(0, -1);
        }
        if (e.getKeyCode() == KeyEvent.VK_D){
            movePlayer(1, 0);
        }
        if (e.getKeyCode() == KeyEvent.VK_S){
            movePlayer(0, 1);
        }

        Camera.centerOn(LocalPlayer.getLocalPlayer());
    }

    private void movePlayer(int x, int y){
        LocalPlayer.getLocalPlayer().movePlayer(x, y);
    }
}
