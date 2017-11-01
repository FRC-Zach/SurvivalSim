package com.survival.sim.client;

import com.survival.sim.client.gui.Frame;
import com.survival.sim.client.netty.NettyClient;

/**
 * Created by Zach on 10/16/2017.
 */
public class Bootstrap {

    public static void main(String[] args) {
        NettyClient nettyClient = new NettyClient();
        nettyClient.start("localhost");


        new Frame();
    }

}
