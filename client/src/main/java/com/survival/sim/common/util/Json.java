package com.survival.sim.common.util;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import com.survival.sim.common.entities.Player;
import com.survival.sim.common.entities.World;
import com.survival.sim.common.entities.interfaces.Locatable;

import java.util.ArrayList;
import java.util.List;

public class Json {

    private static final Gson gson;

    static {
        final RuntimeTypeAdapterFactory<Locatable> typeFactory = RuntimeTypeAdapterFactory
                .of(Locatable.class, "type")
                .registerSubtype(Player.class);

        gson = new GsonBuilder()
                .registerTypeAdapterFactory(typeFactory)
                .create();
    }

    public static Gson getGson() {
        return gson;
    }


    public static void main(String[] args) {
        List<Locatable> locatables = new ArrayList<>();
        locatables.add(new Player("asdasd"));


        World world = new World();
        world.getEntities().add(new Player("asdasd"));

        String s = getGson().toJson(world);
        World world1 = getGson().fromJson(s, World.class);
        System.out.println();


    }

}
