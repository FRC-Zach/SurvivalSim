package com.survival.sim.client.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.EventLoop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Zach on 9/27/2017.
 */
@ChannelHandler.Sharable
public class NettyChannelHandler extends ChannelInboundHandlerAdapter {

    private static final int RECONNECT_DELAY = 5;

    private static final Logger logger = LoggerFactory.getLogger(NettyChannelHandler.class);

    private NettyClient client;
    private ChannelHandlerContext context;


    public NettyChannelHandler(NettyClient client) {
        this.client = client;
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
        logger.error("Error during Netty execution. ", cause);
        logger.debug("Error context. {}", ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.info("Channel active. {}", ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        scheduleReconnect(ctx);
    }

    private void scheduleReconnect(final ChannelHandlerContext ctx){
        EventLoop baseEventLoop = ctx.channel().eventLoop();
        if (baseEventLoop.isShutdown() || baseEventLoop.isShuttingDown()) return;

        baseEventLoop.schedule(() -> {
            client.configureBootstrap(new Bootstrap(), baseEventLoop).connect();
        }, RECONNECT_DELAY, TimeUnit.SECONDS);

        logger.info("Scheduled reconnect with {} second delay.", RECONNECT_DELAY);
    }


    public void close() {
        try {
            if (context != null) {
                logger.info("Disconnecting socket channel.");
                context.channel().disconnect();
            }
        }
        catch (Throwable e){
            logger.error("Error during closing.", e);
        }
    }

    public boolean isConnected() {
        return context != null && context.channel().isOpen();
    }
}
