package com.survival.sim.client.input;

import com.survival.sim.client.game.Camera;
import com.survival.sim.client.game.LocalPlayer;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInputHandler extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            movePlayer(-1, 0);
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP){
            movePlayer(0, -1);
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            movePlayer(1, 0);
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            movePlayer(0, 1);
        }

        Camera.centerOn(LocalPlayer.getLocalPlayer());
    }

    private void movePlayer(int x, int y){
        LocalPlayer.getLocalPlayer().setLocation(LocalPlayer.getLocalPlayer().getLocation().transform(x, y));
    }
}
