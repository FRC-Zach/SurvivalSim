package com.survival.sim.client.gui;

import com.survival.sim.client.game.Camera;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Frame extends JFrame{


    private static GamePanel gamePanel = new GamePanel();

    public Frame() throws HeadlessException {
        setContentPane(gamePanel);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'a'){
                    Camera.setCameraOffset(Camera.getCameraOffset().transform(-1, 0));
                    repaint();
                }
            }
        });
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(800, 600));
    }
}
