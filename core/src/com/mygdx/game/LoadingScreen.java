package com.mygdx.game;

import com.mygdx.game.Config.BaseScreen;

public class LoadingScreen extends BaseScreen {
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
