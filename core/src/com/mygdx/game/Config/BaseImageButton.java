package com.mygdx.game.Config;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class BaseImageButton extends ImageButton {
    private InputListener inputListener;

    public interface OnClick {
        void onClick();
    }

    public BaseImageButton(String image_up, String image_over, int ancho, int alto, int x, int y){
        super(new ImageButtonStyle());

        getStyle().up = new TextureRegionDrawable(new TextureRegion(new Texture(image_up)));
        getStyle().over = new TextureRegionDrawable(new TextureRegion(new Texture(image_over)));
        setSize(ancho, alto);
        setPosition(x, y);
    }

    public interface Callback { void call();}
    public void onEnter(final Callback callback){
        addListener(new InputListener(){
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                super.enter(event, x, y, pointer, fromActor);
                callback.call();
            }
        });
    }

    public void onExit(final Callback callback){
        addListener(new InputListener(){
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                super.exit(event, x, y, pointer, fromActor);
                callback.call();
            }
        });
    }

    public void onClick(Callback callback){
        inputListener = new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                callback.call();
                return true;
            }
        };

        addListener(inputListener);
    }

    public void removeListener(){
        if(inputListener != null) {
            removeListener(inputListener);
            inputListener = null;
        }
    }


}
