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

    @Override
    public void show() {
        ImageButton.ImageButtonStyle buttonStartStyle = new ImageButton.ImageButtonStyle();
        buttonStartStyle.up = new TextureRegionDrawable(new TextureRegion(new Texture("start.png")));
        buttonStartStyle.over = new TextureRegionDrawable(new TextureRegion(new Texture("startpressed.png")));
        ImageButton buttonStart = new ImageButton(buttonStartStyle);
        buttonStart.setPosition(30,10);
//        buttonStart.setSize(24*10, 10*10);
        buttonStart.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                setScreen(new LoadingScreen(game));
                return true;
            }
        });
        stage.middleCenter.addActor(buttonStart);

        ImageButton.ImageButtonStyle buttonQuitStyle = new ImageButton.ImageButtonStyle();
        buttonQuitStyle.up = new TextureRegionDrawable(new TextureRegion(new Texture("quit.png")));
        buttonQuitStyle.over = new TextureRegionDrawable(new TextureRegion(new Texture("quitpressed.png")));
        ImageButton buttonQuit = new ImageButton(buttonQuitStyle);

        buttonQuit.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
                System.exit(0);
                return true;
            }
        });

        stage.middleCenter.addActor(buttonQuit);
    }
}
