package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.mygdx.game.Objects.Gatito;

public class GameScreen extends BaseScreen {

    public GameScreen(MyGdxGame game) {
        super(game);
    }
    Gatito gatito;

    @Override
    public void show() {
        stage.addActor(gatito = new Gatito());
        gatito.addAction(Actions.moveBy(30, 30, 1));
        gatito.addAction(Actions.rotateBy(360 * 10, 0.2f));

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.7f, 0.54f, 0.87f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
    }
}