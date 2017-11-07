package com.survival.sim.client.netty;



import com.survival.sim.common.util.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zachary Herridge on 8/3/2017.
 */
public class MessagePackage {

    public static final String SERVER = "SERVER";

    private static final Logger logger = LoggerFactory.getLogger(MessagePackage.class);

    private LocalDateTime creationTimestamp = LocalDateTime.now();
    private LocalDateTime insertTimestamp;

    private int messageType = Type.UNKNOWN;

    private String secondaryType;

    private String ownerID;
    private String destinationKey;
    private String sourceKey;
    private String responseToKey;
    private String responseKey;

    private Map<Integer, String> bodyJSON = new HashMap<>();

    public MessagePackage() {
    }

    public MessagePackage(int messageType, String destinationKey) {
        this.destinationKey = destinationKey;
        this.messageType = messageType;
    }

    public String getDestinationKey() {
        return destinationKey;
    }

    public <T> T getBodyAs(Class<T> tClass) {
        return getBodyAs(0, tClass);
    }

    public <T> T getBodyAs(int index, Class<T> tClass) {
        String json = bodyJSON.get(index);
        if (json == null) return null;
        return Json.getGson().fromJson(json, tClass);
    }

    public String getResponseToKey() {
        return responseToKey;
    }

    public MessagePackage setResponseToKey(String responseToKey) {
        this.responseToKey = responseToKey;
        return this;
    }

    public String getSourceKey() {
        return sourceKey;
    }

    public void setSourceKey(String sourceKey) {
        this.sourceKey = sourceKey;
    }

    public String getResponseKey() {
        return responseKey;
    }

    public MessagePackage setResponseKey(String responseKey) {
        this.responseKey = responseKey;
        return this;
    }

    public LocalDateTime getInsertTimestamp() {
        return insertTimestamp;
    }

    public MessagePackage setBody(Object object) {
        return setBody(0, object);
    }

    public MessagePackage setBody(int index, Object object) {
        if (object == null) return this;
        bodyJSON.put(index, Json.getGson().toJson(object));
        return this;
    }

    public MessagePackage setMessageType(int messageType) {
        this.messageType = messageType;
        return this;
    }

    public MessagePackage setDestinationKey(String destinationKey) {
        this.destinationKey = destinationKey;
        return this;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public MessagePackage setOwnerID(String ownerID) {
        this.ownerID = ownerID;
        return this;
    }

    public String getSecondaryType() {
        return secondaryType;
    }

    public MessagePackage setSecondaryType(String secondaryType) {
        this.secondaryType = secondaryType;
        return this;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setInsertTimestamp(LocalDateTime insertTimestamp) {
        this.insertTimestamp = insertTimestamp;
    }


    public interface Type {
        int UNKNOWN = 0;
        int WORLD_UPDATE = 1;
        int SET_PLAYER_UID = 2;

    }
}
