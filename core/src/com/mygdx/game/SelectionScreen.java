package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.BaseScreen;
import com.mygdx.game.MyGdxGame;

import java.awt.*;

public class SelectionScreen extends BaseScreen {


    private Texture background;

    public SelectionScreen(MyGdxGame game) {
        super(game);
    }

    @Override
    public void show(){


        background = new Texture("background.jpg");
        ImageButton.ImageButtonStyle buttonReadyStyle = new ImageButton.ImageButtonStyle();
        buttonReadyStyle.up = new TextureRegionDrawable(new TextureRegion(new Texture("readyButton.png")));
        buttonReadyStyle.over = new TextureRegionDrawable(new TextureRegion(new Texture("readyButtonPressed.png")));
        ImageButton buttonReady = new ImageButton(buttonReadyStyle);
        buttonReady.setPosition(525,54);
        buttonReady.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) { setScreen(new GameScreen(game));
                return true;
            }
        });
        stage.addActor(buttonReady);


        Image header = new Image(new Texture("header.png"));
        header.setPosition(0, 720-84);

        stage.topCenter.addActor(header);

//        Rectangle header = new Rectangle();


//        header.setSize(viewport.getScreenWidth(), 85);
//        header.setPosition(0, viewport.getTopGutterY());

//        ShapeRenderer headerRenderer = new ShapeRenderer();
//        headerRenderer.begin(ShapeRenderer.ShapeType.Filled);
//        headerRenderer.setColor(Color.GRAY);
//        headerRenderer.rect(0, 500, viewport.getScreenWidth(), 85);
//        headerRenderer.end();
    }

    @Override
    public void render(float delta) {
        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0);
        stage.getBatch().end();

        stage.act(delta);
        stage.draw();
    }
}
