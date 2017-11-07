package com.survival.sim.client.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * Created by Zach on 10/17/2017.
 */
public class NettyChannelInitializer extends ChannelInitializer<SocketChannel> {

    private NettyChannelHandler nettyChannelHandler;

    public NettyChannelInitializer(NettyChannelHandler nettyChannelHandler) {
        this.nettyChannelHandler = nettyChannelHandler;
    }

    @Override
    public void initChannel(SocketChannel channel) throws Exception {
        channel.pipeline().addLast(
                new ObjectDecoder(Integer.MAX_VALUE,null),
                new ObjectEncoder(),
                nettyChannelHandler
        );
    }
}
