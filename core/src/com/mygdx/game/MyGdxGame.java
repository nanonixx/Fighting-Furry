package com.mygdx.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Config.BaseScreen;
import com.mygdx.game.Objects.Juego;

public class MyGdxGame extends Game {

	Assets assets;

	@Override
	public void create () {


		Cosingas.juego = new Juego(this);
		assets = new Assets();
		assets.load();
		setScreen(new LoadingScreen(this));
	}

	public BaseScreen getBaseScreen(){
		return (BaseScreen) getScreen();
	}
}
