package com.mygdx.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Assets extends AssetManager {

    //TexturePacker: para crear atlas

    public static TextureAtlas atlas;

    public void load(){
        load("miatles.atlas", TextureAtlas.class);
    }

    @Override public synchronized boolean update(){
        boolean update = super.update();

        if(update){
            atlas = get("miatles.atlas", TextureAtlas.class);
        }
        return update;
    }


    public static Animation<TextureRegion> getAnimation(String name, float time, Animation.PlayMode playMode){
        return new Animation<TextureRegion>(time, atlas.findRegions(name), playMode);
    }

    public static TextureRegionDrawable getDrawable(String name){
        return new TextureRegionDrawable(atlas.findRegion(name));
    }
}
