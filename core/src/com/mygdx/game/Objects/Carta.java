package com.mygdx.game.Objects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.mygdx.game.Assets;
import com.mygdx.game.Config.MyActor;
import main.java.Mensaje;

import static com.badlogic.gdx.utils.Align.center;

public class Carta extends MyActor {
    public String nombre;
    public String descripcion;
    public int coste_mana;
    public int valor;
    public String tipo;

    public Carta(String nombre, String descripcion, int coste_mana, int valor, String tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.coste_mana = coste_mana;
        this.valor = valor;
        this.tipo = tipo;
//        WIDTH = 550;
//        HEIGHT = 350;

        setSize(172, 234);
        setOrigin(center);
        //setSize(,);
        //setOrigin(Align.center);

        asignarSkinCarta(nombre);
        //animation = Assets.getAnimation("patadaPRUEBA", 10, Animation.PlayMode.LOOP);

//        addListener(() -> Cosingas.renderizador.touched(Carta.this));
    }

//    public Carta(String nombre, int valor) {
//        this.nombre = nombre;
//    }

    //métodos: mensaje al server, repartir, lanzarCarta

    static Carta fromMensaje(Mensaje.Carta carta){
        return new Carta(carta.nombre, carta.descripcion, carta.costeMana, carta.valor, carta.tipo);
    }

    Mensaje.Carta toMensaje(){
        return new Mensaje.Carta(nombre, descripcion, coste_mana, valor, tipo);
    }

    public void mostrarCarta(float x, float y){
        setPosition(x,y);
        addAction(
                Actions.sequence(
                        Actions.fadeOut(1f),
                        Actions.hide()
                )
        );

        //remove();

    }

    public void lanzarCarta(float x, float y){
        addAction(
                Actions.sequence(
                        Actions.parallel(
                                Actions.rotateBy(40, 0.4f, Interpolation.fastSlow),
                                Actions.moveTo(x/2, y/2, 0.4f, Interpolation.fastSlow)
                        ),
                        Actions.parallel(
                                Actions.rotateBy(-40, 0.3f, Interpolation.fastSlow),
                                Actions.moveTo(x, y, 0.3f, Interpolation.fastSlow)
                        ),
                        Actions.fadeOut(1f),
                        Actions.hide()
                )
        );
    }

    public void asignarSkinCarta(String nombre){
        switch(nombre){
            case "zarpazo":
                animation = Assets.getAnimation("zarpazo", 10, Animation.PlayMode.LOOP);
                break;
            case "mordisco":
                animation = Assets.getAnimation("mordisco", 10, Animation.PlayMode.LOOP);
                break;
            case "bufido":
                animation = Assets.getAnimation("bufido", 10, Animation.PlayMode.LOOP);
                break;
            case "enAlerta":
                animation = Assets.getAnimation("alertaMaxima", 10, Animation.PlayMode.LOOP);
                break;
            case "ronroneo":
                animation = Assets.getAnimation("ronroneo", 10, Animation.PlayMode.LOOP);
                break;
            case "amasar":
                animation = Assets.getAnimation("amasar", 10, Animation.PlayMode.LOOP);
                break;
            case "canvidelloc instantani":
                animation = Assets.getAnimation("imagenReflejo", 10, Animation.PlayMode.LOOP);
                break;
            case "kame":
                animation = Assets.getAnimation("kame", 10, Animation.PlayMode.LOOP);
                break;
            case "heehee":
                animation = Assets.getAnimation("hehe", 10, Animation.PlayMode.LOOP);
                break;
            case "antigravitylean":
                animation = Assets.getAnimation("antiGravity", 10, Animation.PlayMode.LOOP);
                break;
            case "cabezazo":
                animation = Assets.getAnimation("cabezazo", 10, Animation.PlayMode.LOOP);
                break;
            case "pisoton":
                animation = Assets.getAnimation("pisoton", 10, Animation.PlayMode.LOOP);
                break;
            case "autocracia":
                animation = Assets.getAnimation("autocracia", 10, Animation.PlayMode.LOOP);
                break;
            case "pactodeacero":
                animation = Assets.getAnimation("pactoAcero", 10, Animation.PlayMode.LOOP);
                break;
            case "patadavoladora":
                animation = Assets.getAnimation("patadaVoladora", 10, Animation.PlayMode.LOOP);
                break;
            case "furiaoriental":
                animation = Assets.getAnimation("furiaOriental", 10, Animation.PlayMode.LOOP);
                break;
            case "vomitoradioactivo":
                animation = Assets.getAnimation("vomitoRadioactivo", 10, Animation.PlayMode.LOOP);
                break;
            case "poloniooplomo":
                animation = Assets.getAnimation("polonioPlomo", 10, Animation.PlayMode.LOOP);
                break;
        }
    }

}
