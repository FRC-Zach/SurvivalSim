package com.survival.sim.server.netty;

import com.google.gson.reflect.TypeToken;
import com.survival.sim.client.game.LocalData;
import com.survival.sim.client.netty.MessagePackage;
import com.survival.sim.common.entities.Player;
import com.survival.sim.common.entities.Tile;
import com.survival.sim.common.entities.interfaces.Locatable;
import com.survival.sim.common.util.Json;
import com.survival.sim.server.game.GameData;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Zach on 9/27/2017.
 */
public class NettyChannelHandler extends ChannelInboundHandlerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(NettyChannelHandler.class);

    private static ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    private static final Executor executor = Executors.newCachedThreadPool();

    private Player player = new Player("Player" + ThreadLocalRandom.current().nextInt(0, 100));

    private ChannelHandlerContext ctx;


    public static void sendWorld(){
        try {
            String s = Json.getGson().toJson(GameData.getWorld());
            MessagePackage messagePackage = new MessagePackage(MessagePackage.Type.WORLD_UPDATE, null).setBody(s);
            for (NettyChannelHandler nettyChannelHandler : Channels.getChannelHandlers()) {
                try {
                    nettyChannelHandler.send(messagePackage);
                }
                catch (Throwable e){
                    logger.error("Error during sending game world.", e);
                }
            }
        }
        catch (Throwable e){
            logger.error("Error during sending game world.", e);
        }
    }

    public static void sendEntities(){
        final TypeToken<List<Locatable>> requestListTypeToken = new TypeToken<List<Locatable>>(){};

        try {
            String s = Json.getGson().toJson(GameData.getWorld().getEntities(), requestListTypeToken.getType());
            MessagePackage messagePackage = new MessagePackage(MessagePackage.Type.ENTITY_UPDATE, null).setBody(s);
            for (NettyChannelHandler nettyChannelHandler : Channels.getChannelHandlers()) {
                try {
                    nettyChannelHandler.send(messagePackage);
                }
                catch (Throwable e){
                    logger.error("Error during sending game entities.", e);
                }
            }
        }
        catch (Throwable e){
            logger.error("Error during sending game entities.", e);
        }
    }


    public ChannelHandlerContext getCtx() {
        return ctx;
    }

    public void send(MessagePackage messagePackage){
        ctx.writeAndFlush(Json.getGson().toJson(messagePackage));
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        MessagePackage messagePackage = Json.getGson().fromJson((String) msg, MessagePackage.class);

        if (messagePackage.getMessageType() == MessagePackage.Type.MOVE){
            int x = messagePackage.getBodyAs(0, Integer.class);
            int y = messagePackage.getBodyAs(1, Integer.class);

            player.movePlayer(x, y, GameData.getWorld());
            sendEntities();
        }
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        this.ctx = ctx;
        logger.info("Channel active. {}", ctx.channel().remoteAddress());
        Channels.add(this);
        player.setLocation(new Tile(4 + ThreadLocalRandom.current().nextInt(-2, 2), 5 + ThreadLocalRandom.current().nextInt(-2, 2), 0 ));

        GameData.getWorld().getEntities().add(player);
        send(new MessagePackage(MessagePackage.Type.SET_PLAYER_UID, null).setBody(player.getUid()));
        sendWorld();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        logger.info("Channel unregistered. {}", ctx);
        Channels.remove(this);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.error("Error during Netty execution. ", cause);
        logger.debug("Error context. {}", ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

    }
}
