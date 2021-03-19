package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class PantallaInicial extends BaseScreen{
    public PantallaInicial(MyGdxGame game) {
        super(game);
    }

    Stage stage;

    @Override
    public void show() {

        ImageButton.ImageButtonStyle buttonStartStyle = new ImageButton.ImageButtonStyle();
        buttonStartStyle.up = new TextureRegionDrawable(new TextureRegion(new Texture("start.png")));
        buttonStartStyle.over = new TextureRegionDrawable(new TextureRegion(new Texture("startpressed.png")));
        ImageButton buttonStart = new ImageButton(buttonStartStyle);
        buttonStart.setPosition(200,200);
        buttonStart.setSize(24*3, 10*3);

        buttonStart.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                setScreen(new LoadingScreen(game));
                return true;
            }
        });

        ImageButton.ImageButtonStyle buttonQuitStyle = new ImageButton.ImageButtonStyle();
        buttonQuitStyle.up = new TextureRegionDrawable(new TextureRegion(new Texture("quit.png")));
        buttonQuitStyle.over = new TextureRegionDrawable(new TextureRegion(new Texture("quitpressed.png")));
        ImageButton buttonQuit = new ImageButton(buttonQuitStyle);
        buttonQuit.setPosition(200, 100);
        buttonQuit.setSize(24*3, 10*3);
        buttonQuit.addListener(new InputListener(){

        });
        Gdx.input.setInputProcessor(stage = new Stage());
        stage.addActor(buttonStart);
        stage.addActor(buttonQuit);
    }

    @Override
    public void render(float delta) {
        stage.act();
        stage.draw();
    }
}
