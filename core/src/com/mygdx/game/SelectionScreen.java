package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.Config.BaseImageButton;
import com.mygdx.game.Config.BaseScreen;
import com.mygdx.game.Config.MyStage;
import com.mygdx.game.Objects.Gatito;
import com.mygdx.game.Objects.Juego;
import com.mygdx.game.Objects.Mano;
import main.java.Mensaje;


public class SelectionScreen extends BaseScreen {

    private boolean selected = false;
    private Texture background;
    Image pj = new Image();
    Image cartel = new Image();
    private String pjSeleccionado = null;
    String mantenerSeleccionado;
    Sound selectSound;
    Sound selectedSound;

    public SelectionScreen(MyGdxGame game) {
        super(game);
    }

    @Override
    public void mensaje(Mensaje mensaje) {
        switch (mensaje.action) {
            case "ready_ok":
//                mostrarMensaje("CONECTADO");
                break;
            case "start":
                Cosingas.juego.P1 = new Gatito(300, 270, false, mensaje.gato);
                Cosingas.juego.P2 = new Gatito(750, 270, true, mensaje.gato2);
                Cosingas.juego.mano = Mano.fromMensaje(mensaje.mano);
                Cosingas.juego.torn = mensaje.turno;
                Cosingas.juego.bg = mensaje.background;
                setScreen(new GameScreen(game));
                break;
            default:
                System.out.println(mensaje.action);
        }
    }

    @Override
    public void show() {

        background = new Texture("fondaso.png");

        selectSound = Gdx.audio.newSound(Gdx.files.internal("sounds/meow_03.wav"));
        selectedSound = Gdx.audio.newSound(Gdx.files.internal("sounds/menu_select.ogg"));

        BaseImageButton buttonBack = new BaseImageButton("button/atras.png", "button/atras_botonado.png", 75, 75, 4, 639);
        stage.addActor(buttonBack);


        BaseImageButton buttonReady = new BaseImageButton("select.png", "select_botonado.png", 190, 90, 805, 54);
        stage.addActor(buttonReady);

        buttonReady.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if(pjSeleccionado != null){
                    selectedSound.play(1.0f);
                    Cosingas.juego.ready(pjSeleccionado);
                }
//                setScreen(new GameScreen(game));
                return super.touchDown(event, x, y, pointer, button);
            }
        });

        buttonBack.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                setScreen(new PantallaInicial(game));
                return super.touchDown(event, x, y, pointer, button);
            }
        });

//        Image header = new Image(new Texture("selectFighter.png"));
//        header.setPosition(366, 610);

