package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class LoadingScreen extends BaseScreen{
    public LoadingScreen(MyGdxGame game) {
        super(game);
    }


    @Override
    public void show() {
        
    }

    @Override
    public void render(float delta) {
        while(!game.assets.update()) return;

        setScreen(new PantallaInicial(game));
    }
}
