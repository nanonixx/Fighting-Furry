package com.mygdx.game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.Config.MyLabel;
import com.mygdx.game.GameScreen;
import com.mygdx.game.MyGdxGame;
import main.java.Mensaje;

public class Renderizador {

    MyGdxGame game;
    Label label;
    Mano mano;
    public boolean irAPantallaJuego;

    public Renderizador(MyGdxGame game) {
        this.game = game;
        label = new MyLabel(Color.RED);

        game.getBaseScreen().stage.middleCenter.addActor(label);
    }


    public void mostrarMensaje(String text){
        label.setText(text);
    }

    public void irAPantallaJuego(){
        //Gdx.app.postRunnable(()->{game.getBaseScreen().setScreen(new GameScreen(game));});
        irAPantallaJuego = true;
    }

}