//        stage.topCenter.addActor(header);

        //FRAMES DE LOS PERSONAJES PARA LA SELECCIÓN
        BaseImageButton gokuFrame = new BaseImageButton("gokuSelection.png", "gokuSelected.png", 175, 175, 570, 420);
        gokuFrame.onEnter(() -> showPj(stage, "gokuitot.png"));


        BaseImageButton furrieFrame = new BaseImageButton("furrieSelection.png", "furrieSelected.png", 175, 175, 810, 420);
        furrieFrame.onEnter(() -> showPj(stage, "curie.png"));

        BaseImageButton leeFrame = new BaseImageButton("leeSelection.png", "leeSelected.png", 175, 175, 1050, 420);
        leeFrame.onEnter(() -> {
            showPj(stage, "miaulee.png");
        });

        BaseImageButton jacksonFrame = new BaseImageButton("miauchaelSelection.png", "miauchaelSelected.png", 175, 175, 570, 212);
        jacksonFrame.onEnter(() -> {
            showPj(stage, "heeHEE.png");
        });

        BaseImageButton pateFrame = new BaseImageButton("pateSelection.png", "pateSelected.png", 175, 175, 810, 212);
        pateFrame.onEnter(() -> {
            showPj(stage, "pate2.png");
        });

        BaseImageButton pussoliniFrame = new BaseImageButton("pussoliniSelection.png", "pussoliniSelected.png", 175, 175, 1050, 212);
        pussoliniFrame.onEnter(() -> {
            showPj(stage, "PUSSOLINI.png");
        });

        gokuFrame.onClick(() -> {
            if (!selected) {
                selected = selectPj(gokuFrame, "goku");
                pjSeleccionado = "goku";
            } else {
                unselectPjs(gokuFrame, furrieFrame, leeFrame, jacksonFrame, pateFrame, pussoliniFrame);
                selected = selectPj(gokuFrame, "goku");
            }
            mantenerSeleccionado = "gokuitot.png";
            selectSound.play(1.0f);
        });
        furrieFrame.onClick(() -> {
            if (!selected) {
                pjSeleccionado = "furrie";
                selected = selectPj(furrieFrame, "furrie");
            } else {
                unselectPjs(gokuFrame, furrieFrame, leeFrame, jacksonFrame, pateFrame, pussoliniFrame);
                selected = selectPj(furrieFrame, "furrie");
            }
            mantenerSeleccionado = "curie.png";
            selectSound.play(1.0f);
        });
        leeFrame.onClick(() -> {
            if (!selected) {
                pjSeleccionado = "lee";
                selected = selectPj(leeFrame, "lee");
            } else {
                unselectPjs(gokuFrame, furrieFrame, leeFrame, jacksonFrame, pateFrame, pussoliniFrame);
                selected = selectPj(leeFrame, "lee");
            }
            selectSound.play(1.0f);
        });
        jacksonFrame.onClick(() -> {
            if (!selected) {
                selected = selectPj(jacksonFrame, "miauchael");
                pjSeleccionado = "jackson";
            } else {
                unselectPjs(gokuFrame, furrieFrame, leeFrame, jacksonFrame, pateFrame, pussoliniFrame);
                selected = selectPj(jacksonFrame, "miauchael");
            }

            selectSound.play(1.0f);
        });
        pateFrame.onClick(() -> {
            if (!selected) {
                selected = selectPj(pateFrame, "pate");
                pjSeleccionado = "pate";
            } else {
                unselectPjs(gokuFrame, furrieFrame, leeFrame, jacksonFrame, pateFrame, pussoliniFrame);
                selected = selectPj(pateFrame, "pate");
            }
            selectSound.play(1.0f);
        });
        pussoliniFrame.onClick(() -> {
            if (!selected) {
                selected = selectPj(pussoliniFrame, "pussolini");
                pjSeleccionado = "pussolini";
            } else {
                unselectPjs(gokuFrame, furrieFrame, leeFrame, jacksonFrame, pateFrame, pussoliniFrame);
                selected = selectPj(pussoliniFrame, "pussolini");
            }
            selectSound.play(1.0f);
        });


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
    public void showPj(MyStage stage, String frame) {
        if (pj.getStage() != null) pj.remove();
        if (cartel.getStage() != null) cartel.remove();

        pj = new Image(new Texture("Selection/" + frame));
        pj.setPosition(160, 150);
        pj.setSize(304, 426);

        cartel = new Image(new Texture("Cartel/" + frame));
        cartel.setPosition(115, 50);

        stage.addActor(pj);
        stage.addActor(cartel);
    }

    public boolean selectPj(BaseImageButton frame, String framename) {
        frame.getStyle().up = new TextureRegionDrawable(new TextureRegion(new Texture(framename + "Selected.png")));
        return true;
    }

    public boolean unselectPjs(BaseImageButton goku, BaseImageButton curie, BaseImageButton lee, BaseImageButton jackson, BaseImageButton pate, BaseImageButton puss) {
        goku.getStyle().up = new TextureRegionDrawable(new TextureRegion(new Texture("gokuSelection.png")));
        curie.getStyle().up = new TextureRegionDrawable(new TextureRegion(new Texture("furrieSelection.png")));
        lee.getStyle().up = new TextureRegionDrawable(new TextureRegion(new Texture("leeSelection.png")));
        jackson.getStyle().up = new TextureRegionDrawable(new TextureRegion(new Texture("miauchaelSelection.png")));
        pate.getStyle().up = new TextureRegionDrawable(new TextureRegion(new Texture("pateSelection.png")));
        puss.getStyle().up = new TextureRegionDrawable(new TextureRegion(new Texture("pussoliniSelection.png")));
        return false;
    }
}
