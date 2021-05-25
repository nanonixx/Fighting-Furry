package com.mygdx.game;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Config.BaseImageButton;
import com.mygdx.game.Config.BaseScreen;

public class PantallaInicial extends BaseScreen {

    private Texture background;


    public PantallaInicial(MyGdxGame game) {
        super(game);
    }

    @Override
    public void show() {

        background = new Texture("FondoInicio.png");

        BaseImageButton buttonPlay = new BaseImageButton("play_rojo.png", "play_rojo_botonado.png", 166, 81, 448, 230);
        buttonPlay.onClick(()->setScreen(new SelectionScreen(game)));
        stage.addActor(buttonPlay);

        BaseImageButton buttonQuit = new BaseImageButton("quit.png", "quit_botonado.png", 166, 81, 557, 101);
        buttonQuit.onClick(()->System.exit(0));
        stage.addActor(buttonQuit);

        BaseImageButton buttonOptions = new BaseImageButton("optionsButton.png", "optionsButtonBotonado.png", 166, 81, 666, 230);
        buttonOptions.onClick(()->System.exit(0));
        stage.addActor(buttonOptions);
    }

    public void render(float delta) {
        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0);
        stage.getBatch().end();

        stage.act(delta);
        stage.draw();
    }
}
