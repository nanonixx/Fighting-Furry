package com.mygdx.game.Objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.Config.MyLabel;
import com.mygdx.game.Config.MyStage;
import com.mygdx.game.GameScreen;
import com.mygdx.game.MyGdxGame;

public class Renderizador {

    MyGdxGame game;
    Label label;
    Mano mano;

    public Renderizador(MyGdxGame game) {
        this.game = game;
        label = new MyLabel(Color.RED);

        game.getBaseScreen().stage.middleCenter.addActor(label);
    }


    public void mostrarMensaje(String text){
        label.setText(text);
    }

    public void irAPantallJuego(){
        System.out.println("AAAAAAAA");
        game.getBaseScreen().setScreen(new GameScreen(game));
    }

}
