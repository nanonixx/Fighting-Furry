package com.mygdx.game.Config;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class MyActor extends Actor {

    public int WIDTH, HEIGHT;
    public boolean flipped;
    public float dx, dy;

    public interface MyActorListener {
        void call();
    }

    public Animation<TextureRegion> animation;
    public float stateTime;

    @Override
    public void act(float delta) {
        super.act(delta);
        stateTime+= delta;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        int fp = 1, pos = 0;
        if (flipped){ //si está flippeado
            fp = -1; //se le da la vuelta
            pos= WIDTH; //para que la x no se ralle
        }
        super.draw(batch, parentAlpha);
        batch.draw(animation.getKeyFrame(stateTime),
                getX()+dx+pos, getY() + dy, getOriginX(), getOriginY(), getWidth() * fp, getHeight(), getScaleX(), getScaleY(), getRotation());
    }

    public void addListener(MyActorListener listener) {
        addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                listener.call();
                return false;
            }
        });
    }
}
