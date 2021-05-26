package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Config.BaseImageButton;
import com.mygdx.game.Config.BaseScreen;

public class FinalScreen extends BaseScreen {

    Texture background;
    BaseImageButton buttonQuit;
    BaseImageButton buttonRestart;
    public FinalScreen(MyGdxGame game) {
        super(game);
    }

    @Override
    public void show() {
        if(Cosingas.juego.P1.salud <= 0){
            background = new Texture("fondos/gameOver.png");
            buttonRestart = new BaseImageButton("restart.png", "restart_botonado.png", 166, 81, 1004, 165);
            buttonQuit = new BaseImageButton("quit.png", "quit_botonado.png", 166, 81, 1004, 71);
        }else{
            background = new Texture("fondos/victoria.png");
            buttonRestart = new BaseImageButton("restart.png", "restart_botonado.png", 166, 81, 1004, 165);
            buttonQuit = new BaseImageButton("quit.png", "quit_botonado.png", 166, 81, 987, 40);
        }

        buttonQuit.onClick(()-> System.exit(0));
        buttonRestart.onClick(()-> setScreen(new PantallaInicial(game)));

        stage.addActor(buttonQuit);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0);
        stage.getBatch().end();
        stage.act(delta);
        stage.draw();
    }
}
