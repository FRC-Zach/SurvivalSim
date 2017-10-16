package com.survival.sim.client.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.EventLoop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Zach on 9/27/2017.
 */
@ChannelHandler.Sharable
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(NettyClientHandler.class);

    private NettyClient client;
    private ChannelHandlerContext context;


    public NettyClientHandler(NettyClient nettyClient) {
        this.client = nettyClient;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        context = ctx;
        logger.info("Connected!");
        ctx.channel().writeAndFlush("Hi Server!");
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        scheduleReconnect(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {

    }

    private void scheduleReconnect(final ChannelHandlerContext ctx){
        final EventLoop loop = ctx.channel().eventLoop();
        if (!loop.isShutdown() && !loop.isShuttingDown()){
            loop.schedule(() -> {
                logger.info("Starting reconnect.");
                client.configureBootstrap(new Bootstrap(), loop).connect();
            }, 5, TimeUnit.SECONDS);
        }
    }


    public void close() {
        try {
            if (context != null) context.channel().disconnect();
        }
        catch (Throwable e){
            logger.error("Error during closing.", e);
        }
    }

    public boolean isConnected() {
        return context != null && context.channel().isOpen();
    }
}
