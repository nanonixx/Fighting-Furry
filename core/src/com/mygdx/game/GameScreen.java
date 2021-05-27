package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.Config.BaseImageButton;
import com.mygdx.game.Config.BaseScreen;
import com.mygdx.game.Config.MyActor;
import com.mygdx.game.Config.MyLabel;
import com.mygdx.game.Objects.Carta;
import com.mygdx.game.Objects.Gatito;
import com.mygdx.game.Objects.Mano;
import main.java.Mensaje;

public class GameScreen extends BaseScreen {

    private Sound fight;

    public GameScreen(MyGdxGame game) {
        super(game);
        fight = Gdx.audio.newSound(Gdx.files.internal("sounds/fight_sound.ogg"));
        fight.play();
        Cosingas.music.stop();
        Cosingas.music = Gdx.audio.newMusic(Gdx.files.internal("sounds/battle_01.ogg"));
        Cosingas.music.setVolume(0.25f);
        Cosingas.music.setLooping(true);
        Cosingas.music.play();
    }

    private Texture background = new Texture(Cosingas.juego.bg);

    Image saludright = new Image(new Texture("hud/salud_right.png"));
    Image saludleft = new Image(new Texture("hud/salud_left.png"));
    Image cristalright = new Image(new Texture("hud/cristal_right.png"));
    Image cristalleft = new Image(new Texture("hud/cristal_left.png"));
    Image defright = new Image(new Texture("hud/def_right.png"));
    Image defleft = new Image(new Texture("hud/def_left.png"));
    Image attackright = new Image(new Texture("hud/attackboost_right.png"));
    Image attackleft = new Image(new Texture("hud/attackboost_left.png"));
    Image venenoleft = new Image(new Texture("hud/veneno.png"));
    Image venenoright = new Image(new Texture("hud/veneno.png"));

    Image letreringo = new Image(new Texture("Cartel/letreringo.png"));
    Image mazo = new Image(new Texture("mazo2.png"));

    MyLabel saludP1 = new MyLabel("", Color.BLACK, 143f, 646f);
    MyLabel saludP2 = new MyLabel("", Color.BLACK, 1090f, 646f);
    MyLabel manaP1 = new MyLabel("", Color.BLACK, 153f, 560f);
    MyLabel manaP2 = new MyLabel("", Color.BLACK, 1100f, 560f);
    MyLabel attack1 = new MyLabel("", Color.BLACK, 153f, 470f);
    MyLabel attack2 = new MyLabel("", Color.BLACK, 1090f, 470f);
    MyLabel def1 = new MyLabel("", Color.BLACK, 153f, 390f);
    MyLabel def2 = new MyLabel("", Color.BLACK, 1090, 390f);
    MyLabel mostrarTurno = new MyLabel("",Color.BLACK, 567,669);
    BaseImageButton endTurn = new BaseImageButton("endturn.png", "endturn_botonado.png", 170, 80, 1050, 86);

    public Carta carta;
    public boolean jugadaOk = false;
    private Sound turn = Gdx.audio.newSound(Gdx.files.internal("sounds/menu_select.ogg"));
    private Sound lanzar = Gdx.audio.newSound(Gdx.files.internal("sounds/tirar_sound.mp3"));

      //    private Texture background = new Texture("pui.png");

    @Override
    public void show() {
        mostrarCartas();

        //  no borrar :
//        gatito.addAction(Actions.moveBy(30, 30, 1));
//        gatito.addAction(Actions.rotateBy(360 * 10, 0.2f));
        saludleft.setPosition(68,606);
        saludright.setPosition(1051,606);
        cristalleft.setPosition(68,521);
        cristalright.setPosition(1058,521);
        attackleft.setPosition(68,436);
        attackright.setPosition(1051, 436);
        defleft.setPosition(68,350);
        defright.setPosition(1051, 350);
        venenoleft.setPosition(110, 620);
        venenoright.setPosition(1150, 620);
        venenoleft.setVisible(false);
        venenoright.setVisible(false);

        letreringo.setPosition(530, 640);
        letreringo.setVisible(false);
        mazo.setPosition(50, 2);

        game.getBaseScreen().stage.addActor(saludright);
        game.getBaseScreen().stage.addActor(saludleft);
        game.getBaseScreen().stage.addActor(cristalright);
        game.getBaseScreen().stage.addActor(cristalleft);
        game.getBaseScreen().stage.addActor(defright);
        game.getBaseScreen().stage.addActor(defleft);
        game.getBaseScreen().stage.addActor(attackright);
        game.getBaseScreen().stage.addActor(attackleft);

        game.getBaseScreen().stage.addActor(letreringo);
        game.getBaseScreen().stage.addActor(mazo);

        game.getBaseScreen().stage.addActor(Cosingas.juego.P1);
        game.getBaseScreen().stage.addActor(Cosingas.juego.P2);
        game.getBaseScreen().stage.addActor(saludP1);
        game.getBaseScreen().stage.addActor(saludP2); //no se si hay que meter en bucle
        game.getBaseScreen().stage.addActor(manaP1);
        game.getBaseScreen().stage.addActor(manaP2);
        game.getBaseScreen().stage.addActor(attack1);
        game.getBaseScreen().stage.addActor(attack2);
        game.getBaseScreen().stage.addActor(def1);
        game.getBaseScreen().stage.addActor(def2);
        game.getBaseScreen().stage.addActor(endTurn);
        game.getBaseScreen().stage.addActor(mostrarTurno);
        game.getBaseScreen().stage.addActor(venenoleft);
        game.getBaseScreen().stage.addActor(venenoright);
    }

