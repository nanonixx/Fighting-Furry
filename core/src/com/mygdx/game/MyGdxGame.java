package com.mygdx.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Config.BaseScreen;

public class MyGdxGame extends Game {

	SpriteBatch batch;
	Texture img;
	Assets assets;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		Cosingas.cliente = new Cliente();
		Cosingas.cliente.conectar();
		assets = new Assets();
		assets.load();
		setScreen(new LoadingScreen(this));
	}


	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	public BaseScreen getBaseScreen(){
		return (BaseScreen) getScreen();
	}
}
