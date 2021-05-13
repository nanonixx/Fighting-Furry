package com.mygdx.game.Objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.Config.MyLabel;
import com.mygdx.game.MyGdxGame;

public class Renderizador {

    MyGdxGame game;
    Label label;
    public Mano mano;
    public boolean irAPantallaJuego;
    public String pj1;
    public String pj2;
    public boolean acabat = false;
    public boolean torn;

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

    public void pjSeleccionado(String gato, String gato2){
        this.pj1 = gato;
        this.pj2 = gato2;
    }

    public void ponerCartas(Mano mano) {
        this.mano = mano;
    }
}
