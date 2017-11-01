package com.survival.sim.common.entities;

import java.util.ArrayList;
import java.util.List;

public class AnimationSequence {

    private ArrayList<String> spritePaths;
    private int spriteIndex;


    public AnimationSequence(){
        spritePaths = new ArrayList<String>();
        spriteIndex = 0;
    }

    public String getNextSprite(){
        if (spritePaths.size() == 0){
            return "";
        }
        String tmp = spritePaths.get(spriteIndex);
        spriteIndex++;
        if (spriteIndex >= spritePaths.size()){
            spriteIndex = 0;
        }
        return tmp;
    }

    public void addSpritePath(String spr){
        spritePaths.add(spr);
    }

    public void addSpritePaths(ArrayList<String> sprites){
        spritePaths.addAll(sprites);
    }
}
