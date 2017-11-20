package com.survival.sim.server.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * Created by Zach on 9/27/2017.
 */
public class NettyChannelInitializer extends ChannelInitializer<SocketChannel> {

    /***
     * Initializes the pipeline of the param socket.
     * @param socketChannel SocketChannel to init.
     * @throws Exception
     */
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();

        pipeline.addLast(

                new ObjectEncoder(),
                new ObjectDecoder(Integer.MAX_VALUE,null),

                new NettyChannelHandler()
        );
    }
}
