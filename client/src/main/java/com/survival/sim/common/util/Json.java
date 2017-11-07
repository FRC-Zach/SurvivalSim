package com.survival.sim.common.util;

import com.google.gson.Gson;

public class Json {

    private static final Gson gson = new Gson();

    public static Gson getGson() {
        return gson;
    }
}
