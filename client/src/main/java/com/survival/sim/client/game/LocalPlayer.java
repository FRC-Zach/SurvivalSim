package com.survival.sim.client.game;

import com.survival.sim.common.entities.Player;

public class LocalPlayer {

    private static String uid;

    /**
     * Finds the local player.
     * @return the local player.
     */
    public static Player getLocalPlayer() {
        if (LocalData.getWorld() != null)
            return (Player) LocalData.getWorld().getEntities().stream().filter(locatable -> locatable instanceof Player && ((Player) locatable).getUid().equals(uid)).findAny().orElse(null);
        return null;
    }

    public static void setUID(String uid) {
        LocalPlayer.uid = uid;
    }
}
