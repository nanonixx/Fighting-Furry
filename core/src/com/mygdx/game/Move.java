package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.DelayAction;
import com.mygdx.game.Objects.Gatito;

public class Move {

   private float ms;
   private String name;
   private boolean loop = true;
   private Gatito gatito;

    public float getMs() {
        return ms;
    }

    public String getName() {
        return name;
    }


    public Move(Gatito gato, float ms) {
        this.ms = ms;
        this.gatito = gato;
    }

    public Animation.PlayMode loopMode() {
        if (loop) return Animation.PlayMode.LOOP;
        else return Animation.PlayMode.NORMAL;
        //Playmode.Normal???????¿¿¿ no hace bucle or algo del stateTime ya lo harè
    }


    public void kick(){
        gatito.getMove().name = "kick";
        gatito.getMove().ms = 0.02f;
        loop = false;
        gatito.addAction(Actions.moveBy(15, 5, 2));
        gatito.addAction(Actions.moveBy(-15, -5, 2));
        gatito.stateTime = 0;
        //depende de si está flipped, TODO
//        gatito.addAction(Actions.moveBy(-30, -30, 2));
    }

    public void punch(){
        gatito.getMove().name = "punching";
        gatito.getMove().ms = 0.03f;
        loop = true;
        gatito.addAction(Actions.moveBy(-50, 0, 5));
        gatito.stateTime = 0;
        //depende de si está flipped
    }

    public void bite(){
        gatito.getMove().name = "bite";
        gatito.getMove().ms = 0.08f;
        loop = false;
        gatito.addAction(Actions.moveBy(-50, 0, 5));
        gatito.stateTime = 0;
        //depende de si está flipped
    }

    public void idle(){
        gatito.getMove().name = gatito.character;
        gatito.getMove().ms = 0.4f;
        loop = true;
        gatito.stateTime = 0;
        //depende de si está flipped
    }

    public void damage(){
        gatito.getMove().name = "idle";
        gatito.getMove().ms = 0.8f;
        loop = false;
        gatito.addAction(Actions.moveBy(-5, 0, 0.4f));
        gatito.stateTime = 0;
        //depende de si está flipped
    }
}
