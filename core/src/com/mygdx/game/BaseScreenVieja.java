package com.mygdx.game;

import com.badlogic.gdx.Screen;

public class BaseScreenVieja implements Screen {
    public final MyGdxGame game;
    public BaseScreenVieja(MyGdxGame game){ this.game = game; }
    public void setScreen(Screen screen){ game.setScreen(screen); }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
