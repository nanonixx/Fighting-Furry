package com.mygdx.game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.Assets;
import com.mygdx.game.Config.MyActor;
import com.mygdx.game.Move;

import static com.badlogic.gdx.utils.Align.center;

public class Gatito extends MyActor {

    private Move move;

    public String character;

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public Gatito(int dx, int dy, boolean flipped, String character) {
        WIDTH = 250;
        HEIGHT = 350;
        this.dx = dx;
        this.dy = dy;
        this.character = character; //no se usa de momento
        this.flipped = flipped;
        this.move = new Move(character, 0.4f);
        setSize(WIDTH, HEIGHT);
        setOrigin(center);
        animation = Assets.getAnimation(getMove().getName(), 0.4f, Animation.PlayMode.LOOP);
    }
}