package com.survival.sim.common.entities.tile.types;

import com.survival.sim.common.entities.AnimationSequence;
import com.survival.sim.common.entities.WorldTile;
import com.survival.sim.common.entities.interfaces.Locatable;
import java.util.ArrayList;
import java.util.List;

public class TileGrass extends WorldTile {

    private AnimationSequence animationSequence = new AnimationSequence();
    private List<Locatable> entities = new ArrayList<>();

    public TileGrass(int plane, int x, int y){
        super(plane, x, y);
        super.addSprite("imgs/Grass.png");
    }
}
