package com.survival.sim.client.input;

import com.survival.sim.client.game.Camera;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInputHandler extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            Camera.setCameraOffset(Camera.getCameraOffset().transform(-1, 0));
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP){
            Camera.setCameraOffset(Camera.getCameraOffset().transform(0, -1));
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            Camera.setCameraOffset(Camera.getCameraOffset().transform(1, 0));
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            Camera.setCameraOffset(Camera.getCameraOffset().transform(0, 1));
        }
    }
}
