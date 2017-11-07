package com.survival.sim.client.game;

import com.survival.sim.common.entities.Player;

public class LocalPlayer {

    private static String uid;

    public static Player getLocalPlayer() {
        return (Player) LocalData.getWorld().getEntities().stream().filter(locatable -> locatable instanceof Player && ((Player) locatable).getUid().equals(uid)).findAny().orElse(null);
    }

    public static void setUID(String uid) {
        LocalPlayer.uid = uid;
    }
}
