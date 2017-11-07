package com.survival.sim.common.util;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import com.survival.sim.common.entities.Player;
import com.survival.sim.common.entities.Tile;
import com.survival.sim.common.entities.World;
import com.survival.sim.common.entities.WorldTile;
import com.survival.sim.common.entities.interfaces.Locatable;
import com.survival.sim.common.entities.tile.types.TileGrass;
import com.survival.sim.common.entities.tile.types.TileWater;

import java.util.ArrayList;
import java.util.List;

public class Json {

    private static final Gson gson;

    static {
        final RuntimeTypeAdapterFactory<Locatable> typeFactory = RuntimeTypeAdapterFactory
                .of(Locatable.class, "type")
                .registerSubtype(Player.class)
                .registerSubtype(Tile.class)
                .registerSubtype(WorldTile.class)
                .registerSubtype(TileGrass.class)
                .registerSubtype(TileWater.class);

        gson = new GsonBuilder()
                .registerTypeAdapterFactory(typeFactory)
                .create();
    }

    public static Gson getGson() {
        return gson;
    }
}
