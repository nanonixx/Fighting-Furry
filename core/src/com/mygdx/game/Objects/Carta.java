package com.mygdx.game.Objects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.mygdx.game.Assets;
import com.mygdx.game.Config.MyActor;
import main.java.Mensaje;

import static com.badlogic.gdx.utils.Align.center;

public class Carta extends MyActor {
    public String nombre;
    String descripcion;
    int coste_mana;
    int valor;
    String tipo;

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

    public void accionRepartir(){}

    public void lanzarCarta(){}

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
            case "canvi de lloc instantani":
                animation = Assets.getAnimation("imagenReflejo", 10, Animation.PlayMode.LOOP);
                break;
            case "kame":
                animation = Assets.getAnimation("kame", 10, Animation.PlayMode.LOOP);
                break;
            case "heehee":
                animation = Assets.getAnimation("hehe", 10, Animation.PlayMode.LOOP);
                break;
            case "antigravity lean":
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
            case "pacto de acero":
                animation = Assets.getAnimation("pactoAcero", 10, Animation.PlayMode.LOOP);
                break;
            case "patada voladora":
                animation = Assets.getAnimation("patadaVoladora", 10, Animation.PlayMode.LOOP);
                break;
            case "furia oriental":
                animation = Assets.getAnimation("furiaOriental", 10, Animation.PlayMode.LOOP);
                break;
            case "vomito radioactivo":
                animation = Assets.getAnimation("vomitoRadioactivo", 10, Animation.PlayMode.LOOP);
                break;
            case "polonio o plomo":
                animation = Assets.getAnimation("polonioPlomo", 10, Animation.PlayMode.LOOP);
                break;
        }
    }

}
