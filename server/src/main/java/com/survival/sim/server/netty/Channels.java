package com.survival.sim.server.netty;

import java.util.ArrayList;
import java.util.List;

public class Channels {

    private static List<NettyChannelHandler> channelHandlers = new ArrayList<>();
    private static final Object LOCK = new Object();


    public static void add(NettyChannelHandler channel){
        synchronized (LOCK){
            channelHandlers.add(channel);
        }
    }

    public static void remove(NettyChannelHandler channel){
        synchronized (LOCK){
            channelHandlers.remove(channel);
        }
    }

    public static List<NettyChannelHandler> getChannelHandlers() {
        return channelHandlers;
    }
}
