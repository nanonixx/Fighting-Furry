package com.mygdx.game.Config;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.Assets;
import com.mygdx.game.GameScreen;

public class BaseImageButton extends ImageButton {
    public interface OnClick {
        void onClick();
    }

    public BaseImageButton(String image_up, String image_over, int ancho, int alto, int x, int y, final OnClick listener){
        super(new ImageButtonStyle());

        getStyle().up = new TextureRegionDrawable(new TextureRegion(new Texture(image_up)));
        getStyle().over = new TextureRegionDrawable(new TextureRegion(new Texture(image_over)));
        setSize(ancho, alto);
        setPosition(x, y);

        addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                listener.onClick();
                return true;
            }
        });
    }
}
