package com.mygdx.game.Config;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class MyLabel extends Label {
    static LabelStyle sLabelStyle = new LabelStyle();
    static {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Pixeled.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 8;
        sLabelStyle.font = generator.generateFont(parameter);
    }

    LabelStyle labelStyle;

    public MyLabel(){
        super("", sLabelStyle);
//
//        labelStyle = new LabelStyle();
//        labelStyle.font = new BitmapFont();
//
//        setStyle(labelStyle);
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
        setFontScale(2.5f);
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