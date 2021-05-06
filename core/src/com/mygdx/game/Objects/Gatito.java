package com.mygdx.game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.Assets;
import com.mygdx.game.Move;

import static com.badlogic.gdx.utils.Align.center;

public class Gatito extends Actor {

    public Animation<TextureRegion> gatitoMoviendose;

    public float getStateTime() {
        return stateTime;
    }

    public float stateTime = 0; //frame de la animación en la que empieza
    private int dx, dy; //posicion del gatito en la pantalla
    private int WIDTH = 250, HEIGHT = 350;
    private Move move;

    public String character;


    private boolean flipped; //true: mira hacia la derecha | false: mira hacia la izquierda

    public boolean isFlipped() {
        return flipped;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public Gatito(int dx, int dy, boolean flipped, String character) {
        this.dx = dx;
        this.dy = dy;
        this.character = character; //no se usa de momento
        this.flipped = flipped;
        this.move = new Move(character, 0.4f);
        setSize(WIDTH, HEIGHT);
        setOrigin(center);
        gatitoMoviendose = Assets.getAnimation(getMove().getName(), 0.4f, Animation.PlayMode.LOOP);
    }


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
        batch.draw(gatitoMoviendose.getKeyFrame(stateTime),
                getX()+dx+pos, getY() + dy, getOriginX(), getOriginY(), getWidth() * fp, getHeight(), getScaleX(), getScaleY(), getRotation());
    }
}