package com.survival.sim.server;

import com.survival.sim.server.netty.NettyServer;

/**
 * Created by Zach on 10/16/2017.
 */
public class Bootstrap {

    public static void main(String[] args) {
        NettyServer.start();
        System.out.println("Test");
    }
}
