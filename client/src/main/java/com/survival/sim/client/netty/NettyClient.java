package com.survival.sim.client.netty;

import com.survival.sim.common.util.Json;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Zach on 9/27/2017.
 */
public class NettyClient {

    private static final Logger logger = LoggerFactory.getLogger(NettyClient.class);

    private static final NettyClient instance = new NettyClient();

    private NioEventLoopGroup group = null;

    private NettyChannelHandler nettyChannelHandler = new NettyChannelHandler(this);
    private String host;

    public static NettyClient getInstance() {
        return instance;
    }

    public void send(MessagePackage messagePackage){
        nettyChannelHandler.getContext().writeAndFlush(Json.getGson().toJson(messagePackage));
    }

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
                .handler(new NettyChannelInitializer(nettyChannelHandler));

        return bootstrap;
    }

    public void disconnect() {
        nettyChannelHandler.close();
    }

    public boolean isConnected() {
        return nettyChannelHandler.isConnected();
    }
}
