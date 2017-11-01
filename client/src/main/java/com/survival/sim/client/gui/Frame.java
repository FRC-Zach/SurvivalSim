package com.survival.sim.client.gui;

import com.survival.sim.client.input.KeyInputHandler;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{

    private static GamePanel gamePanel = new GamePanel();

    private static Frame instnace = new Frame();

    public Frame() throws HeadlessException {
        setContentPane(gamePanel);
        addKeyListener(new KeyInputHandler());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(800, 600));
    }

    public static Frame getInstnace() {
        return instnace;
    }
}
