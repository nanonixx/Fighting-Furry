package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.compression.lzma.Base;
import com.mygdx.game.Config.BaseImageButton;
import com.mygdx.game.Config.BaseScreen;

public class SelectionScreen extends BaseScreen {


    private Texture background;
    Image pj = new Image();

    public SelectionScreen(MyGdxGame game) {
        super(game);
    }

    @Override
    public void show(){


        background = new Texture("fondaso.png");

        BaseImageButton buttonReady = new BaseImageButton("readyButton.png", "readyButtonPressed.png", 240, 64, 525, 54);
        stage.addActor(buttonReady);


        Image header = new Image(new Texture("selectFighter.png"));
        header.setPosition(366, 610);

        stage.topCenter.addActor(header);

        //FRAMES DE LOS PERSONAJES PARA LA SELECCIÓN
        BaseImageButton gokuFrame = new BaseImageButton("gokuSelection.png", "gokuSelected.png", 107, 107, 491, 458);
        //poner cosingas al hacer click
        gokuFrame.onClick(() -> {});
        gokuFrame.onEnter(() -> showPj(stage, "gokuitot.png"));


        BaseImageButton furrieFrame = new BaseImageButton("furrieSelection.png", "furrieSelected.png", 107, 107, 491, 307);
        furrieFrame.onClick(()->{});
        furrieFrame.onEnter(() -> showPj(stage, "curie.png"));

        BaseImageButton leeFrame = new BaseImageButton("leeSelection.png", "leeSelected.png", 107, 107, 491, 156);
        leeFrame.onClick(()->{});
        leeFrame.onEnter(()->{showPj(stage, "miaulee.png");});

        BaseImageButton jacksonFrame = new BaseImageButton("miauchaelSelection.png", "miauchaelSelected.png", 107, 107, 662, 459);
        jacksonFrame.onClick(()->{});
        jacksonFrame.onEnter(()->{showPj(stage, "heeHEE.png");});

        BaseImageButton pateFrame = new BaseImageButton("pateSelection.png", "pateSelected.png", 107, 107, 662, 307);
        pateFrame.onClick(()->{});
        pateFrame.onEnter(()->{showPj(stage, "pate2.png");});

        BaseImageButton pussoliniFrame = new BaseImageButton("pussoliniSelection.png", "pussoliniSelected.png", 107, 107, 662, 156);
        pussoliniFrame.onClick(()->{});
        pussoliniFrame.onEnter(()->{showPj(stage, "PUSSOLINI.png");});

        stage.addActor(gokuFrame);
        stage.addActor(furrieFrame);
        stage.addActor(leeFrame);
        stage.addActor(jacksonFrame);
        stage.addActor(pateFrame);
        stage.addActor(pussoliniFrame);

    }

    @Override
    public void render(float delta) {
        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0);
        stage.getBatch().end();
        stage.act(delta);
        stage.draw();
    }

    //metodo para cargar los sprites cuando se seleccionan
    public void showPj(MyStage stage, String frame){
        if(pj.getStage() != null) pj.remove();
        pj = new Image(new Texture("Selection/" + frame));
        pj.setPosition(72, 131);
        pj.setSize(304, 426);
        stage.addActor(pj);
    }
}
