package com.mygdx.game.Config;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MyStage extends Stage {
    public final VerticalGroup topLeft, topCenter, topRight, middleLeft, middleCenter, middleRight, bottomLeft, bottomCenter, bottomRight;
    Table table;

    int pad = 0;
    int space = 2;

    public MyStage(Viewport viewport) {
        super(viewport);

        table = new Table();
        table.setFillParent(true);
        //table.setDebug(true);

        topLeft = new VerticalGroup().space(space);
        topCenter = new VerticalGroup().space(space);
        topRight = new VerticalGroup().space(space);
        middleLeft = new VerticalGroup().space(space);
        middleCenter = new VerticalGroup().space(space);
        middleRight = new VerticalGroup().space(space);
        bottomLeft = new VerticalGroup().space(space);
        bottomCenter = new VerticalGroup().space(space);
        bottomRight = new VerticalGroup().space(space);

        table.add(topLeft).pad(pad).top().left();
        table.add(topCenter).pad(pad).top().expand();
        table.add(topRight).pad(pad).top().right();
        table.row();
        table.add(middleLeft).pad(pad).left();
        table.add(middleCenter).pad(pad).expand();
        table.add(middleRight).pad(pad).right();
        table.row();
        table.add(bottomLeft).pad(pad).bottom().left();
        table.add(bottomCenter).pad(pad).bottom().expand();
        table.add(bottomRight).pad(pad).bottom().right();

        addActor(table);
    }
}