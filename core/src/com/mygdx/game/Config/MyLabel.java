package com.mygdx.game.Config;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class MyLabel extends Label {
    static LabelStyle sLabelStyle = new LabelStyle();
    static {
        sLabelStyle.font = new BitmapFont();
    }

    LabelStyle labelStyle;

    public MyLabel(){
        super("", sLabelStyle);

        labelStyle = new LabelStyle();
        labelStyle.font = new BitmapFont();

        setStyle(labelStyle);
    }

    public MyLabel(Color color){
        this();
        getStyle().fontColor = color;
        getStyle().font.getData().setScale(0.5f);
    }

    public MyLabel(CharSequence charSequence, Color color, float x, float y){
        this(color);
        setText(charSequence);
        setPosition(x, y);
        setFontScale(3f);
    }

    public MyLabel(float x, float y, Color color){
        this(color);
        setPosition(x, y);
    }

    public MyLabel(CharSequence charSequence, float x, float y, Color color){
        this(x, y, color);
        setText(charSequence);
    }
}