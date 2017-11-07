package com.survival.sim.client.input;

import com.survival.sim.client.game.Camera;
import com.survival.sim.client.game.LocalPlayer;
import com.survival.sim.client.netty.MessagePackage;
import com.survival.sim.client.netty.NettyClient;

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
        MessagePackage messagePackage = new MessagePackage(MessagePackage.Type.MOVE, null)
                .setBody(0, x)
                .setBody(1, y);
        NettyClient.getInstance().send(messagePackage);
    }
}
