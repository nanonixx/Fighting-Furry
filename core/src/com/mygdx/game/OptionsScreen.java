package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.AssetLoader;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.mygdx.game.Config.BaseImageButton;
import com.mygdx.game.Config.BaseScreen;
import com.mygdx.game.MyGdxGame;

public class OptionsScreen extends BaseScreen {

    private Texture background;
    String ipAdress;
    private TextField input;

    public OptionsScreen(MyGdxGame game) {
        super(game);
    }

    @Override
    public void show() {
        background = new Texture("options.png");

        BaseImageButton buttonDone = new BaseImageButton("button/done.png", "button/done_botonado.png", 166, 81, 558, 100);

        buttonDone.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                String ipAdress = input.getText();
                setScreen(new PantallaInicial(game));

                return super.touchDown(event, x, y, pointer, button);
            }
        });

        stage.addActor(buttonDone);

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Pixeled.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        Image fondito = new Image(new Texture("button/inputField.png"));
        fondito.setPosition(630, 271);
        stage.addActor(fondito);

        TextField.TextFieldStyle style = new TextField.TextFieldStyle();
        style.font = generator.generateFont(parameter);
//        style.font = new BitmapFont();

//        "button/inputField.png"
        style.fontColor = Color.BLACK;

        input = new TextField("", style);
        input.setPosition(651, 271);
        input.setSize(390, 45);
        stage.addActor(input);



    }

    public void render(float delta) {
        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0);
        stage.getBatch().end();


        stage.act(delta);
        stage.draw();
    }
}
