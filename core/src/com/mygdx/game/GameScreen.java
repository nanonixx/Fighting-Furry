package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.game.Config.BaseImageButton;
import com.mygdx.game.Config.BaseScreen;
import com.mygdx.game.Config.MyLabel;
import com.mygdx.game.Objects.Gatito;

public class GameScreen extends BaseScreen {

    public GameScreen(MyGdxGame game) {
        super(game);
    }
    Gatito P1 = new Gatito(300, 270, false, Cosingas.renderizador.pj1);
    Gatito P2 = new Gatito(750, 270, true, Cosingas.renderizador.pj2);

    MyLabel saludP1 = new MyLabel(String.valueOf(P1.salud), Color.BLACK, 100f, 600f);
    MyLabel saludP2 = new MyLabel(String.valueOf(P2.salud), Color.BLACK, 1050f, 600f);

    MyLabel manaP1 = new MyLabel(String.valueOf(P1.cristales), Color.BLACK, 100f, 550f);
    MyLabel manaP2 = new MyLabel(String.valueOf(P2.cristales), Color.BLACK, 1050f, 550f);

    BaseImageButton endTurn = new BaseImageButton("endTurn.png", "endTurnOver.png", 154, 49, 1067, 86);
//    private Texture background = new Texture("pui.png");
    private Texture background = new Texture("fondo_desierto.png");
//    private Texture background = new Texture("yMLAGVx.gif");

    @Override
    public void show() {
        System.out.println(Cosingas.renderizador.pj1);
        System.out.println(Cosingas.renderizador.pj2);
        stage.addActor(P1);
        stage.addActor(P2);
        stage.addActor(saludP1);
        stage.addActor(saludP2); //no se si hay que meter en bucle
        stage.addActor(manaP1);
        stage.addActor(manaP2);
        stage.addActor(endTurn);



        for (int i = 0; i <3 ; i++) {

            if(i == 0) Cosingas.renderizador.mano.cartaList.get(i).setPosition(Cosingas.renderizador.mano.dx,Cosingas.renderizador.mano.dy);
            else if(i == 1) Cosingas.renderizador.mano.cartaList.get(i).setPosition(Cosingas.renderizador.mano.dx+250,Cosingas.renderizador.mano.dy);
            else Cosingas.renderizador.mano.cartaList.get(i).setPosition(Cosingas.renderizador.mano.dx+250*2,Cosingas.renderizador.mano.dy);

            stage.addActor(Cosingas.renderizador.mano.cartaList.get(i));
            System.out.println(Cosingas.renderizador.mano.cartaList.get(i).nombre);

        }

     //  no borrar :
//        gatito.addAction(Actions.moveBy(30, 30, 1));
//        gatito.addAction(Actions.rotateBy(360 * 10, 0.2f));

        //TODO ARREGLAR LOS LISTENERS PARA CUANDO LA MANO NO ESTÉ ENTERA (1-2 CARTAS)
        //ESTO HABRIA QUE CHECKEARLO EN EL RENDER PERO PETA
        if(Cosingas.renderizador.torn){
            Cosingas.renderizador.mano.cartaList.get(0).addListener(() -> {
                if(P1.cristales >= Cosingas.renderizador.mano.cartaList.get(0).coste_mana){
                    P1.cristales -= Cosingas.renderizador.mano.cartaList.get(0).coste_mana;
                    Cosingas.renderizador.touched(Cosingas.renderizador.mano.cartaList.get(0), P1, P2);
                }

            });
            Cosingas.renderizador.mano.cartaList.get(1).addListener(() -> {
                if(P1.cristales >= Cosingas.renderizador.mano.cartaList.get(1).coste_mana){
                    P1.cristales -= Cosingas.renderizador.mano.cartaList.get(1).coste_mana;
                    Cosingas.renderizador.touched(Cosingas.renderizador.mano.cartaList.get(1), P1, P2);
                }
            });
            Cosingas.renderizador.mano.cartaList.get(2).addListener(() -> {
                if(P1.cristales >= Cosingas.renderizador.mano.cartaList.get(2).coste_mana) {
                    P1.cristales -= Cosingas.renderizador.mano.cartaList.get(2).coste_mana;
                    Cosingas.renderizador.touched(Cosingas.renderizador.mano.cartaList.get(2), P1, P2);
                }
            });

            endTurn.addListener(new InputListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    Cosingas.juego.changeTurn();
                    return super.touchDown(event, x, y, pointer, button);
                }
            });
        }

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //ir actualizando las etiquetas con los datos
        saludP1.setText(P1.salud);
        saludP2.setText(P2.salud);
        manaP1.setText(P1.cristales);
        manaP2.setText(P2.cristales);


        //para poner la carta que juega el rival y procesarla
        if(Cosingas.renderizador.jugadaOk){


            stage.addActor(Cosingas.renderizador.carta);
            Cosingas.renderizador.carta.mostrarCarta(560, 296);
            Cosingas.juego.procesarJugada(Cosingas.renderizador.carta, P1, P2);
            Cosingas.renderizador.jugadaOk = false;

        }



        //PRUEBAS DE LAS ANIMACIONES
        //Testingo P1:
        if(Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
           P1.getMove().kick(P1);
            P1.animation = Assets.getAnimation(P1.getMove().getName(), P1.getMove().getMs(), P1.getMove().loopMode());
            P1.getMove().kick2(P1);
            P1.animation = Assets.getAnimation(P1.getMove().getName(), P1.getMove().getMs(), P1.getMove().loopMode());
        }
        //cuando el gato deje de hacer la animación vuelve a idle
        else if (P1.animation.isAnimationFinished(P1.stateTime)){
            P1.getMove().idle(P1);
            P1.animation = Assets.getAnimation(P1.getMove().getName(), P1.getMove().getMs(), P1.getMove().loopMode());
        }


        //Testingo P2:
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            P2.getMove().punch(P2);
            P2.animation = Assets.getAnimation(P2.getMove().getName(), P2.getMove().getMs(), P2.getMove().loopMode());
        }else if (P1.animation.isAnimationFinished(P1.stateTime)){
            P2.getMove().idle(P2);
            P2.animation = Assets.getAnimation(P2.getMove().getName(), P2.getMove().getMs(), P2.getMove().loopMode());
        }

        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0);

        stage.getBatch().end();
        stage.act(delta);
        stage.draw();


    }
}