package com.mygdx.game.Config;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.Assets;

public class BaseImageButton extends ImageButton {
    public BaseImageButton(String image_up, String image_over, int ancho, int alto, int x,int y){
        super(new ImageButtonStyle());

        getStyle().up = new TextureRegionDrawable(new TextureRegion(new Texture(image_up)));
        getStyle().over = new TextureRegionDrawable(new TextureRegion(new Texture(image_over)));
        setSize(ancho, alto);
        setPosition(x, y);
    }
}
