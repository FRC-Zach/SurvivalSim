package com.survival.sim.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import com.survival.sim.common.entities.Player;
import com.survival.sim.common.entities.Tile;
import com.survival.sim.common.entities.WorldObject;
import com.survival.sim.common.entities.interfaces.Locatable;
import com.survival.sim.common.entities.tile.types.ObjectGrass;
import com.survival.sim.common.entities.tile.types.ObjectWater;

public class Json {

    private static final Gson gson;

    static {
        final RuntimeTypeAdapterFactory<Locatable> typeFactory = RuntimeTypeAdapterFactory
                .of(Locatable.class, "type")
                .registerSubtype(Player.class)
                .registerSubtype(Tile.class)
                .registerSubtype(WorldObject.class)
                .registerSubtype(ObjectGrass.class)
                .registerSubtype(ObjectWater.class);

        gson = new GsonBuilder()
                .registerTypeAdapterFactory(typeFactory)
                .create();
    }

    public static Gson getGson() {
        return gson;
    }
}
