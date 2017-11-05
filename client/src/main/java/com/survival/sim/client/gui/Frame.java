package com.survival.sim.client.gui;

import com.survival.sim.client.game.Camera;
import com.survival.sim.client.game.LocalPlayer;
import com.survival.sim.client.game.Screen;
import com.survival.sim.client.input.KeyInputHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Frame extends JFrame{

    private static GamePanel gamePanel = new GamePanel();

    private static Frame instance = new Frame();

    public Frame() throws HeadlessException {
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Screen.setDimension(getSize());
                Camera.centerOn(LocalPlayer.getLocalPlayer());
            }
        });
        setContentPane(gamePanel);
        addKeyListener(new KeyInputHandler());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(600, 600));
    }

    public static Frame getInstance() {
        return instance;
    }
}
