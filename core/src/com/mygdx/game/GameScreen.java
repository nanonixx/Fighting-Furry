package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.game.Config.BaseImageButton;
import com.mygdx.game.Config.BaseScreen;
import com.mygdx.game.Config.MyActor;
import com.mygdx.game.Config.MyLabel;
import com.mygdx.game.Objects.Carta;
import com.mygdx.game.Objects.Gatito;
import com.mygdx.game.Objects.Mano;
import main.java.Mensaje;

public class GameScreen extends BaseScreen {

    public GameScreen(MyGdxGame game) {
        super(game);
    }

    //    private Texture background = new Texture("pui.png");
    private Texture background = new Texture("fondo_desierto.png");
    //    private Texture background = new Texture("yMLAGVx.gif");

    MyLabel saludP1 = new MyLabel("", Color.BLACK, 100f, 600f);
    MyLabel saludP2 = new MyLabel("", Color.BLACK, 1050f, 600f);
    MyLabel manaP1 = new MyLabel("", Color.BLACK, 100f, 550f);
    MyLabel manaP2 = new MyLabel("", Color.BLACK, 1050f, 550f);
    MyLabel mostrarTurno = new MyLabel("",Color.BLACK, 574,616);
    BaseImageButton endTurn = new BaseImageButton("endTurn.png", "endTurnOver.png", 154, 49, 1067, 86);

    public Carta carta;
    public boolean jugadaOk = false;

      //    private Texture background = new Texture("pui.png");

    @Override
    public void show() {
        mostrarCartas();

        //  no borrar :
//        gatito.addAction(Actions.moveBy(30, 30, 1));
//        gatito.addAction(Actions.rotateBy(360 * 10, 0.2f));

        game.getBaseScreen().stage.addActor(Cosingas.juego.P1);
        game.getBaseScreen().stage.addActor(Cosingas.juego.P2);
        game.getBaseScreen().stage.addActor(saludP1);
        game.getBaseScreen().stage.addActor(saludP2); //no se si hay que meter en bucle
        game.getBaseScreen().stage.addActor(manaP1);
        game.getBaseScreen().stage.addActor(manaP2);
        game.getBaseScreen().stage.addActor(endTurn);
        game.getBaseScreen().stage.addActor(mostrarTurno);


    }

    @Override
    public void mensaje(Mensaje mensaje) {
        switch (mensaje.action) {
            case "turno":
                if(mensaje.turno) {
                    Cosingas.juego.P1.cristales = 3;
                    mostrarTurno.setText("TU TURNO");
                    activarListeners();
                } else {
                    Cosingas.juego.P2.cristales = 3;
                    mostrarTurno.setText("");
                    desactivarListeners();
                }
                mostrarSaludMana();
                break;
            case "jugadaOk":
                System.out.println("\n"+mensaje.carta.nombre);
                jugadaOk(mensaje.carta);
                mostrarSaludMana();
                break;
            case "refillCartas":
                quitarCartas();
                Cosingas.juego.mano = Mano.fromMensaje(mensaje.mano);
                mostrarCartas();
                break;
            default:
                System.out.println(mensaje.action);
        }
    }



    private void activarListeners() {
        Cosingas.juego.mano.cartaList.forEach(carta -> {
            carta.setListener(() -> {
                if(Cosingas.juego.P1.cristales >=carta.coste_mana){
                    Cosingas.juego.P1.cristales -= carta.coste_mana;
                    touched(carta, Cosingas.juego.P1, Cosingas.juego.P2);
                }
            });
        });


        endTurn.onClick(() -> {
            Cosingas.juego.changeTurn();
        });
    }

    private void desactivarListeners() {
        Cosingas.juego.mano.cartaList.forEach(MyActor::removeListener);
        endTurn.removeListener();
    }

    public void mostrarCartas(){

        for (int i = 0; i <3 ; i++) {
            if(i == 0) Cosingas.juego.mano.cartaList.get(i).setPosition(Cosingas.juego.mano.dx,Cosingas.juego.mano.dy);
            else if(i == 1) Cosingas.juego.mano.cartaList.get(i).setPosition(Cosingas.juego.mano.dx+250,Cosingas.juego.mano.dy);
            else Cosingas.juego.mano.cartaList.get(i).setPosition(Cosingas.juego.mano.dx+250*2,Cosingas.juego.mano.dy);

            stage.addActor(Cosingas.juego.mano.cartaList.get(i));
            System.out.println(Cosingas.juego.mano.cartaList.get(i).nombre);
        }
    }

    public void quitarCartas(){
        for (Carta c: Cosingas.juego.mano.cartaList) {
            c.remove();
        }
    }

    public void touched(Carta carta, Gatito propio, Gatito rival) {
        carta.lanzarCarta(560,296);
        Cosingas.juego.mano.cartaList.remove(carta);
        Cosingas.juego.jugarCarta(carta, propio, rival);
        mostrarSaludMana();
    }

    void mostrarSaludMana(){
        saludP1.setText(String.valueOf(Cosingas.juego.P1.salud));
        saludP2.setText(String.valueOf(Cosingas.juego.P2.salud));
        manaP1.setText(String.valueOf(Cosingas.juego.P1.cristales));
        manaP2.setText(String.valueOf(Cosingas.juego.P2.cristales));
    }

    public void jugadaOk(Mensaje.Carta carta) {
        this.carta = new Carta(carta.nombre, carta.descripcion, carta.costeMana, carta.valor, carta.tipo);
        Cosingas.juego.procesarJugada(this.carta, Cosingas.juego.P1, Cosingas.juego.P2);
        mostrarSaludMana();
        jugadaOk = true;
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //para poner la carta que juega el rival y procesarla
//        if(Cosingas.juego.jugadaOk){
//            stage.addActor(Cosingas.juego.carta);
//            Cosingas.juego.carta.mostrarCarta(560, 296);
//            Cosingas.juego.procesarJugada(Cosingas.juego.carta, P1, P2);
//            Cosingas.juego.jugadaOk = false;
//        }



        //PRUEBAS DE LAS ANIMACIONES
        //Testingo P1:
//        if(Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
//           P1.getMove().kick(P1);
//            P1.animation = Assets.getAnimation(P1.getMove().getName(), P1.getMove().getMs(), P1.getMove().loopMode());
//            P1.getMove().kick2(P1);
//            P1.animation = Assets.getAnimation(P1.getMove().getName(), P1.getMove().getMs(), P1.getMove().loopMode());
//        }
//        //cuando el gato deje de hacer la animación vuelve a idle
//        else if (P1.animation.isAnimationFinished(P1.stateTime)){
//            P1.getMove().idle(P1);
//            P1.animation = Assets.getAnimation(P1.getMove().getName(), P1.getMove().getMs(), P1.getMove().loopMode());
//        }
//
//
//        //Testingo P2:
//        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
//            P2.getMove().punch(P2);
//            P2.animation = Assets.getAnimation(P2.getMove().getName(), P2.getMove().getMs(), P2.getMove().loopMode());
//        }else if (P1.animation.isAnimationFinished(P1.stateTime)){
//            P2.getMove().idle(P2);
//            P2.animation = Assets.getAnimation(P2.getMove().getName(), P2.getMove().getMs(), P2.getMove().loopMode());
//        }

        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0);
        stage.getBatch().end();
        stage.act(delta);
        stage.draw();
    }
}