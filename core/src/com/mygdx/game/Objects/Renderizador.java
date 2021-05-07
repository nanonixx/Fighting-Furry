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
    public String pj1;
    public String pj2;

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

    public void pjSeleccionado(String pj){
        if(pj.contains("2"))
            this.pj2 = pj;
        else
            this.pj1 = pj;
    }

}
