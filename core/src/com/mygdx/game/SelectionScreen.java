package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.BaseScreen;
import com.mygdx.game.MyGdxGame;

public class SelectionScreen extends BaseScreen {
    public SelectionScreen(MyGdxGame game) {
        super(game);
    }

    @Override
    public void show(){
    ImageButton.ImageButtonStyle buttonStartStyle = new ImageButton.ImageButtonStyle();
    buttonStartStyle.up = new TextureRegionDrawable(new TextureRegion(new Texture("start.png")));
    buttonStartStyle.over = new TextureRegionDrawable(new TextureRegion(new Texture("startpressed.png")));
    ImageButton buttonStart = new ImageButton(buttonStartStyle);
        buttonStart.setPosition(30,10);
    //no cambia de tamaño, no se por qué
        buttonStart.setSize(24*10, 10*10);
        buttonStart.addListener(new InputListener(){
        @Override
        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
            setScreen(new GameScreen(game));
            return true;
        }
    });
        stage.middleCenter.addActor(buttonStart);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.7f, 0.54f, 0.87f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
    }
}
