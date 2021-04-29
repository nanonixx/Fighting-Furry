package com.mygdx.game;

public class PantallaLoading extends BaseScreen {
    public PantallaLoading(MyGdxGame game) {
        super(game); }

    @Override
    public void render(float delta) {
        while(!game.assets.update()) return;

        setScreen(new PantallaInicial(game));
    }
}
