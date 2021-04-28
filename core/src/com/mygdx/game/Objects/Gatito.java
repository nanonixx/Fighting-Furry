package com.mygdx.game.Objects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.Assets;

import static com.badlogic.gdx.utils.Align.center;

public class Gatito extends Actor {

    Animation<TextureRegion> gatitoMoviendose;
    float stateTime = 0;

    public Gatito() {
        setSize(300, 300);
        setOrigin(center);
        gatitoMoviendose = Assets.getAnimation("idle", 0.4f, Animation.PlayMode.LOOP);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        stateTime+= delta;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(gatitoMoviendose.getKeyFrame(stateTime),
                getX()+getWidth(), getY(), getOriginX(), getOriginY(), -getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }
}