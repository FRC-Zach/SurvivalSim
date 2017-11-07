package com.survival.sim.client;

import com.survival.sim.client.netty.NettyClient;
import com.survival.sim.client.util.Events;

/**
 * Created by Zach on 10/16/2017.
 */
public class Bootstrap {

    public static void main(String[] args) {
        NettyClient.getInstance().start("localhost");
        Events.start();
    }

}
