package com.survival.sim.client.netty;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Zach on 9/27/2017.
 */
public class NettyClient {

    private static final Logger logger = LoggerFactory.getLogger(NettyClient.class);

    private NioEventLoopGroup group = null;

    private NettyClientHandler nettyClientHandler = new NettyClientHandler(this);
    private String host;

    public void start(String host) {
        this.host = host;
        group = new NioEventLoopGroup();
        configureBootstrap(new Bootstrap(), group).connect();
    }

    public void shutdown() {
        if (group != null) {
            group.shutdownGracefully();
            group = null;
        }
    }

    public Bootstrap configureBootstrap(Bootstrap bootstrap, EventLoopGroup g) {
        bootstrap.group(g)
                .channel(NioSocketChannel.class)
                .remoteAddress(host, 2052)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel channel) throws Exception {
                        channel.pipeline().addLast(
                                new ObjectDecoder(null),
                                new ObjectEncoder(),

                                nettyClientHandler
                        );
                    }
                });


        return bootstrap;
    }

    public void disconnect() {
        nettyClientHandler.close();
    }

    public boolean isConnected() {
        return nettyClientHandler.isConnected();
    }
}
