package com.mygdx.game.Config;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;
import main.java.Mensaje;

public class BaseScreen implements Screen {
    public final MyGdxGame game;
    public final MyStage stage;
    public final Table table;
    public OrthographicCamera camera;
    public Viewport viewport;
    private static float WIDTH = 1280;
    private static float HEIGHT = 720;

    public BaseScreen(MyGdxGame game) {
        this.game = game;
        Gdx.graphics.setTitle("Fighting Furry");
        camera = new OrthographicCamera();
        camera.position.set(WIDTH/2, HEIGHT/2, 0);
        viewport = new FitViewport(WIDTH, HEIGHT, camera);
        viewport.apply();
        Gdx.input.setInputProcessor(stage = new MyStage(viewport));
        table = new Table();
    }

    public void setScreen(Screen screen){
        System.out.println(game);
        game.setScreen(screen);
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.getBatch().setProjectionMatrix(camera.combined);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width ,height);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        stage.dispose();
    }

    void setScreen(BaseScreen screen) {
        game.setScreen(screen);
    }

    public void mensaje(Mensaje mensaje) {}
}