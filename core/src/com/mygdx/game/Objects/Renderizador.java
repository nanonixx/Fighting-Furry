package com.mygdx.game.Objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.Config.MyLabel;
import com.mygdx.game.Config.MyStage;

import java.awt.*;

public class Renderizador {

    MyStage stage;
    Label label;
    Mano mano;

    public Renderizador(MyStage stage) {
        this.stage = stage;
        label = new MyLabel(Color.RED);

        stage.middleCenter.addActor(label);
    }


    public void mostrarMensaje(String text){
        label.setText(text);
    }

}
