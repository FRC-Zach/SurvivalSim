package com.survival.sim.common.entities;

import java.util.ArrayList;
import java.util.List;

public class AnimationSequence {

    private ArrayList<String> spritePaths;
    private int spriteIndex;


    public AnimationSequence(){
        spritePaths = new ArrayList<>();
        spriteIndex = 0;
    }

    /***
     *
     * @return The path to the next sprite.
     */
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

    /***
     *
     * @param spr path to the next sprite,
     */
    public void addSpritePath(String spr){
        spritePaths.add(spr);
    }

    /***
     *
     * @param sprites paths to the next sprite,
     */
    public void addSpritePaths(ArrayList<String> sprites){
        spritePaths.addAll(sprites);
    }
}