    @Override
    public void mensaje(Mensaje mensaje) {
        switch (mensaje.action) {
            case "turno":
                if(!Cosingas.juego.P1.skipTurno){
                    if(mensaje.turno) {
                        if(Cosingas.juego.P1.turnoCount == 1){
                            Cosingas.juego.P1.defensa += 3;
                            Cosingas.juego.P1.turnoCount++;
                        }else if(Cosingas.juego.P1.turnoCount == 2){
                            Cosingas.juego.P1.defensa += 3;
                            Cosingas.juego.P1.turnoCount = 0;
                        }
                        if(Cosingas.juego.P2.turnoCount == 1){
                            Cosingas.juego.P2.defensa += 3;
                            Cosingas.juego.P2.turnoCount++;
                        }else if(Cosingas.juego.P2.turnoCount == 2){
                            Cosingas.juego.P2.defensa += 3;
                            Cosingas.juego.P2.turnoCount = 0;
                        }
                        Cosingas.juego.P1.cristales = 3;
                        mostrarTurno.setText("TU TURNO");
                        letreringo.setVisible(true);
                        activarListeners();
                    } else {
                        Cosingas.juego.P2.cristales = 3;
                        mostrarTurno.setText("");
                        letreringo.setVisible(false);
                        desactivarListeners();
                    }
                }else{
                    Cosingas.juego.changeTurn();
                    Cosingas.juego.P1.skipTurno = false;
                }
                if (Cosingas.juego.P1.envenenado) Cosingas.juego.P1.salud -= 3;
                if (Cosingas.juego.P2.envenenado) Cosingas.juego.P2.salud -= 3;
                mostrarSaludMana();
                break;
            case "jugadaOk":
                System.out.println("\n"+mensaje.carta.nombre);
                jugadaOk(mensaje.carta, mensaje.furiadanyo);
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
            turn.play();
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
        lanzar.play();
        carta.lanzarCarta(560,296);
        Cosingas.juego.mano.cartaList.remove(carta);
        Cosingas.juego.jugarCarta(carta, propio, rival);
        propio.getMove().punch(propio);
        propio.animation = Assets.getAnimation(propio.getMove().getName(), propio.getMove().getMs(), propio.getMove().loopMode());
        //TODO ponerlo que lo vea el otro jugador y que vuelva a idle cuando acabe animacion (o se queda parado)
        mostrarSaludMana();
        checkWinner();
    }


    void mostrarSaludMana(){
        saludP1.setText(String.valueOf(Cosingas.juego.P1.salud));
        saludP2.setText(String.valueOf(Cosingas.juego.P2.salud));
        manaP1.setText(String.valueOf(Cosingas.juego.P1.cristales));
        manaP2.setText(String.valueOf(Cosingas.juego.P2.cristales));
        attack1.setText(String.valueOf(Cosingas.juego.P1.atBoost));
        attack2.setText(String.valueOf(Cosingas.juego.P2.atBoost));
        def1.setText(String.valueOf(Cosingas.juego.P1.defensa));
        def2.setText(String.valueOf(Cosingas.juego.P2.defensa));
        venenoleft.setVisible(Cosingas.juego.P1.envenenado);
        venenoright.setVisible(Cosingas.juego.P2.envenenado);
    }

    public void jugadaOk(Mensaje.Carta carta, int furiadaño) {
        this.carta = new Carta(carta.nombre, carta.descripcion, carta.costeMana, carta.valor, carta.tipo);
        stage.addActor(this.carta);
        this.carta.mostrarCarta(564, 304);
        Cosingas.juego.P2.getMove().punch(Cosingas.juego.P2);
        Cosingas.juego.P2.animation = Assets.getAnimation(Cosingas.juego.P2.getMove().getName(), Cosingas.juego.P2.getMove().getMs(), Cosingas.juego.P2.getMove().loopMode());
        Cosingas.juego.procesarJugada(this.carta, Cosingas.juego.P1, Cosingas.juego.P2, furiadaño);
        mostrarSaludMana();
        checkWinner();
        jugadaOk = true;

    }


    public void checkWinner(){
        if(Cosingas.juego.P1.salud <= 0 || Cosingas.juego.P2.salud <= 0){
            setScreen(new FinalScreen(game));
        }
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