package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
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


        ImageButton.ImageButtonStyle buttonStartStyle = new ImageButton.ImageButtonStyle();
        BaseImageButton buttonPlay = new BaseImageButton("play_rojo.png", "play_rojo_botonado.png", 205, 100, 400, 150);
        buttonPlay.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                setScreen(new SelectionScreen(game));
                return true;
            }
        });
        stage.addActor(buttonPlay);

        ImageButton.ImageButtonStyle buttonQuitStyle = new ImageButton.ImageButtonStyle();
        BaseImageButton buttonQuit = new BaseImageButton("quit.png", "quit_botonado.png", 205, 100, 675, 150);
        buttonQuit.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.exit(0);
                return true;
            }
        });

        stage.addActor(buttonQuit);
    }

    public void render(float delta) {
        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0);
        stage.getBatch().end();

        stage.act(delta);
        stage.draw();
    }
}
