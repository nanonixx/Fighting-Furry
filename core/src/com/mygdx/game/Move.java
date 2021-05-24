package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.mygdx.game.Objects.Gatito;

public class Move {

    private float ms;
    private String name;
    private boolean loop = true;

    Sound attackSound;

//   attackSound = Gdx.audio.newSound(Gdx.files.internal("sounds/????"));

    public float getMs() {
        return ms;
    }

    public String getName() {
        return name;
    }

    public Move(String name, float ms) {
        this.ms = ms;
        this.name = name;
    }

    public Animation.PlayMode loopMode() {
        if (loop) return Animation.PlayMode.LOOP;
        else return Animation.PlayMode.NORMAL;
        //Playmode.Normal???????¿¿¿ no hace bucle or algo del stateTime ya lo harè
    }



    public void punch(Gatito gatito){
        gatito.getMove().name = gatito.character+"_punch";
        gatito.getMove().ms = 0.05f;
        loop = false;
        gatito.addAction(Actions.moveBy(0, 0, 5));
//        attackSound.play(1.0f);
        gatito.stateTime = 0;
        //depende de si está flipped
    }

    public void ayuwoki(Gatito gatito, float delta){
        //es un png EH
        gatito.getMove().name = "ayuwoki";
        gatito.getMove().ms = 0.08f;
        loop = false;
        gatito.addAction(Actions.moveBy(-50, 0, 5)); //poner rotacion Jeje

        gatito.stateTime = 0;
    }

    public void idle(Gatito gatito){
        gatito.getMove().name = gatito.character;
        gatito.getMove().ms = 0.4f;
        loop = true;
        gatito.stateTime = 0;
        //depende de si está flipped
    }

    public void damage(Gatito gatito){
        gatito.getMove().name = "idle";
        gatito.getMove().ms = 0.8f;
        loop = false;
        gatito.addAction(Actions.moveBy(-5, 0, 0.4f));
        gatito.stateTime = 0;
        //depende de si está flipped
    }

}
