package com.survival.sim.common.entities.interfaces;

import com.survival.sim.common.entities.Tile;

import java.io.Serializable;

/**
 * Created by Zach on 10/16/2017.
 */
public interface Locatable extends Serializable {

    Tile getLocation();

}
