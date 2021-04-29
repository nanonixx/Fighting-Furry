package com.mygdx.game.Objects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.Assets;

import static com.badlogic.gdx.utils.Align.center;

public class Gatito extends Actor {

    Animation<TextureRegion> gatitoMoviendose;
    float stateTime = 0; //frame de la animación en la que empieza
    int dx, dy; //posicion del gatito en la pantalla
    boolean flipped; //true: mira hacia la derecha | false: mira hacia la izquierda
    int WIDTH = 300, HEIGHT = 300;

    public Gatito(int dx, int dy, boolean flipped) {
        this.dx = dx;
        this.dy = dy;
        this.flipped = flipped;
        setSize(WIDTH, HEIGHT);
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
        int fp = 1, pos = 0;
        if (flipped){
            fp = -1;
            pos= WIDTH;
        }
        super.draw(batch, parentAlpha);
        batch.draw(gatitoMoviendose.getKeyFrame(stateTime),
                getX()+dx+pos, getY() + dy, getOriginX(), getOriginY(), getWidth() * fp, getHeight(), getScaleX(), getScaleY(), getRotation());
    }
}