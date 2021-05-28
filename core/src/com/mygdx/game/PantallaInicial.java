package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
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
        if(Cosingas.music == null) {
            Cosingas.music = Gdx.audio.newMusic(Gdx.files.internal("sounds/title_theme1.ogg"));
            Cosingas.music.setLooping(true);
            Cosingas.music.play();
        }

        BaseImageButton buttonPlay = new BaseImageButton("play_rojo.png", "play_rojo_botonado.png", 166, 81, 448, 230);

        buttonPlay.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Cosingas.cliente = new Cliente();
		        Cosingas.cliente.conectar();
                setScreen(new SelectionScreen(game));
                return super.touchDown(event, x, y, pointer, button);
            }
        });

        stage.addActor(buttonPlay);

        BaseImageButton buttonQuit = new BaseImageButton("quit.png", "quit_botonado.png", 166, 81, 557, 101);
        buttonQuit.onClick(()->System.exit(0));
        stage.addActor(buttonQuit);

        BaseImageButton buttonOptions = new BaseImageButton("optionsButton.png", "optionsButtonBotonado.png", 166, 81, 666, 230);
        buttonOptions.onClick(()->setScreen(new OptionsScreen(game)));
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
