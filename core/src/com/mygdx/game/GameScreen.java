package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Config.BaseScreen;
import com.mygdx.game.Objects.Gatito;

public class GameScreen extends BaseScreen {

    public GameScreen(MyGdxGame game) {
        super(game);
    }
    Gatito P1 = new Gatito(300, 270, false, Cosingas.renderizador.pj1);
    Gatito P2 = new Gatito(750, 270, true, Cosingas.renderizador.pj2);

//    private Texture background = new Texture("pui.png");
    private Texture background = new Texture("fondo_desierto.png");
//    private Texture background = new Texture("yMLAGVx.gif");

    @Override
    public void show() {
        System.out.println(Cosingas.renderizador.pj1);
        System.out.println(Cosingas.renderizador.pj2);
        stage.addActor(P1);
        stage.addActor(P2);

        System.out.println(Cosingas.renderizador.mano.cartaList.get(0));

        for (int i = 0; i <3 ; i++) {

            if(i == 0) Cosingas.renderizador.mano.cartaList.get(i).setPosition(Cosingas.renderizador.mano.dx,Cosingas.renderizador.mano.dy);
            else if(i == 1) Cosingas.renderizador.mano.cartaList.get(i).setPosition(Cosingas.renderizador.mano.dx+250,Cosingas.renderizador.mano.dy);
            else Cosingas.renderizador.mano.cartaList.get(i).setPosition(Cosingas.renderizador.mano.dx+250*2,Cosingas.renderizador.mano.dy);

            stage.addActor(Cosingas.renderizador.mano.cartaList.get(i));
            System.out.println(Cosingas.renderizador.mano.cartaList.get(i).nombre);

        }

//        while(!Cosingas.renderizador.acabat){
            /*
            si es el turno del cliente
                hacer jugada
                pasarla al server
                el server
             */
//        }
//        onclik(){
//            Cosigncas.juego.jugar(carta);
//        }

     //  no borrar :
//        gatito.addAction(Actions.moveBy(30, 30, 1));
//        gatito.addAction(Actions.rotateBy(360 * 10, 0.2f));
        Cosingas.renderizador.mano.cartaList.get(0).addListener(() -> Cosingas.renderizador.touched(Cosingas.renderizador.mano.cartaList.get(0), P1, P2));

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

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